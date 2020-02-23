package com.aether.ui.views;

import com.aether.model.celestials.CelestialBody;

import javafx.geometry.Point2D;
import javafx.scene.transform.Rotate;

/**
 * A proxy class for {@code CelestialBody} to be used in JavaFX.
 */
public final class CelestialBodyView implements CelestialBody {
    private static final long DEFAULT_BODY_RADIUS = 5L;
    private final CelestialBody body;

    private final double startingRotation;
    private Rotate currentRotation;

    /**
     * Creates a new proxy for the specified {@code CelestialBody}.
     * The starting rotation is 0.
     * @param body the body you want to proxy.
     */
    public CelestialBodyView(CelestialBody body) {
        this.body = body;
        this.startingRotation = 0.0;
        currentRotation = new Rotate(startingRotation);
    }

    /**
     * Creates a new proxy for the specified {@code CelestialBody}.
     * The rotation starts from the 'right side' (or 3 o'clock) of the orbit.
     * @param body the body you want to proxy.
     * @param startingRotation the starting rotation of this body.
     */
    public CelestialBodyView(CelestialBody body, double startingRotation) {
        this.body = body;
        this.startingRotation = startingRotation;
        currentRotation = new Rotate(startingRotation);
    }

    @Override
    public String getName() {
        return body.getName();
    }

    @Override
    public String getType() {
        return body.getType();
    }

    @Override
    public double getMass() {
        return body.getMass() * Scales.MASS_SCALE.scale();
    }

    @Override
    public double getRadius() {
        return body.getRadius() * Scales.KM_TO_PIXEL.scale();
    }

    @Override
    public double getRotationPeriod() {
        return body.getRotationPeriod();
    }

    @Override
    public double getOrbitPeriod() {
        return body.getOrbitPeriod();
    }

    @Override
    public double getApoapsis() {
        return body.getApoapsis() * Scales.AU_TO_PIXEL.scale();
    }

    @Override
    public double getPeriapsis() {
        return body.getPeriapsis() * Scales.AU_TO_PIXEL.scale();
    }

    @Override
    public CelestialBody[] getOrbitingBodies() {
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
        final double angle = startingRotation + (360 / getOrbitPeriod()) * timePeriod;
        if (currentRotation.getAngle() != angle) {
            currentRotation = new Rotate(
                -angle,
                center.getX(),
                center.getY()
            );
        }
    }
}
