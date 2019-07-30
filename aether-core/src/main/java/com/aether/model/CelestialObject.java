package com.aether.model;

/**
 * Represents a celestial object.
 * A complex, less cohesively bound structure,
 * which may consist of multiple bodies
 * or even other objects with substructures.
 * I.e.:
 *  - A planetary system
 *  - A star cluster
 *  - A nebulae
 *  - A galaxy
 */
public interface CelestialObject {
    /**
     * Gets the other celestial objects this object holds.
     * Note that this should NOT return celestial bodies contained in a substructure,
     * e.g.: The galaxy Milky Way should not return Sol, Earth, Mars.
     * It should return the Solar system.
     * @return the substructures of this object.
     */
    CelestialObject[] getSubstructures();

    /**
     * Gets the celestial bodies directly contained in this object.
     * If this object does not (directly) hold any bodies, it should return an empty array.
     * @return the celestial bodies contained in this object or an empty array if there is none.
     */
    CelestialBody[] getBodies();
}
