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

/** Star clusters in Aether??? TODO. */
public record StarCluster(String name, List<CelestialBody> bodies) implements CelestialObject {

	@Override
	public ObjectType type() {
		return ObjectType.STAR_CLUSTER;
	}

	@Override
	public List<CelestialObject> substructures() {
		return Collections.emptyList();
	}

}
