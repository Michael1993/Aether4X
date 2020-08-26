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

/** Star clusters in Aether??? TODO. */
public final class StarCluster implements CelestialObject {

	private String name;

	private List<CelestialBody> bodies;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getType() {
		return CelestialObjectType.STAR_CLUSTER.toString();
	}

	@Override
	public List<CelestialObject> getSubstructures() {
		return Collections.emptyList();
	}

	@Override
	public List<CelestialBody> getBodies() {
		return bodies;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBodies(List<CelestialBody> bodies) {
		this.bodies = bodies;
	}

}
