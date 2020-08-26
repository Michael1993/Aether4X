/*
    MIT License
    Copyright (c) 2020 Mihály Verhás
    See LICENSE file.
*/
package com.aether.domain.celestials.bodies;

import java.util.List;

import com.aether.model.celestials.bodies.CelestialBody;

/** TODO. */
public final class Star extends AbstractCelestialBody {

	/**
	 * Creates an abstract celestial body.
	 *
	 * @param name
	 * @param mass
	 * @param radius
	 * @param rotationPeriod
	 * @param orbitPeriod
	 * @param apoapsis
	 * @param periapsis
	 * @param orbitingBodies
	 */
	@SuppressWarnings("checkstyle:EmptyLineSeparator")
	protected Star(String name, double mass, double radius, double rotationPeriod, double orbitPeriod, double apoapsis,
			double periapsis, List<CelestialBody> orbitingBodies) {
		super(name, mass, radius, rotationPeriod, orbitPeriod, apoapsis, periapsis, orbitingBodies);
	}

	@Override
	public String getType() {
		return CelestialBodyType.STAR.toString();
	}

}
