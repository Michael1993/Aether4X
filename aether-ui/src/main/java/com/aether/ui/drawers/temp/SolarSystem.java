/*
    MIT License
    Copyright (c) 2021 Mihály Verhás
    See LICENSE file.
*/
package com.aether.ui.drawers.temp;

import java.util.Collections;
import java.util.List;

import com.aether.model.celestials.bodies.CelestialBody;
import com.aether.model.celestials.objects.CelestialObject;

/** Represents the Solar System with all its planets. */
public final class SolarSystem implements CelestialObject {

	@Override
	public String name() {
		return "Sol-0";
	}

	@Override
	public String type() {
		return "Solar system";
	}

	@Override
	public List<CelestialObject> substructures() {
		return Collections.emptyList();
	}

	@Override
	public List<CelestialBody> bodies() {
		return List
				.of(new Sun(), new Mercury(), new Venus(), Earth.get(), new Mars(), Jupiter.get(), new Saturn(),
					new Uranus(), new Neptune());
	}

}
