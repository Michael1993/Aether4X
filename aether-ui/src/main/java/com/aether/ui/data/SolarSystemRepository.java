/*
    MIT License
    Copyright (c) 2026 Mihály Verhás
    See LICENSE file.
*/
package com.aether.ui.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.aether.domain.celestials.bodies.Planet;
import com.aether.domain.celestials.bodies.Star;
import com.aether.domain.celestials.objects.PlanetarySystem;
import com.aether.model.celestials.bodies.BodyType;
import com.aether.model.celestials.bodies.CelestialBody;
import com.aether.model.celestials.bodies.Star.StarColor;

/** Loads the Solar System and its bodies from the Aether database. */
public final class SolarSystemRepository {

	private static final String NAME = "Sol-0";

	// Must match liquibase/liquibase.properties: that's the file Liquibase populates,
	// and this is the same file the running application reads from.
	private static final String JDBC_URL = "jdbc:h2:~/.aether4x/aetherdb";
	private static final String JDBC_USER = "test";
	private static final String JDBC_PASSWORD = "";

	private static final String SELECT_BODIES = "SELECT name, type, mass, radius, rotation_period, "
			+ "orbit_period, apoapsis, periapsis, temperature, color FROM planets ORDER BY id";

	private SolarSystemRepository() {
	}

	/**
	 * Loads the Solar System, together with all its bodies, from the database.
	 *
	 * @return the planetary system populated from persisted data
	 */
	public static PlanetarySystem load() {
		return new PlanetarySystem(NAME, loadBodies());
	}

	private static List<CelestialBody> loadBodies() {
		final List<CelestialBody> bodies = new ArrayList<>();
		try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(SELECT_BODIES)) {
			while (resultSet.next()) {
				bodies.add(toBody(resultSet));
			}
		} catch (SQLException e) {
			throw new IllegalStateException("Could not load the solar system from the database.", e);
		}
		return bodies;
	}

	private static CelestialBody toBody(ResultSet resultSet) throws SQLException {
		final String name = resultSet.getString("name");
		final double mass = resultSet.getDouble("mass");
		final double radius = resultSet.getDouble("radius");
		final double rotationPeriod = resultSet.getDouble("rotation_period");
		final double orbitPeriod = resultSet.getDouble("orbit_period");
		final double apoapsis = resultSet.getDouble("apoapsis");
		final double periapsis = resultSet.getDouble("periapsis");
		final CelestialBody body;
		if (BodyType.STAR.name().equals(resultSet.getString("type"))) {
			body = new Star(name, mass, radius, rotationPeriod, orbitPeriod, apoapsis, periapsis, List.of(),
				resultSet.getInt("temperature"), StarColor.valueOf(resultSet.getString("color")));
		} else {
			body = new Planet(name, mass, radius, rotationPeriod, orbitPeriod, apoapsis, periapsis, List.of());
		}
		return body;
	}

}
