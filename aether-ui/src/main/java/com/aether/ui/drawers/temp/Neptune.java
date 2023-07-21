/*
    MIT License
    Copyright (c) 2023 Mihály Verhás
    See LICENSE file.
*/
package com.aether.ui.drawers.temp;

import java.util.List;

import com.aether.model.celestials.bodies.CelestialBody;

/** Neptune. */
public final class Neptune implements CelestialBody {

	private static final double ORBIT_PERIAPSIS = 30.33;
	private static final double ORBIT_APOAPSIS = 29.81;
	private static final long PLANET_RADIUS = 24_622L;
	private static final double ORBIT_PERIOD = 60_182;
	private static final String NAME = "Neptune";

	/** Creates Neptune. */
	public Neptune() {
	}

	@Override
	public String type() {
		return "Planet";
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
