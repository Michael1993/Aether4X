package com.aether.model.celestials;

/**
 * Represents a celestial body.
 * A single, tightly bound, contiguous entity.
 * I.e.:
 * - A planet
 * - A star
 * - A moon
 * - An asteroid
 * - A comet
 * A comet is considered ONLY a body and NOT an object.
 */
public interface CelestialBody {
    /**
     * Gets the name of the body. E.g.: Mars, Earth, Alpha Centauri-II.
     *
     * @return the name of this body.
     */
    String getName();

    /**
     * Gets the type of the body. E.g.: Planet, Sun, Moon.
     *
     * @return the type of this body as text.
     */
    String getType();

    /**
     * Gets the approximate mass of the body in kilograms.
     *
     * @return the mass of the current body.
     */
    double getMass();

    /**
     * Gets the approximate radius of the body in km.
     * If the body is rather uneven (e.g.: an asteroid), it should return the average radius.
     *
     * @return the radius of the current body.
     */
    double getRadius();

    /**
     * Gets the approximate rotation period of the body in hours.
     *
     * @return the amount of time it takes for the current body to do a full rotation.
     */
    double getRotationPeriod();

    /**
     * Gets the approximate rotation period of the body in days.
     *
     * @return the amount of time it takes for the current body to do a full orbit.
     */
    double getOrbitPeriod();

    /**
     * Gets the farthest point in the orbit of a planetary body about its primary body in AUs.
     * AU - Astronomical Unit. https://en.wikipedia.org/wiki/Astronomical_unit
     *
     * @return the apoapsis of the current body.
     */
    double getApoapsis();

    /**
     * Gets the nearest point in the orbit of a planetary body about its primary body in AUs.
     * AU - Astronomical Unit. https://en.wikipedia.org/wiki/Astronomical_unit
     *
     * @return the periapsis of the current body.
     */
    double getPeriapsis();

    /**
     * Gets the celestial bodies orbiting this body.
     * If no object orbits this body, it should return an empty array.
     * I.e.:
     * - Moons (in case of planets)
     * - Planets (in case of stars)
     * - Asteroids (in case of stars)
     * - Comets (in case of stars)
     *
     * @return the celestial bodies orbiting this body.
     */
    CelestialBody[] getOrbitingBodies();

    /**
     * Gets the average radius of the orbit in AUs.
     *
     * @return the sum of the apoapsis and periapsis divided by 2.
     */
    default double getOrbitRadius() {
        return (getApoapsis() + getPeriapsis()) / 2;
    }
}
