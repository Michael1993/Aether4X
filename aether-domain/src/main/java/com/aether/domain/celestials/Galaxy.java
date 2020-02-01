package com.aether.domain.celestials;

import com.aether.model.celestials.CelestialBody;
import com.aether.model.celestials.CelestialObject;

import java.util.List;

/**
 * Represents a galaxy, with its systems.
 */
public class Galaxy implements CelestialObject {
    List<CelestialObject> nebulae;

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
