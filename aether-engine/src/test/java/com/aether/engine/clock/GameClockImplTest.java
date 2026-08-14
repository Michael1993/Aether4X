/*
    MIT License
    Copyright (c) 2026 Mihály Verhás
    See LICENSE file.
*/
package com.aether.engine.clock;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.aether.clock.GameClockListener;
import com.aether.clock.GameSpeed;

class GameClockImplTest {

	private GameClockImpl clock;

	@BeforeEach
	void setUp() {
		clock = new GameClockImpl();
	}

	@Test
	@DisplayName("Initial state: game time is zero, speed is 1 h/tick, clock is not running")
	void initialState() {
		assertThat(clock.gameTime().value()).isEqualTo(BigDecimal.ZERO);
		assertThat(clock.gameTime().unit()).isEqualTo(TimeUnit.SECONDS);
		assertThat(clock.speed().value()).isEqualByComparingTo(BigDecimal.ONE);
		assertThat(clock.speed().unit()).isEqualTo(TimeUnit.HOURS);
		assertThat(clock.isRunning()).isFalse();
	}

	@Test
	@DisplayName("tick() advances game time by the default step of one game-hour")
	void tickAdvancesGameTime() {
		clock.tick();
		assertThat(clock.gameTime(TimeUnit.HOURS).value()).isEqualByComparingTo(BigDecimal.ONE);
	}

	@Test
	@DisplayName("gameTime(SECONDS) returns 3600 after a single 1-hour tick")
	void gameTimeInSecondsAfterOneTick() {
		clock.tick();
		assertThat(clock.gameTime(TimeUnit.SECONDS).value()).isEqualByComparingTo(new BigDecimal("3600"));
	}

	@Test
	@DisplayName("Three ticks accumulate to exactly 3 game-hours")
	void multipleTicksAccumulate() {
		clock.tick();
		clock.tick();
		clock.tick();
		assertThat(clock.gameTime(TimeUnit.HOURS).value()).isEqualByComparingTo(new BigDecimal("3"));
	}

	@Test
	@DisplayName("setSpeed() changes the amount of game time advanced per tick")
	void setSpeedChangesStep() {
		clock.setSpeed(GameSpeed.of(2L, TimeUnit.HOURS));
		clock.tick();
		assertThat(clock.gameTime(TimeUnit.HOURS).value()).isEqualByComparingTo(new BigDecimal("2"));
	}

	@Test
	@DisplayName("Listener receives the current step magnitude and unit on each tick")
	void listenerReceivesCurrentStep() {
		GameSpeed[] captured = { null };
		clock.addListener(step -> {
			captured[0] = step;
			return false;
		});
		clock.tick();
		assertThat(captured[0].unit()).isEqualTo(TimeUnit.HOURS);
		assertThat(captured[0].value()).isEqualByComparingTo(BigDecimal.ONE);
	}

	@Test
	@DisplayName("A listener returning true causes the live clock to stop")
	void listenerReturnsTruePausesClock() throws InterruptedException {
		CountDownLatch tickFired = new CountDownLatch(1);
		clock.addListener(step -> {
			tickFired.countDown();
			return true;
		});
		clock.start();
		assertThat(tickFired.await(5L, TimeUnit.SECONDS)).as("Listener was not called within 5 s").isTrue();
		// Poll briefly; running=false is written on the clock thread immediately after
		// invokeAll returns — nanoseconds after countDown(), so 2 s is extremely generous.
		long deadline = System.currentTimeMillis() + 2000L;
		while (clock.isRunning() && System.currentTimeMillis() < deadline) {
			Thread.sleep(10L);
		}
		assertThat(clock.isRunning()).as("Clock should have paused after listener returned true").isFalse();
	}

	@Test
	@DisplayName("Two mutually-blocking listeners prove that dispatch is parallel")
	void listenersRunInParallel() throws InterruptedException {
		CountDownLatch barrier = new CountDownLatch(2);
		clock.addListener(step -> {
			barrier.countDown();
			try {
				// If sequential this await() would time out (count never reaches 0)
				return !barrier.await(5L, TimeUnit.SECONDS);
			}
			catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
				return true;
			}
		});
		clock.addListener(step -> {
			barrier.countDown();
			try {
				return !barrier.await(5L, TimeUnit.SECONDS);
			}
			catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
				return true;
			}
		});
		clock.tick();
		assertThat(barrier.getCount())
				.as("Barrier did not reach zero — listeners may not have run in parallel")
				.isZero();
	}

	@Test
	@DisplayName("start() sets isRunning() to true; pause() resets it to false")
	void startAndPauseClock() throws InterruptedException {
		CountDownLatch firstTick = new CountDownLatch(1);
		clock.addListener(step -> {
			firstTick.countDown();
			return false;
		});
		clock.start();
		assertThat(firstTick.await(5L, TimeUnit.SECONDS)).as("Clock did not tick within 5 s").isTrue();
		assertThat(clock.isRunning()).isTrue();
		clock.pause();
		assertThat(clock.isRunning()).isFalse();
	}

	@Test
	@DisplayName("removeListener() prevents the listener from receiving further ticks")
	void removeListenerStopsNotification() {
		boolean[] called = { false };
		GameClockListener listener = step -> {
			called[0] = true;
			return false;
		};
		clock.addListener(listener);
		clock.removeListener(listener);
		clock.tick();
		assertThat(called[0]).as("Removed listener must not be called").isFalse();
	}

	@Test
	@DisplayName("Calling start() twice is idempotent — only one background thread is started")
	void doubleStartIsIdempotent() throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(1);
		clock.addListener(step -> {
			latch.countDown();
			return false;
		});
		clock.start();
		clock.start(); // second call must be a no-op
		assertThat(clock.isRunning()).isTrue();
		assertThat(latch.await(5L, TimeUnit.SECONDS)).as("Clock did not tick within 5 s").isTrue();
		clock.pause();
	}

}
