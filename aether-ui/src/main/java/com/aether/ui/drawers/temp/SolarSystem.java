package com.aether.ui.drawers.temp;

import java.util.Collections;
import java.util.List;

import com.aether.model.celestials.CelestialBody;
import com.aether.model.celestials.CelestialObject;

/**
 * Represents the Solar System with all its planets.
 */
public final class SolarSystem implements CelestialObject {
    @Override
    public String getName() {
        return "Sol-0";
    }

    @Override
    public String getType() {
        return "Solar system";
    }

    @Override
    public List<CelestialObject> getSubstructures() {
        return Collections.emptyList();
    }

    @Override
    public List<CelestialBody> getBodies() {
        return List.of(
                new Sun(),
                new Mercury(),
                new Venus(),
                new Earth(),
                new Mars(),
                new Jupiter(),
                new Saturn(),
                new Uranus(),
                new Neptune()
        );
    }
}
