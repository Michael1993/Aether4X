/*
    MIT License
    Copyright (c) 2023 Mihály Verhás
    See LICENSE file.
*/
package com.aether.model.celestials.bodies;

import java.util.List;

/**
 * Represents a celestial body. A single, tightly bound, contiguous entity. I.e.: - A planet - A
 * star - A moon - An asteroid - A comet. A comet is considered ONLY a body and NOT an object.
 */
public interface CelestialBody {

	/**
	 * Gets the name of the body. E.g.: Mars, Earth, Alpha Centauri-II.
	 *
	 * @return the name of this body.
	 */
	String name();

	/**
	 * Gets the type of the body. For example a star could return: - Red dwarf - White dwarf - Giant -
	 * etc.
	 *
	 * @return the type of this body as text.
	 */
	String type();

	/**
	 * Gets the approximate mass of the body in 10^24 kilograms.
	 *
	 * @return the mass of the current body.
	 */
	double mass();

	/**
	 * Gets the approximate radius of the body in km. If the body is rather uneven (e.g.: an
	 * asteroid), it should return the average radius.
	 *
	 * @return the radius of the current body.
	 */
	double radius();

	/**
	 * Gets the approximate rotation period of the body in hours.
	 *
	 * @return the amount of time it takes for the current body to do a full rotation.
	 */
	double rotationPeriod();

	/**
	 * Gets the approximate rotation period of the body in days. This is in Earth days (24h), not the
	 * "day" (rotation period) of the specific body.
	 *
	 * @return the amount of time it takes for the current body to do a full orbit.
	 */
	double orbitPeriod();

	/**
	 * Gets the farthest point in the orbit of a planetary body about its primary body in AUs. E.g.:
	 * If the current body is the Earth, this returns the farthest point of the Earth's orbit from the
	 * Sun. AU - Astronomical Unit.
	 * <p>
	 * <a href="https://en.wikipedia.org/wiki/Astronomical_unit">Astronomical unit</a>
	 *
	 * @return the apoapsis of the current body.
	 */
	double apoapsis();

	/**
	 * Gets the nearest point in the orbit of a planetary body about its primary body in AUs. E.g.: If
	 * the current body is the Earth, this returns the nearest point of the Earth's orbit from the
	 * Sun. AU - Astronomical Unit.
	 * <p>
	 * <a href="https://en.wikipedia.org/wiki/Astronomical_unit">Astronomical unit</a>
	 *
	 * @return the periapsis of the current body.
	 */
	double periapsis();

	/**
	 * Gets the celestial bodies orbiting this body. I.e.: - Moons (in case of planets) - Planets (in
	 * case of stars) - Asteroids - Comets If no objects orbit this body, it should return an empty
	 * list.
	 *
	 * @return the celestial bodies orbiting this body.
	 */
	List<CelestialBody> orbitingBodies();

	/**
	 * Gets the average radius of the orbit in AUs.
	 *
	 * @return the sum of the apoapsis and periapsis divided by 2.
	 */
	default double orbitRadius() {
		return (apoapsis() + periapsis()) / 2;
	}

}
