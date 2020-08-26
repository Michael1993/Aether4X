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

/** TODO: Document the Nebula class. */
public final class Nebula implements CelestialObject {

	private String name;

	private List<CelestialObject> substructures;

	/**
	 * TODO: Document the Nebula constructor.
	 *
	 * @param name The name of this nebula.
	 * @param substructures The substructures within this nebula.
	 */
	public Nebula(String name, List<CelestialObject> substructures) {
		this.name = name;
		this.substructures = substructures;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getType() {
		return CelestialObjectType.NEBULA.toString();
	}

	@Override
	public List<CelestialObject> getSubstructures() {
		return substructures;
	}

	@Override
	public List<CelestialBody> getBodies() {
		return Collections.emptyList();
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSubstructures(List<CelestialObject> substructures) {
		this.substructures = substructures;
	}

}
