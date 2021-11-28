/*
    MIT License
    Copyright (c) 2021 Mihály Verhás
    See LICENSE file.
*/
package com.aether.ui.drawers.temp;

import java.util.List;

import com.aether.model.celestials.bodies.CelestialBody;

/** Venus. */
public final class Venus implements CelestialBody {

	private static final double ORBIT_PERIAPSIS = 0.728;
	private static final double ORBIT_APOAPSIS = 0.718;
	private static final long PLANET_RADIUS = 6_051L;
	private static final double ORBIT_PERIOD = 224.70;
	private static final String NAME = "Venus";

	/** Creates Venus. */
	public Venus() {
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
