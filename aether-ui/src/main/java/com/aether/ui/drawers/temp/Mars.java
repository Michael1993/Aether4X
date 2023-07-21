/*
    MIT License
    Copyright (c) 2023 Mihály Verhás
    See LICENSE file.
*/
package com.aether.ui.drawers.temp;

import java.util.List;

import com.aether.model.celestials.bodies.CelestialBody;

/** Mars. */
public final class Mars implements CelestialBody {

	private static final double ORBIT_APOAPSIS = 1.666;
	private static final double ORBIT_PERIAPSIS = 1.382;
	private static final long PLANET_RADIUS = 3_889L;
	private static final double ORBIT_PERIOD = 686.97;
	private static final String NAME = "Mars";

	/** Creates Mars. */
	public Mars() {
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
