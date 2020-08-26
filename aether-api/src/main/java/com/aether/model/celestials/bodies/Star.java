/*
    MIT License
    Copyright (c) 2020 Mihály Verhás
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
	int getTemperature();

	/**
	 * The color index for this star that corresponds to its temperature. Should be used for properly
	 * drawing the star on the UI. https://en.wikipedia.org/wiki/Color_index
	 *
	 * @return the B-V of this star.
	 */
	double getColorIndex();

}
