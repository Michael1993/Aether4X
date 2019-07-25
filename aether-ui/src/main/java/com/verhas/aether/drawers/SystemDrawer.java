package com.verhas.aether.drawers;

import com.verhas.aether.domain.celestials.System;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javax0.geci.annotations.Geci;

@Geci("builder")
public class SystemDrawer implements Drawer<System> {

    private Point2D center;

    @Override
    public void draw(GraphicsContext context, System system) {

    }

    private void drawOrbit() {

    }

    private void drawPlanet(Point2D point, double radius) {
    }
}
