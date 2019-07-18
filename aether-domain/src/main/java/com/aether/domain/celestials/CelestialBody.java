package com.aether.domain.celestials;

import javax0.geci.annotations.Geci;

@Geci("accessor")
@Geci("builder")
public class CelestialBody {
    private String name;
    private double orbitalPeriod;
    //<editor-fold id="accessor">
    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setOrbitalPeriod(double orbitalPeriod){
        this.orbitalPeriod = orbitalPeriod;
    }

    public double getOrbitalPeriod(){
        return orbitalPeriod;
    }

    //</editor-fold>
    //<editor-fold id="builder">
    @javax0.geci.annotations.Generated("builder")
    public static CelestialBody.Builder builder() {
        return new CelestialBody().new Builder();
    }

    public class Builder {
        @javax0.geci.annotations.Generated("builder")
        public Builder name(String name) {
            CelestialBody.this.name = name;
            return this;
        }

        @javax0.geci.annotations.Generated("builder")
        public Builder orbitalPeriod(double orbitalPeriod) {
            CelestialBody.this.orbitalPeriod = orbitalPeriod;
            return this;
        }

        @javax0.geci.annotations.Generated("builder")
        public CelestialBody build() {
            return CelestialBody.this;
        }
    }
    //</editor-fold>
}
