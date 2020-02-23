package com.aether.domain.celestials;

import java.util.List;

import com.aether.model.celestials.CelestialBody;
import com.aether.model.celestials.CelestialObject;

/**
 * Represents a galaxy, with its systems.
 */
public final class Galaxy implements CelestialObject {
    private List<CelestialObject> nebulae;

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getType() {
        return null;
    }

    @Override
    public List<CelestialObject> getSubstructures() {
        return null;
    }

    @Override
    public List<CelestialBody> getBodies() {
        return null;
    }
}
