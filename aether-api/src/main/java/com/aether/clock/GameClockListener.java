/*
    MIT License
    Copyright (c) 2026 Mihály Verhás
    See LICENSE file.
*/
package com.aether.clock;

/**
 * Listener notified by a {@link GameClock} on each tick.
 */
@FunctionalInterface
public interface GameClockListener {

	/**
	 * Called by the game clock on each tick.
	 *
	 * @param tick the current tick of game speed, this much time has elapsed since the last tick.
	 * @return {@code true} if the GameClock should be paused after this event
	 */
	boolean onTick(GameSpeed tick);

}
