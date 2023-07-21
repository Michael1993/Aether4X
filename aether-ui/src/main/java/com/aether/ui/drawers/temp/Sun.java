/*
    MIT License
    Copyright (c) 2023 Mihály Verhás
    See LICENSE file.
*/
package com.aether.ui.drawers.temp;

import java.util.List;

import com.aether.model.celestials.bodies.CelestialBody;

/** THE SUN, THE SUN, THE SUN, THE S... */
public final class Sun implements CelestialBody {

	private static final double ORBIT_PERIAPSIS = 0;
	private static final double ORBIT_APOAPSIS = 0;
	private static final long PLANET_RADIUS = 5L;
	private static final double ORBIT_PERIOD = 0;
	private static final String NAME = "Sol-A (G2-V)";

	/** Creates the Sun. */
	public Sun() {
	}

	@Override
	public String type() {
		return "Sun";
	}

	@Override
	public String name() {
		return NAME;
	}

	@Override
	public double mass() {
		return 0;
	}

	@Override
	public double radius() {
		return PLANET_RADIUS;
	}

	@Override
	public double rotationPeriod() {
		return 0;
	}

	@Override
	public double orbitPeriod() {
		return ORBIT_PERIOD;
	}

	@Override
	public double apoapsis() {
		return ORBIT_APOAPSIS;
	}

	@Override
	public double periapsis() {
		return ORBIT_PERIAPSIS;
	}

	@Override
	public List<CelestialBody> orbitingBodies() {
		return List.of();
	}

}
