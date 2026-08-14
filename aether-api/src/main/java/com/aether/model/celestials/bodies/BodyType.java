/*
    MIT License
    Copyright (c) 2026 Mihály Verhás
    See LICENSE file.
*/
package com.aether.model.celestials.bodies;

/** Coarse classification of a celestial body. */
public enum BodyType {

	STAR("Star"), PLANET("Planet"), MOON("Moon"), ASTEROID("Asteroid"), COMET("Comet");

	private final String displayName;

	BodyType(String displayName) {
		this.displayName = displayName;
	}

	/** Returns the human-readable name for this type. */
	public String displayName() {
		return displayName;
	}

}
