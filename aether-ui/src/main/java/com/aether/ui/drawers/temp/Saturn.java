package com.aether.ui.drawers.temp;

import com.aether.model.celestials.CelestialBody;

/**
 * Saturn.
 */
public final class Saturn implements CelestialBody {
    private static final double ORBIT_PERIAPSIS = 10.123;
    private static final double ORBIT_APOAPSIS = 9.041;
    private static final long PLANET_RADIUS = 58_232L;
    private static final double ORBIT_PERIOD = 10_759.22;
    private static final String NAME = "Saturn";

    /** Creates Saturn. */
    public Saturn() {
    }

    @Override public String getName() {
        return NAME;
    }

    @Override public double getMass() {
        return 0;
    }

    @Override public double getRadius() {
        return PLANET_RADIUS;
    }

    @Override public double getRotationPeriod() {
        return 0;
    }

    @Override public double getOrbitPeriod() {
        return ORBIT_PERIOD;
    }

    @Override public double getApoapsis() {
        return ORBIT_APOAPSIS;
    }

    @Override public double getPeriapsis() {
        return ORBIT_PERIAPSIS;
    }

    @Override public CelestialBody[] getOrbitingBodies() {
        return new CelestialBody[0];
    }
}
