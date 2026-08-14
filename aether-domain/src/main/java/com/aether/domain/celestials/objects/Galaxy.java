/*
    MIT License
    Copyright (c) 2026 Mihály Verhás
    See LICENSE file.
*/
package com.aether.domain.celestials.objects;

import java.util.Collections;
import java.util.List;

import com.aether.model.celestials.bodies.CelestialBody;
import com.aether.model.celestials.objects.CelestialObject;
import com.aether.model.celestials.objects.ObjectType;

/**
 * Represents a galaxy. A galaxy can have several substructures, like star clusters, nebulae or
 * planetary systems.
 */
public record Galaxy(String name, List<CelestialObject> substructures) implements CelestialObject {

	@Override
	public ObjectType type() {
		return ObjectType.GALAXY;
	}

	@Override
	public List<CelestialBody> bodies() {
		return Collections.emptyList();
	}

}
