package com.aether.ui;

import com.aether.model.CelestialBody;

import javafx.geometry.Point2D;
import javafx.scene.transform.Rotate;

/**
 * A proxy class for JavaFX and CelestialBody.
 */
public final class UiPlanet implements CelestialBody {
    private final CelestialBody body;

    private final double startingRotation;
    private Rotate currentRotation;

    /**
     * Creates a new Proxy for the specified CelestialBody.
     * @param body the body to be wrapped.
     */
    public UiPlanet(CelestialBody body, double startingRotation) {
        this.body = body;
        this.startingRotation = startingRotation;
        currentRotation = new Rotate(startingRotation);
    }

    @Override public double getMass() {
        return body.getMass() * Scales.MASS_SCALE.scale();
    }

    @Override public double getDiameter() {
        return body.getDiameter() * Scales.KM_TO_PIXEL.scale();
    }

    @Override public double getRotationPeriod() {
        return body.getRotationPeriod();
    }

    @Override public double getOrbitPeriod() {
        return body.getOrbitPeriod();
    }

    @Override public double getApoapsis() {
        return body.getApoapsis() * Scales.AU_TO_PIXEL.scale();
    }

    @Override public double getPeriapsis() {
        return body.getPeriapsis() * Scales.AU_TO_PIXEL.scale();
    }

    @Override public CelestialBody[] getOrbitingBodies() {
        return body.getOrbitingBodies();
    }

    /**
     * Gets the current rotation of the planet.
     * @return the current rotation around the center.
     */
    public Rotate getCurrentRotation() {
        return currentRotation;
    }

    /**
     * Rotates the planet around the center (specified in the param).
     * @param timePeriod how much time has passed.
     * @param center the position around which planet should rotate.
     */
    public void rotate(double timePeriod, Point2D center) {
        final double angle = startingRotation + 360 / getOrbitPeriod() * timePeriod;
        if (currentRotation.getAngle() != angle) {
            currentRotation = new Rotate(
                -angle,
                center.getX(),
                center.getY()
            );
        }
    }
}
