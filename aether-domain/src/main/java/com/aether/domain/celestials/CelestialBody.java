package com.aether.domain.celestials;

import java.util.function.Function;

/**
 * Represents a body in a solar system, eg.: a sun, a planet, a moon, etc.
 */
public final class CelestialBody {
    private final String name;

    private final double orbitalPeriod;

    private CelestialBody(String name, double orbitalPeriod) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
    }

    private void abcd(Function<String, String> func) {
    }
}
