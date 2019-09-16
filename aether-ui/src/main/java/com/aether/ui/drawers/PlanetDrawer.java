package com.aether.ui.drawers;

import com.aether.model.celestials.CelestialBody;
import com.aether.ui.transformers.CelestialBodyTransformer;
import com.aether.ui.views.CelestialBodyView;

import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

/**
 * Draws a System to a supplied JavaFX Parent.
 */
public class PlanetDrawer implements Drawer<Parent, CelestialBodyView> {

    private final Point2D center;

    /**
     * Creates a new PlanetDrawer.
     * @param center the center of the system.
     */
    public PlanetDrawer(Point2D center) {
        this.center = center;
    }

    @Override public void draw(Parent context, CelestialBodyView body) {
        context.getChildrenUnmodifiable().add(asNode(body));
    }

    @Override public void update(Parent context, CelestialBodyView body) {
    }

    private Circle orbit(CelestialBodyView body) {
        final var orbitRadius = body.getOrbitRadius();
        final var orbit = new Circle(orbitRadius);
        orbit.setCenterY(center.getY());
        orbit.setCenterX(center.getX());
        orbit.getStyleClass().add("orbit");
        return orbit;
    }

    private Circle planet(CelestialBodyView body) {
        final Circle planet = new Circle(body.getRadius());
        planet.setCenterX(center.getX() + body.getOrbitRadius());
        planet.setCenterY(center.getY());
        planet.getStyleClass().add("planet");
        return planet;
    }

    private Node name(CelestialBodyView body, Circle planet) {
        final Text planetName = new Text("Earth");

        final Point2D planetCenter = planet.localToParent(
            planet.getCenterX(),
            planet.getCenterY()
        );
        planetName.setX(planetCenter.getX() - planetName.getText().length() * 2);
        planetName.setY(planetCenter.getY() + body.getRadius() * 2 * 2);
        planetName.getStyleClass().add("planet-name");

        return planetName;
    }

    private void rotate(CelestialBodyView body, Circle planet) {
        final double currentTime = 90;
        body.rotate(currentTime, center);
        planet.getTransforms().add(body.getCurrentRotation());
    }

    private Node asNode(CelestialBody body) {
        final CelestialBodyView planetBody = CelestialBodyTransformer.transform(body);
        final Group celestial = new Group();
        final var orbit = this.orbit(planetBody);
        final var planet = this.planet(planetBody);
        rotate(planetBody, planet);
        final var name = this.name(planetBody, planet);
        celestial.getChildren().addAll(
            orbit,
            planet,
            name
        );
        return celestial;
    }
}