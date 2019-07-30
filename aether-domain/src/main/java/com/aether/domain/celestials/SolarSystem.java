package com.aether.domain.celestials;

import java.util.List;

/**
 * Represents a solar system.
 */
public final class SolarSystem {
    private final List<CelestialBody> objects;

    /**
     * Creates a new SolarSystem with the supplied celestial objects.
     * @param objects the objects in this solar system.
     */
    public SolarSystem(List<CelestialBody> objects) {
        this.objects = objects;
    }
}
