/*
    MIT License
    Copyright (c) 2026 Mihály Verhás
    See LICENSE file.
*/
package com.aether.model.celestials.objects;

/** Coarse classification of a celestial object. */
public enum ObjectType {

	GALAXY("Galaxy"), STAR_CLUSTER("Star Cluster"), NEBULA("Nebula"), PLANETARY_SYSTEM("Planetary System");

	private final String displayName;

	ObjectType(String displayName) {
		this.displayName = displayName;
	}

	/** Returns the human-readable name for this type. */
	public String displayName() {
		return displayName;
	}

}
