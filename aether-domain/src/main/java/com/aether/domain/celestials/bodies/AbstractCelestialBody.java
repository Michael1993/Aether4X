/*
    MIT License
    Copyright (c) 2020 Mihály Verhás
    See LICENSE file.
*/
package com.aether.domain.celestials.bodies;

import java.util.List;

import com.aether.model.celestials.bodies.CelestialBody;

/** TODO. */
public abstract class AbstractCelestialBody implements CelestialBody {

	private final String name;
	private final double mass;
	private final double radius;
	private final double rotationPeriod;
	private final double orbitPeriod;
	private final double apoapsis;
	private final double periapsis;
	private final List<CelestialBody> orbitingBodies;

	/**
	 * Creates an abstract celestial body.
	 *
	 * @param name
	 * @param mass
	 * @param radius
	 * @param rotationPeriod
	 * @param orbitPeriod
	 * @param apoapsis
	 * @param periapsis
	 * @param orbitingBodies
	 */
	@SuppressWarnings("checkstyle:ParameterNumber")
	protected AbstractCelestialBody(String name, double mass, double radius, double rotationPeriod, double orbitPeriod,
			double apoapsis, double periapsis, List<CelestialBody> orbitingBodies) {
		this.name = name;
		this.mass = mass;
		this.radius = radius;
		this.rotationPeriod = rotationPeriod;
		this.orbitPeriod = orbitPeriod;
		this.apoapsis = apoapsis;
		this.periapsis = periapsis;
		this.orbitingBodies = orbitingBodies;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public abstract String getType();

	@Override
	public double getMass() {
		return mass;
	}

	@Override
	public double getRadius() {
		return radius;
	}

	@Override
	public double getRotationPeriod() {
		return rotationPeriod;
	}

	@Override
	public double getOrbitPeriod() {
		return orbitPeriod;
	}

	@Override
	public double getApoapsis() {
		return apoapsis;
	}

	@Override
	public double getPeriapsis() {
		return periapsis;
	}

	@Override
	public List<CelestialBody> getOrbitingBodies() {
		return orbitingBodies;
	}

}
