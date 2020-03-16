package com.aether.ui.drawers.temp;

import java.util.List;

import com.aether.model.celestials.CelestialBody;

/**
 * Jupiter.
 */
public final class Jupiter implements CelestialBody {
    private static final double ORBIT_APOAPSIS = 5.4588;
    private static final double ORBIT_PERIAPSIS = 4.9501;
    private static final long PLANET_RADIUS = 69_911L;
    private static final double ORBIT_PERIOD = 4_332.59;
    private static final String NAME = "Jupiter";

    /**
     * Creates Jupiter.
     */
    public Jupiter() {
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
