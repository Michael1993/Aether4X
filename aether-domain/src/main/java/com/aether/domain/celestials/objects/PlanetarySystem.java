/*
    MIT License
    Copyright (c) 2020 Mihály Verhás
    See LICENSE file.
*/
package com.aether.domain.celestials.objects;

import java.util.Collections;
import java.util.List;

import com.aether.model.celestials.bodies.CelestialBody;
import com.aether.model.celestials.objects.CelestialObject;

/** Represents a solar system or planetary system. https://en.wikipedia.org/wiki/Planetary_system */
public final class PlanetarySystem implements CelestialObject {

	private String name;
	private List<CelestialBody> objects;

	/**
	 * Creates a new {@code SolarSystem} with the supplied celestial objects.
	 *
	 * @param name the name of this {@code PlanetarySystem}
	 * @param objects the objects in this {@code PlanetarySystem}, e.g.: planets, moons, asteroids,
	 *     etc.
	 */
	public PlanetarySystem(String name, List<CelestialBody> objects) {
		this.name = name;
		this.objects = objects;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getType() {
		return CelestialObjectType.PLANETARY_SYSTEM.toString();
	}

	@Override
	public List<CelestialObject> getSubstructures() {
		return Collections.emptyList();
	}

	@Override
	public List<CelestialBody> getBodies() {
		return objects;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setObjects(List<CelestialBody> objects) {
		this.objects = objects;
	}

}
