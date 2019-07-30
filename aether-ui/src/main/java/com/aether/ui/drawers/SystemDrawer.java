package com.aether.ui.drawers;

import com.aether.domain.celestials.SolarSystem;

import javafx.geometry.Point2D;
import javafx.scene.Parent;

/**
 * Draws a System to a supplied JavaFX Parent.
 */
public class SystemDrawer implements Drawer<Parent, SolarSystem> {

    private Point2D center;

    @Override public void draw(Parent context, SolarSystem type) {
    }

    @Override public void update(Parent context, SolarSystem type) {
    }

    private void drawOrbit() {
    }

    private void drawPlanet(Point2D point, double radius) {
    }
}
