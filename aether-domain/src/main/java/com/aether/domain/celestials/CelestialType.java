package com.aether.domain.celestials;

/**
 * A collection of the types of bodies/structures you can encounter in space.
 */
public final class CelestialType {
    private CelestialType() {
    }

    /**
     * A basic javadoc comment.
     */
    public enum Objects {
        PLANETARY_SYSTEM,
        STAR_CLUSTER,
        NEBULA,
        GALAXY
    }

    /**
     * A basic javadoc comment.
     */
    public enum Bodies {
        SUN,
        PLANET,
        MOON,
        ASTEROID,
        COMET
    }
}
