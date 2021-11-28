/*
    MIT License
    Copyright (c) 2021 Mihály Verhás
    See LICENSE file.
*/
package com.aether.ui.views;

import java.util.List;

import javafx.geometry.Point2D;
import javafx.scene.transform.Rotate;

import com.aether.model.celestials.bodies.CelestialBody;

/** A proxy class for {@code CelestialBody} to be used in JavaFX. */
public final class CelestialBodyView implements CelestialBody {

	private static final long DEFAULT_BODY_RADIUS = 5L;
	private final CelestialBody body;

	private final double startingRotation;
	private Rotate currentRotation;

	/**
	 * Creates a new proxy for the specified {@code CelestialBody}. The starting rotation is 0.
	 *
	 * @param body the body you want to proxy.
	 */
	public CelestialBodyView(CelestialBody body) {
		this(body, 0.0);
	}

	/**
	 * Creates a new proxy for the specified {@code CelestialBody}. The rotation starts from the
	 * 'right side' (or 3 o'clock) of the orbit.
	 *
	 * @param body the body you want to proxy.
	 * @param startingRotation the starting rotation of this body.
	 */
	public CelestialBodyView(CelestialBody body, double startingRotation) {
		this.body = body;
		this.startingRotation = startingRotation;
		currentRotation = new Rotate(startingRotation);
	}

	@Override
	public String name() {
		return body.name();
	}

	@Override
	public String type() {
		return body.type();
	}

	@Override
	public double mass() {
		return body.mass();
	}

	@Override
	public double radius() {
		return DEFAULT_BODY_RADIUS;
	}

	@Override
	public double rotationPeriod() {
		return body.rotationPeriod();
	}

	@Override
	public double orbitPeriod() {
		return body.orbitPeriod();
	}

	@Override
	public double apoapsis() {
		return body.apoapsis() * Scales.AU_TO_PIXEL.scale();
	}

	@Override
	public double periapsis() {
		return body.periapsis() * Scales.AU_TO_PIXEL.scale();
	}

	@Override
	public List<CelestialBody> orbitingBodies() {
		return body.orbitingBodies();
	}

	/**
	 * Gets the current rotation of the planet.
	 *
	 * @return the current rotation around the center.
	 */
	public Rotate getCurrentRotation() {
		return currentRotation;
	}

	/**
	 * Rotates the planet around the center (specified in the param).
	 *
	 * @param timePeriod how much time has passed.
	 * @param center the position around which planet should rotate.
	 */
	public void rotate(double timePeriod, Point2D center) {
		final double angle = startingRotation + (360 / orbitPeriod()) * timePeriod;
		if (currentRotation.getAngle() != angle) {
			currentRotation = new Rotate(-angle, center.getX(), center.getY());
		}
	}

}
