package com.aether.ui.drawers.temp;

import com.aether.model.celestials.CelestialBody;

/**
 * Mercury.
 */
public final class Mercury implements CelestialBody {
    private static final double ORBIT_APOAPSIS = 0.466;
    private static final double ORBIT_PERIAPSIS = 0.307;
    private static final long PLANET_RADIUS = 2440L;
    private static final double ORBIT_PERIOD = 87.96;
    private static final String NAME = "Mercury";

    /**
     * Creates Mercury.
     */
    public Mercury() {
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
    public CelestialBody[] getOrbitingBodies() {
        return new CelestialBody[0];
    }
}
