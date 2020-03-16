package com.aether.ui.drawers.temp;

import java.util.List;

import com.aether.model.celestials.CelestialBody;

/**
 * THE SUN, THE SUN, THE SUN, THE S...
 */
public final class Sun implements CelestialBody {
    private static final double ORBIT_PERIAPSIS = 0;
    private static final double ORBIT_APOAPSIS = 0;
    private static final long PLANET_RADIUS = 5L;
    private static final double ORBIT_PERIOD = 0;
    private static final String NAME = "Sol-A (G2-V)";

    /**
     * Creates the Sun.
     */
    public Sun() {
    }

    @Override
    public String getType() {
        return "Sun";
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
