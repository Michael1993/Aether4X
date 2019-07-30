package com.aether.ui.drawers;

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
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

/**
 * Class for experimenting with JavaFX.
 */
public final class HelloJava extends Application {

    private HelloJava() {
    }

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

        final Node node = new TestPlanet().asNode();

        pane.getChildren().add(node);
        final Scene scene = new Scene(pane);
        registerHandlers(node, scene);
        scene.setUserAgentStylesheet("system.css");
        pane.getStyleClass().add("system");
        primaryStage.setScene(scene);
        primaryStage.show();
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

    private static final class TestPlanet {
        private static final double STARTING_ANGLE = 0;
        private static final double CENTER_X = 80;
        private static final double CENTER_Y = 80;
        private static final long ORBIT_RADIUS = 60;
        private static final long PLANET_RADIUS = 5;
        private Point2D centerOfSystem = new Point2D(CENTER_X, CENTER_Y);

        private Rotate currentRotation;

        private TestPlanet() {
        }

        Circle orbit() {
            final Circle orbit = new Circle(ORBIT_RADIUS);
            orbit.setCenterX(centerOfSystem.getX());
            orbit.setCenterY(centerOfSystem.getY());
            orbit.getStyleClass().add("orbit");
            return orbit;
        }

        Circle planet() {
            final Circle planet = new Circle(PLANET_RADIUS);
            planet.setCenterX(centerOfSystem.getX() + ORBIT_RADIUS);
            planet.setCenterY(centerOfSystem.getY());
            planet.getStyleClass().add("planet");

            planet.getTransforms().add(rotation());

            return planet;
        }

        Node name(Circle planet) {
            final Text planetName = new Text("Earth");

            final Point2D center =
                planet.localToParent(
                    planet.getCenterX(),
                    planet.getCenterY()
                );
            planetName.setX(center.getX() - planetName.getText().length() * 2);
            planetName.setY(center.getY() + PLANET_RADIUS * 2 * 2);
            planetName.getStyleClass().add("planet-name");

            return planetName;
        }

        Rotate rotation() {
            final double anglePerDay = 1.0;
            final double currentTime = 90;
            final double angle = STARTING_ANGLE + anglePerDay * currentTime;
            if (currentRotation == null
                || currentRotation.getAngle() != angle) {
                currentRotation = new Rotate(
                    -angle,
                    centerOfSystem.getX(),
                    centerOfSystem.getY()
                );
            }
            return currentRotation;
        }

        Node asNode() {
            final Group celestial = new Group();
            final var orbit = this.orbit();
            final var planet = this.planet();
            final var name = this.name(planet);
            celestial.getChildren().addAll(
                orbit,
                planet,
                name
            );

            return celestial;
        }
    }
}
