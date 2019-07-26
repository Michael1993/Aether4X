package com.aether.domain.celestials;

import java.util.List;

public final class System {
    private final List<CelestialBody> objects;

    public System(List<CelestialBody> objects) {
        this.objects = objects;
    }
}
