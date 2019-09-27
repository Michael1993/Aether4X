package com.aether.ui.views;

/**
 * Scaling the astronomical units to computer screen pixels.
 */
enum Scales {
    MASS_SCALE(1.0),
    KM_TO_PIXEL(1.0 / 1000.0),
    AU_TO_PIXEL(105.0);
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
