package com.aether.domain.celestials;

import java.util.List;

import com.aether.model.celestials.CelestialBody;
import com.aether.model.celestials.CelestialObject;

/**
 * Represents a solar system.
 */
public final class SolarSystem implements CelestialObject {
    private final String name;
    private final List<CelestialBody> objects;

    /**
     * Creates a new {@code SolarSystem} with the supplied celestial objects.
     * @param name the name of this {@code SolarSystem}
     * @param objects the objects in this {@code SolarSystem}, e.g.: planets, moons, asteroids, etc.
     */
    public SolarSystem(String name, List<CelestialBody> objects) {
        this.name = name;
        this.objects = objects;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return "planetary system";
    }

    @Override
    public List<CelestialObject> getSubstructures() {
        return List.of();
    }

    @Override
    public List<CelestialBody> getBodies() {
        return objects;
    }
}
