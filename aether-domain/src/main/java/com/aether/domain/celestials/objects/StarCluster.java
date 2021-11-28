/*
    MIT License
    Copyright (c) 2021 Mihály Verhás
    See LICENSE file.
*/
package com.aether.domain.celestials.objects;

import java.util.Collections;
import java.util.List;

import com.aether.model.celestials.bodies.CelestialBody;
import com.aether.model.celestials.objects.CelestialObject;

/** Star clusters in Aether??? TODO. */
public record StarCluster(String name, String type, List<CelestialBody> bodies) implements CelestialObject {

	@Override
	public List<CelestialObject> substructures() {
		return Collections.emptyList();
	}

}
