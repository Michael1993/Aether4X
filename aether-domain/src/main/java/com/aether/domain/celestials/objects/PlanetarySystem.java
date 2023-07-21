/*
    MIT License
    Copyright (c) 2023 Mihály Verhás
    See LICENSE file.
*/
package com.aether.domain.celestials.objects;

import java.util.Collections;
import java.util.List;

import com.aether.model.celestials.bodies.CelestialBody;
import com.aether.model.celestials.objects.CelestialObject;

/**
 * Represents a solar system or planetary system.
 * <p>
 * <a href="https://en.wikipedia.org/wiki/Planetary_system">Planetary system.</a></p>
 */
public record PlanetarySystem(String name, String type, List<CelestialBody> bodies) implements CelestialObject {

	@Override
	public List<CelestialObject> substructures() {
		return Collections.emptyList();
	}

}
