package com.aether.ui;

/**
 * Scaling the astronomical units to computer screen pixels.
 */
public enum Scales {
    MASS_SCALE(1.0),
    KM_TO_PIXEL(1.0),
    AU_TO_PIXEL(1.0);
    private double scale;

    Scales(double scale) {
        this.scale = scale;
    }

    void setScale(double scale) {
        this.scale = scale;
    }

    double scale() {
        return scale;
    }
}
