package com.aether.model.celestials;

import java.util.List;

/**
 * Represents a celestial object.
 * A complex, less cohesively bound structure,
 * which may consist of multiple bodies
 * or even other objects with substructures.
 * I.e.:
 * - A planetary system
 * - A star cluster
 * - A nebulae
 * - A galaxy
 */
public interface CelestialObject {
    /**
     * Gets the name of this celestial object. E.g.: Eagle Nebula.
     *
     * @return the name of this object
     */
    String getName();

    /**
     * Gets the type of this celestial object. E.g.: planetary system.
     *
     * @return the type of this object as text
     */
    String getType();

    /**
     * Gets the other celestial objects this object holds.
     * If this object does not hold any objects, it should return an empty list.
     * Note that this should NOT return celestial bodies contained in a substructure,
     * e.g.: The galaxy Milky Way should not return Sol, Earth, Mars.
     * It should return the planetary systems.
     *
     * @return the substructures of this object
     */
    List<CelestialObject> getSubstructures();

    /**
     * Gets the celestial bodies directly contained in this object.
     * If this object does not (directly) hold any bodies, it should return an empty list.
     *
     * @return the celestial bodies contained in this object or an empty array if there is none
     */
    List<CelestialBody> getBodies();
}
