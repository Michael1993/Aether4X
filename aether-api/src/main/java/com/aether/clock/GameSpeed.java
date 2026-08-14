/*
    MIT License
    Copyright (c) 2026 Mihály Verhás
    See LICENSE file.
*/
package com.aether.clock;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * A quantity of game time paired with a {@link TimeUnit}.
 *
 * <p>Used both to express elapsed game time (via {@link GameClock#gameTime()}) and the
 * per-tick step (via {@link GameClock#speed()} and {@link GameClock#setSpeed(GameSpeed)}).
 */
public interface GameSpeed {

	/**
	 * Returns the numeric magnitude of this value in the associated {@link #unit()}.
	 *
	 * @return the amount as a {@link BigDecimal}.
	 */
	BigDecimal value();

	/**
	 * Returns the {@link TimeUnit} that qualifies {@link #value()}.
	 *
	 * @return the time unit.
	 */
	TimeUnit unit();

	/**
	 * Creates a {@link GameSpeed} with the given magnitude and unit.
	 *
	 * @param value the magnitude.
	 * @param unit the time unit.
	 * @return a new {@link GameSpeed} instance.
	 */
	static GameSpeed of(final BigDecimal value, final TimeUnit unit) {
		return new GameSpeedRecord(value, unit);
	}

	/**
	 * Creates a {@link GameSpeed} from a {@code long} value and unit.
	 *
	 * @param value the magnitude.
	 * @param unit the time unit.
	 * @return a new {@link GameSpeed} instance.
	 */
	static GameSpeed of(final long value, final TimeUnit unit) {
		return new GameSpeedRecord(BigDecimal.valueOf(value), unit);
	}

}
