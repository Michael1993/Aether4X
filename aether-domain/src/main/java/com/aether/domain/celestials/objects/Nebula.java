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

/** TODO: Document the Nebula class. */
public record Nebula(String name, List<CelestialObject> substructures) implements CelestialObject {

	@Override
	public ObjectType type() {
		return ObjectType.NEBULA;
	}

	@Override
	public List<CelestialBody> bodies() {
		return Collections.emptyList();
	}

}
