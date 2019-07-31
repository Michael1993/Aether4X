package com.aether.ui.drawers;

import com.aether.model.CelestialBody;
import com.aether.ui.UiPlanet;
import com.aether.ui.eventhandlers.MapDragHandler;
import com.aether.ui.eventhandlers.MapScrollHandler;

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
     * Stanard entry point of the application.
     * @param args parameter arguments for the application when called from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Aether 0X");

        final Group root = new Group();
        final Pane pane = new Pane(root);

        final Node node = asNode(new TestPlanet());

        pane.getChildren().add(node);
        final Scene scene = new Scene(pane);
        registerHandlers(node, scene);
        scene.setUserAgentStylesheet("system.css");
        pane.getStyleClass().add("system");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    Circle orbit(UiPlanet body, Point2D center) {
        final var orbitRadius = body.getOrbitRadius();
        final var orbit = new Circle(orbitRadius);
        orbit.setCenterY(center.getY());
        orbit.setCenterX(center.getX());
        orbit.getStyleClass().add("orbit");
        return orbit;
    }

    Circle planet(UiPlanet body, Point2D center) {
        final Circle planet = new Circle(body.getDiameter());
        planet.setCenterX(center.getX() + body.getOrbitRadius());
        planet.setCenterY(center.getY());
        planet.getStyleClass().add("planet");
        return planet;
    }

    Node name(UiPlanet body, Circle planet) {
        final Text planetName = new Text("Earth");

        final Point2D center =
            planet.localToParent(
                planet.getCenterX(),
                planet.getCenterY()
            );
        planetName.setX(center.getX() - planetName.getText().length() * 2);
        planetName.setY(center.getY() + body.getDiameter() * 2 * 2);
        planetName.getStyleClass().add("planet-name");

        return planetName;
    }

    void rotate(UiPlanet body, Circle planet, Point2D center) {
        final double currentTime = 90;
        body.rotate(currentTime, center);
        planet.getTransforms().add(body.getCurrentRotation());
    }

    Node asNode(CelestialBody body) {
        final Point2D center = new Point2D(80, 80);
        final UiPlanet planetBody = new UiPlanet(body, 0);
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
        final MapDragHandler dragHandler = new MapDragHandler();
        scene.setOnMouseDragged(mouseDragEvent -> {
            dragHandler.drag(mouseDragEvent, node);
        });
        scene.setOnMouseReleased(mouseEvent -> {
            if (!mouseEvent.isDragDetect()) {
                dragHandler.stop();
            }
        });
        final MapScrollHandler scrollHandler = new MapScrollHandler();
        scene.setOnScroll(scrollEvent -> {
            scrollHandler.scroll(scrollEvent, node);
        });
    }

    private static final class TestPlanet implements CelestialBody {
        private static final double STARTING_ANGLE = 0;
        private static final long ORBIT_RADIUS = 60;
        private static final long PLANET_RADIUS = 5;

        private TestPlanet() {
        }

        @Override public double getMass() {
            return 0;
        }

        @Override public double getDiameter() {
            return PLANET_RADIUS;
        }

        @Override public double getRotationPeriod() {
            return 0;
        }

        @Override public double getOrbitPeriod() {
            return 365.0;
        }

        @Override public double getApoapsis() {
            return ORBIT_RADIUS;
        }

        @Override public double getPeriapsis() {
            return ORBIT_RADIUS;
        }

        @Override public CelestialBody[] getOrbitingBodies() {
            return new CelestialBody[0];
        }
    }
}
