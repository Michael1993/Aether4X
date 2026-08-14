/*
    MIT License
    Copyright (c) 2026 Mihály Verhás
    See LICENSE file.
*/
package com.aether.domain.celestials.bodies;

import java.util.List;

import com.aether.model.celestials.bodies.BodyType;
import com.aether.model.celestials.bodies.CelestialBody;

/**
 * TODO.
 */
public record Planet(String name, double mass, double radius, double rotationPeriod, double orbitPeriod,
                     double apoapsis, double periapsis, List<CelestialBody> orbitingBodies) implements CelestialBody {

    @Override
    public BodyType type() {
        return BodyType.PLANET;
    }

}
