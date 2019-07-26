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

public class HelloJava extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Aether 0X");

        Group root = new Group();
        Pane pane = new Pane(root);

        TestPlanet testPlanet = new TestPlanet();
        final Node node = testPlanet.asNode();

        pane.getChildren().add(node);
        Scene scene = new Scene(pane);
        final MapDragHandler dragHandler = new MapDragHandler();
        scene.setOnMouseDragged(mouseDragEvent -> {
            dragHandler.drag(mouseDragEvent, node);
        });
        scene.setOnMouseReleased(mouseEvent -> {
            if(!mouseEvent.isDragDetect()) {
                dragHandler.stop();
            }
        });

        final MapScrollHandler scrollHandler = new MapScrollHandler();

        scene.setOnScroll(scrollEvent -> {
            scrollHandler.scroll(scrollEvent, node);
        });
        scene.setUserAgentStylesheet("system.css");
        pane.getStyleClass().add("system");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private static class TestPlanet {
        private double startingAngle = 0.0;
        private double anglePerDay = 1.0;
        private double currentTime = 90;

        private Point2D centerOfSystem = new Point2D(80,80);
        private long orbitRadius = 60;
        private long planetRadius = 5;
        private String planetName = "Earth";

        private Rotate currentRotation;

        Circle orbit() {
            Circle orbit = new Circle(orbitRadius);
            orbit.setCenterX(centerOfSystem.getX());
            orbit.setCenterY(centerOfSystem.getY());
            orbit.getStyleClass().add("orbit");
            return orbit;
        }

        Circle planet() {
            Circle planet = new Circle(planetRadius);
            planet.setCenterX(centerOfSystem.getX() + orbitRadius);
            planet.setCenterY(centerOfSystem.getY());
            planet.getStyleClass().add("planet");

            planet.getTransforms().add(rotation());

            return planet;
        }



        Node name(Circle planet) {
            Text planetName = new Text(this.planetName);

            final Point2D center = planet.localToParent(planet.getCenterX(), planet.getCenterY());

            planetName.setX(center.getX() - this.planetName.length() * 2);
            planetName.setY(center.getY() + planetRadius * 4);

            planetName.getStyleClass().add("planet-name");

            return planetName;
        }

        Rotate rotation() {
            double angle = startingAngle + anglePerDay * currentTime;
            if(currentRotation == null || currentRotation.getAngle() != angle) {
                currentRotation = new Rotate(-angle, centerOfSystem.getX(), centerOfSystem.getY());
            }
            return currentRotation;
        }

        Node asNode() {
            Group celestial = new Group();
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
