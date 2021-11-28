/*
    MIT License
    Copyright (c) 2021 Mihály Verhás
    See LICENSE file.
*/
package com.aether.domain.celestials.bodies;

import java.util.List;

import com.aether.model.celestials.bodies.CelestialBody;

/**
 * TODO.
 */
public record Planet(String name, String type, double mass, double radius, double rotationPeriod, double orbitPeriod,
                     double apoapsis, double periapsis, List<CelestialBody> orbitingBodies) implements CelestialBody {
}
