/*
    MIT License
    Copyright (c) 2023 Mihály Verhás
    See LICENSE file.
*/
package com.aether.model.celestials.bodies;

/** A star. TODO. */
public interface Star extends CelestialBody {

	/**
	 * Stars are classified based on their surface temperature, and size. This method should be used
	 * to calculate the average temperature on a planets surface based on their mean distance from
	 * their star.
	 *
	 * @return the surface temperature of this star in Kelvins.
	 */
	int temperature();

	/**
	 * The color for this star that corresponds to its temperature. Should be used for properly
	 * drawing the star on the UI.
	 * <p>
	 * For additional information on star colors, please see the color index used in astronomy.
	 * <a href="https://en.wikipedia.org/wiki/Color_index">Color index</a>
	 *
	 * @return the color of this star from the {@code StarColor}.
	 */
	StarColor color();

	/**
	 * A list of all possible star colors from blue to red.
	 */
	enum StarColor {
		DEEP_BLUE, BLUE, LIGHT_BLUE, CYAN, WHITE, YELLOW, RED
	}

}
