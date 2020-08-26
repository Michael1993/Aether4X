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

/**
 * Represents a galaxy. A galaxy can have several substructures, like star clusters, nebulae or
 * planetary systems.
 */
public final class Galaxy implements CelestialObject {

	private final String name;
	private final List<CelestialObject> substructures;

	/**
	 * Creates a new galaxy.
	 * @param name the name of the galaxy
	 * @param substructures the substructures (e.g.: nebulae) in this galaxy
	 */
	public Galaxy(String name, List<CelestialObject> substructures) {
		this.name = name;
		this.substructures = substructures;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getType() {
		return CelestialObjectType.GALAXY.toString();
	}

	@Override
	public List<CelestialObject> getSubstructures() {
		return substructures;
	}

	@Override
	public List<CelestialBody> getBodies() {
		return Collections.emptyList();
	}

}
