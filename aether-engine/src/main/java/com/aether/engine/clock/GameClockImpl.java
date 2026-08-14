/*
    MIT License
    Copyright (c) 2026 Mihály Verhás
    See LICENSE file.
*/
package com.aether.engine.clock;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import com.aether.clock.GameClock;
import com.aether.clock.GameClockListener;
import com.aether.clock.GameSpeed;

/**
 * Default implementation of {@link GameClock}.
 *
 * <p>A plain {@link Thread} runs the tick loop as fast as listeners can keep up — there is no
 * fixed Hz cap. On each tick all registered listeners are dispatched in parallel via an
 * {@link ExecutorService}; the clock waits for every listener to finish before advancing to
 * the next tick. If any listener returns {@code true} the loop exits and the clock pauses.
 *
 * <p>Game time is accumulated internally as nanoseconds in a {@link BigDecimal} so that any
 * {@link TimeUnit} conversion requested via {@link #gameTime(TimeUnit)} is exact for whole-unit
 * steps and uses 34-digit precision otherwise.
 */
public final class GameClockImpl implements GameClock {

	/** Default step: 1 game-hour per tick. */
	private static final GameSpeed DEFAULT_STEP = GameSpeed.of(1L, TimeUnit.HOURS);

	private volatile BigDecimal gameTimeNanos;
	private volatile TickConfig tickConfig;
	private volatile boolean running;
	private final List<GameClockListener> listeners;
	private Thread clockThread;
	private ExecutorService listenerExecutor;

	/**
	 * Creates a new {@code GameClockImpl} paused at time zero with a default step of one
	 * game-hour per tick.
	 */
	public GameClockImpl() {
		gameTimeNanos = BigDecimal.ZERO;
		tickConfig = new TickConfig(DEFAULT_STEP, toNanos(DEFAULT_STEP));
		running = false;
		listeners = new CopyOnWriteArrayList<>();
		listenerExecutor = Executors.newCachedThreadPool(this::createListenerThread);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public GameSpeed gameTime(final TimeUnit unit) {
		final BigDecimal nanosPerUnit = BigDecimal.valueOf(unit.toNanos(1L));
		return GameSpeed.of(gameTimeNanos.divide(nanosPerUnit, MathContext.DECIMAL128), unit);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public GameSpeed gameTime() {
		return gameTime(TimeUnit.SECONDS);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public GameSpeed speed() {
		return tickConfig.step();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized void setSpeed(final GameSpeed newSpeed) {
		tickConfig = new TickConfig(newSpeed, toNanos(newSpeed));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized void start() {
		if (!running) {
			awaitPreviousThread();
			listenerExecutor.shutdown();
			listenerExecutor = Executors.newCachedThreadPool(this::createListenerThread);
			running = true;
			clockThread = new Thread(this::runLoop, "game-clock");
			clockThread.setDaemon(true);
			clockThread.start();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized void pause() {
		running = false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isRunning() {
		return running;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addListener(final GameClockListener listener) {
		listeners.add(listener);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeListener(final GameClockListener listener) {
		listeners.remove(listener);
	}

	private void awaitPreviousThread() {
		if (clockThread != null && clockThread.isAlive()) {
			try {
				clockThread.join();
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
		}
	}

	private Thread createListenerThread(final Runnable runnable) {
		final Thread daemonThread = new Thread(runnable, "game-clock-listener");
		daemonThread.setDaemon(true);
		return daemonThread;
	}

	private static BigDecimal toNanos(final GameSpeed step) {
		return step.value().multiply(BigDecimal.valueOf(step.unit().toNanos(1L)));
	}

	private List<Callable<Boolean>> buildTasks(final GameSpeed step) {
		final List<Callable<Boolean>> tasks = new ArrayList<>();
		for (final GameClockListener listener : listeners) {
			tasks.add(() -> listener.onTick(step));
		}
		return tasks;
	}

	private boolean fireListenersInParallel(final GameSpeed step) {
		final List<Callable<Boolean>> tasks = buildTasks(step);
		boolean pausing;
		if (tasks.isEmpty()) {
			pausing = false;
		} else {
			try {
				final List<Future<Boolean>> results = listenerExecutor.invokeAll(tasks);
				pausing = results.stream().anyMatch(GameClockImpl::getOrFalse);
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
				pausing = false;
			}
		}
		return pausing;
	}

	private static boolean getOrFalse(final Future<Boolean> future) {
		boolean result;
		try {
			result = future.get();
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
			result = false;
		} catch (ExecutionException ex) {
			result = false;
		}
		return result;
	}

	private void runLoop() {
		try {
			while (running) {
				tick();
			}
		} finally {
			listenerExecutor.shutdown();
		}
	}

	/**
	 * Advances game time by one step, notifies all listeners in parallel, and sets
	 * {@code running} to {@code false} if any listener requests a pause.
	 *
	 * <p>Package-private so unit tests can drive individual ticks directly without
	 * starting the background thread.
	 */
	void tick() {
		final TickConfig config = tickConfig;
		gameTimeNanos = gameTimeNanos.add(config.stepNanos());
		if (fireListenersInParallel(config.step())) {
			running = false;
		}
	}

	/** Bundles the current step and its nanosecond equivalent into one volatile reference. */
	private record TickConfig(GameSpeed step, BigDecimal stepNanos) {
	}

}
