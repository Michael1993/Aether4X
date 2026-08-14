/*
    MIT License
    Copyright (c) 2026 Mihály Verhás
    See LICENSE file.
*/
package com.aether.clock;

import java.util.concurrent.TimeUnit;

/**
 * The game clock tracks continuous in-game time.
 *
 * <p>It advances at a configurable speed expressed in game-hours per real second
 * and notifies registered {@link GameClockListener listeners} on every tick.
 */
public interface GameClock {

	/**
	 * Returns the current game time elapsed since the game start in the given {@link TimeUnit}.
	 *
	 * @param unit the {@link TimeUnit} to return the game time in.
	 * @return the current game time in the given {@link TimeUnit}
	 */
	GameSpeed gameTime(TimeUnit unit);

	/**
	 * Returns the current game time since the game start in seconds.
	 *
	 * @return the current game time in seconds.
	 */
	GameSpeed gameTime();

	/**
	 * Returns the current speed.
	 *
	 * @return the speed in game-hours per real second.
	 */
	GameSpeed speed();

	/**
	 * Sets the speed of the clock.
	 *
	 * @param speed the new speed as a {@link GameSpeed} instance.
	 */
	void setSpeed(GameSpeed speed);

	/**
	 * Starts or resumes the clock.
	 */
	void start();

	/**
	 * Pauses the clock.
	 *
	 * <p>Time stops advancing but the current game time is preserved.
	 */
	void pause();

	/**
	 * Returns whether the clock is currently running.
	 *
	 * @return {@code true} if the clock is running, {@code false} if it is paused.
	 */
	boolean isRunning();

	/**
	 * Registers a listener to be notified on every tick.
	 *
	 * @param listener the listener to register.
	 */
	void addListener(GameClockListener listener);

	/**
	 * Removes a previously registered listener.
	 *
	 * @param listener the listener to remove.
	 */
	void removeListener(GameClockListener listener);

}
