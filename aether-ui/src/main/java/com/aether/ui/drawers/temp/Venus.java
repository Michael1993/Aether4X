package com.aether.ui.drawers.temp;

import java.util.List;

import com.aether.model.celestials.CelestialBody;

/**
 * Venus.
 */
public final class Venus implements CelestialBody {
    private static final double ORBIT_PERIAPSIS = 0.728;
    private static final double ORBIT_APOAPSIS = 0.718;
    private static final long PLANET_RADIUS = 6_051L;
    private static final double ORBIT_PERIOD = 224.70;
    private static final String NAME = "Venus";

    /**
     * Creates Venus.
     */
    public Venus() {
    }

    @Override
    public String getType() {
        return "Planet";
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public double getMass() {
        return 0;
    }

    @Override
    public double getRadius() {
        return PLANET_RADIUS;
    }

    @Override
    public double getRotationPeriod() {
        return 0;
    }

    @Override
    public double getOrbitPeriod() {
        return ORBIT_PERIOD;
    }

    @Override
    public double getApoapsis() {
        return ORBIT_APOAPSIS;
    }

    @Override
    public double getPeriapsis() {
        return ORBIT_PERIAPSIS;
    }

    @Override
    public List<CelestialBody> getOrbitingBodies() {
        return List.of();
    }
}
