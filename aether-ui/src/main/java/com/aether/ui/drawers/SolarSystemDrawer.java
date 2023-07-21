/*
    MIT License
    Copyright (c) 2023 Mihály Verhás
    See LICENSE file.
*/
package com.aether.ui.drawers;

import javafx.geometry.Point2D;
import javafx.scene.Group;

import com.aether.model.celestials.objects.CelestialObject;

/** Draws a solar system to a supplied JavaFX {@link Group}. */
public final class SolarSystemDrawer implements Drawer<Group, CelestialObject> {

	private final PlanetDrawer planetDrawer;

	/**
	 * Creates a new SolarSystemDrawer with the specified center point.
	 *
	 * @param center the center of the screen
	 */
	public SolarSystemDrawer(Point2D center) {
		this.planetDrawer = new PlanetDrawer(center);
	}

	@Override
	public void draw(Group context, CelestialObject type) {
		type.bodies().forEach(planet -> planetDrawer.draw(context, planet));
	}

	@Override
	public void update(Group context, CelestialObject type) {
	}

}
