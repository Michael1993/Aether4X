/*
    MIT License
    Copyright (c) 2020 Mihály Verhás
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
	public String getType() {
		return "Planet";
	}

	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public double getMass() {
		return 0;
	}

	@Override
	public double getRadius() {
		return PLANET_RADIUS;
	}

	@Override
	public double getRotationPeriod() {
		return 0;
	}

	@Override
	public double getOrbitPeriod() {
		return ORBIT_PERIOD;
	}

	@Override
	public double getApoapsis() {
		return ORBIT_APOAPSIS;
	}

	@Override
	public double getPeriapsis() {
		return ORBIT_PERIAPSIS;
	}

	@Override
	public List<CelestialBody> getOrbitingBodies() {
		return List.of();
	}

}
