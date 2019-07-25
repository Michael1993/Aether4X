package com.verhas.aether.domain.celestials;

import javax0.geci.core.annotations.Accessor;

@Accessor
public class CelestialBody {
    private final String name;
    private final double orbitalPeriod;

    private CelestialBody(String name, double orbitalPeriod) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
    }

    //<editor-fold id="accessor">
    public String getName(){
        return name;
    }

    public double getOrbitalPeriod(){
        return orbitalPeriod;
    }

    //</editor-fold>
}
