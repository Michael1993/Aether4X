package com.aether.domain.celestials;

/**
 * Represents a body in a solar system, eg.: a sun, a planet, a moon, etc.
 */
public final class CelestialBody {
    private final String name;

    private final CelestialType type;

    private final double orbitalPeriod;

    private CelestialBody(
        String name,
        CelestialType type,
        double orbitalPeriod) {
        this.name = name;
        this.type = type;
        this.orbitalPeriod = orbitalPeriod;
    }

    /**
     * Because CelestialBody is immutable, it has to be created by a builder.
     * @return a new instance of a CelestialBodyBuilder.
     */
    public static CelestialBodyBuilder builder() {
        return new CelestialBodyBuilder();
    }

    private static final class CelestialBodyBuilder {
        private String name;
        private double orbitalPeriod;
        private CelestialType type;

        private CelestialBodyBuilder() {
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setOrbitalPeriod(double orbitalPeriod) {
            this.orbitalPeriod = orbitalPeriod;
        }

        public void setType(CelestialType type) {
            this.type = type;
        }

        public CelestialBody build() {
            return new CelestialBody(name, type, orbitalPeriod);
        }
    }
}
