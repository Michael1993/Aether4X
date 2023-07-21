/*
    MIT License
    Copyright (c) 2023 Mihály Verhás
    See LICENSE file.
*/
package com.aether.ui.drawers.temp;

import java.util.List;

import com.aether.domain.celestials.bodies.Planet;
import com.aether.model.celestials.bodies.CelestialBody;

/** Earth. */
public final class Earth {

	private static final double ORBIT_PERIAPSIS = 0.983;
	private static final double ORBIT_APOAPSIS = 1.017;
	private static final long PLANET_RADIUS = 6_371L;
	private static final double ORBIT_PERIOD = 365.0;
	private static final String NAME = "Earth";

	private Earth() {
	}

	/** Creates Earth. */
	public static CelestialBody get() {
		//@formatter:off
		return new Planet(
			NAME,
			"Planet",
			0,
			PLANET_RADIUS,
			0,
			ORBIT_PERIOD,
			ORBIT_APOAPSIS,
			ORBIT_PERIAPSIS,
			List.of()
		);
		//@formatter:on
	}

}
