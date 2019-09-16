package com.aether.ui.drawers.temp;

import com.aether.model.celestials.CelestialBody;

/**
 * Mars.
 */
public final class Mars implements CelestialBody {
    private static final double ORBIT_APOAPSIS = 1.666;
    private static final double ORBIT_PERIAPSIS = 1.382;
    private static final long PLANET_RADIUS = 3_889L;
    private static final double ORBIT_PERIOD = 686.97;
    private static final String NAME = "Mars";

    /**
     * Creates Mars.
     */
    public Mars() {
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
