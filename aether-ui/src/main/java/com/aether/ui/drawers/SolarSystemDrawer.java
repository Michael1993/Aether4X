package com.aether.ui.drawers;

import com.aether.model.celestials.CelestialObject;

import javafx.geometry.Point2D;
import javafx.scene.Group;

/**
 * Draws a solar system to a supplied JavaFX {@link Group}.
 */
public class SolarSystemDrawer implements Drawer<Group, CelestialObject> {
    private final PlanetDrawer planetDrawer;

    /**
     * Creates a new SolarSystemDrawer with the specified center point.
     * @param center the center of the screen
     */
    public SolarSystemDrawer(Point2D center) {
        this.planetDrawer = new PlanetDrawer(center);
    }

    @Override public void draw(Group context, CelestialObject type) {
        type.getBodies().forEach(planet ->
            planetDrawer.draw(context, planet)
        );
    }

    @Override public void update(Group context, CelestialObject type) {
    }
}
