package com.aether.ui.drawers.temp;

import com.aether.model.celestials.CelestialBody;

/**
 * Uranus.
 */
public final class Uranus implements CelestialBody {
    private static final double ORBIT_PERIAPSIS = 20.11;
    private static final double ORBIT_APOAPSIS = 18.33;
    private static final long PLANET_RADIUS = 25_362L;
    private static final double ORBIT_PERIOD = 30_688.5;
    private static final String NAME = "Uranus";

    /** Creates Uranus. */
    public Uranus() {
    }

    @Override public String getType() {
        return "Planet";
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
