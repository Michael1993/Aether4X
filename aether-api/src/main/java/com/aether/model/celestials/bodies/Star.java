/*
    MIT License
    Copyright (c) 2026 Mihály Verhás
    See LICENSE file.
*/
package com.aether.model.celestials.bodies;

/**
 * A star. Extends {@link CelestialBody} with temperature and color, which together determine
 * the stellar classification returned by {@link #typeName()}.
 */
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
	 * Returns a nuanced stellar classification derived from the star's color. E.g.: "Red Dwarf" for a
	 * cool red star, "Yellow Dwarf" for a G-type star like Sol.
	 *
	 * @return the stellar classification name.
	 */
	@Override
	default String typeName() {
		return color().stellarClassName();
	}

	/**
	 * A list of all possible star colors from hottest (blue) to coolest (red), each carrying
	 * its corresponding stellar classification name.
	 */
	enum StarColor {

		DEEP_BLUE("Blue Hypergiant"),
		BLUE("Blue Giant"),
		LIGHT_BLUE("Blue-White Star"),
		CYAN("White Star"),
		WHITE("White Dwarf"),
		YELLOW("Yellow Dwarf"),
		RED("Red Dwarf");

		private final String stellarClassName;

		StarColor(final String stellarClassName) {
			this.stellarClassName = stellarClassName;
		}

		String stellarClassName() {
			return stellarClassName;
		}

	}

}
