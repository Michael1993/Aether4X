package com.aether.ui.drawers.temp;

import com.aether.model.celestials.CelestialBody;

/**
 * Earth.
 */
public final class Earth implements CelestialBody {
    private static final double ORBIT_PERIAPSIS = 0.983;
    private static final double ORBIT_APOAPSIS = 1.017;
    private static final long PLANET_RADIUS = 6_371L;
    private static final double ORBIT_PERIOD = 365.0;
    private static final String NAME = "Earth";

    /** Creates Earth. */
    public Earth() {
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
