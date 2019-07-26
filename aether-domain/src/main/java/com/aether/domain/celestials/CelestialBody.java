package com.aether.domain.celestials;

public final class CelestialBody {
    private final String name;
    private final double orbitalPeriod;

    private CelestialBody(String name, double orbitalPeriod) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
    }
}
