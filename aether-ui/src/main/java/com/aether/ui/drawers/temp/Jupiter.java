/*
    MIT License
    Copyright (c) 2023 Mihály Verhás
    See LICENSE file.
*/
package com.aether.ui.drawers.temp;

import java.util.List;

import com.aether.domain.celestials.bodies.Planet;
import com.aether.model.celestials.bodies.CelestialBody;

/** Jupiter. */
public final class Jupiter {

	private static final double ORBIT_APOAPSIS = 5.4588;
	private static final double ORBIT_PERIAPSIS = 4.9501;
	private static final long PLANET_RADIUS = 69_911L;
	private static final double ORBIT_PERIOD = 4_332.59;
	private static final String NAME = "Jupiter";

	private Jupiter() {
	}

	/** Creates Jupiter. */
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
