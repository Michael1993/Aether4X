package com.aether.ui.drawers;

import com.aether.model.celestials.CelestialBody;
import com.aether.ui.drawers.temp.Earth;
import com.aether.ui.drawers.temp.Jupiter;
import com.aether.ui.drawers.temp.Mars;
import com.aether.ui.drawers.temp.Mercury;
import com.aether.ui.drawers.temp.Neptune;
import com.aether.ui.drawers.temp.Saturn;
import com.aether.ui.drawers.temp.Sun;
import com.aether.ui.drawers.temp.Uranus;
import com.aether.ui.drawers.temp.Venus;
import com.aether.ui.eventhandlers.MapDragHandler;
import com.aether.ui.eventhandlers.MapZoomHandler;
import com.aether.ui.transformers.CelestialBodyTransformer;
import com.aether.ui.views.CelestialBodyView;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Class for experimenting with JavaFX.
 */
public final class HelloJava extends Application {
    /**
     * Standard entry point of the application.
     * @param args parameter arguments for the application when called from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Aether 0X");

        final Pane pane = new Pane();
        final Scene scene = new Scene(pane, 800, 800);
        final Point2D center = pane.localToScene(scene.getWidth() / 2, scene.getHeight() / 2);
        final Node mercury = asNode(new Mercury(), center);
        final Node venus = asNode(new Venus(), center);
        final Node earth = asNode(new Earth(), center);
        final Node mars = asNode(new Mars(), center);
        final Node jupiter = asNode(new Jupiter(), center);
        final Node saturn = asNode(new Saturn(), center);
        final Node uranus = asNode(new Uranus(), center);
        final Node neptune = asNode(new Neptune(), center);

        final Node sun = asSunNode(new Sun(), center);

        final Group system = new Group();

        system.getChildren().addAll(
            sun,
            mercury,
            venus,
            earth,
            mars,
            jupiter,
            saturn,
            uranus,
            neptune
        );
        pane.getChildren().add(system);
        registerHandlers(system, scene);
        scene.setUserAgentStylesheet("system.css");
        pane.getStyleClass().add("system");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Node asSunNode(Sun sun, Point2D center) {
        final Circle planet = new Circle(sun.getRadius());
        planet.setCenterX(center.getX());
        planet.setCenterY(center.getY());
        planet.getStyleClass().add("sun");
        return planet;
    }

    private Circle orbit(CelestialBodyView body, Point2D center) {
        final var orbitRadius = body.getOrbitRadius();
        final var orbit = new Circle(orbitRadius);
        orbit.setCenterY(center.getY());
        orbit.setCenterX(center.getX());
        orbit.getStyleClass().add("orbit");
        return orbit;
    }

    private Circle planet(CelestialBodyView body, Point2D center) {
        final Circle planet = new Circle(body.getRadius());
        planet.setCenterX(center.getX() + body.getOrbitRadius());
        planet.setCenterY(center.getY());
        planet.getStyleClass().add("planet");
        return planet;
    }

    private Node name(CelestialBodyView body, Circle planet) {
        final Text planetName = new Text(body.getName());

        final Point2D center = planet.localToParent(
            planet.getCenterX(),
            planet.getCenterY()
        );
        planetName.setX(center.getX() - planetName.getText().length() * planetName.getFont().getSize() / 2 / 2);
        planetName.setY(center.getY() + body.getRadius() + planetName.getFont().getSize());
        planetName.getStyleClass().add("planet-name");

        return planetName;
    }

    private void rotate(CelestialBodyView body, Circle planet, Point2D center) {
        final double currentTime = 90;
        body.rotate(currentTime, center);
        planet.getTransforms().add(body.getCurrentRotation());
    }

    private Node asNode(CelestialBody body, Point2D center) {
        final CelestialBodyView planetBody = CelestialBodyTransformer.transform(body);
        final Group celestial = new Group();
        final var orbit = this.orbit(planetBody, center);
        final var planet = this.planet(planetBody, center);
        rotate(planetBody, planet, center);
        final var name = this.name(planetBody, planet);
        celestial.getChildren().addAll(
            orbit,
            planet,
            name
        );
        return celestial;
    }

    private void registerHandlers(Node node, Scene scene) {
        final MapDragHandler dragHandler = new MapDragHandler(node);
        scene.setOnMouseDragged(dragHandler::drag);
        scene.setOnMouseReleased(dragHandler::stopAtDragEnd);
        final MapZoomHandler zoomHandler = new MapZoomHandler(node);
        scene.setOnScroll(zoomHandler::scroll);
        scene.setOnKeyPressed(zoomHandler::resetOnControlZero);
    }
}
