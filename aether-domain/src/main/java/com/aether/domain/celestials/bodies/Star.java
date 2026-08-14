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
public record Star(String name, double mass, double radius, double rotationPeriod, double orbitPeriod, double apoapsis,
                   double periapsis, List<CelestialBody> orbitingBodies, int temperature,
                   StarColor color) implements com.aether.model.celestials.bodies.Star {

    @Override
    public BodyType type() {
        return BodyType.STAR;
    }

}
