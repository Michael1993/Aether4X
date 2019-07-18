package com.verhas.aether.drawers;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HelloJava extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Aether 0X");
        Group root = new Group();
        Canvas canvas = new Canvas(300, 250);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawShapes(gc);
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private void drawShapes(GraphicsContext gc) {
        setBackground(gc);
        TestPlanet planet = new TestPlanet();
        planet.drawPlanet(gc);
    }

    private void setBackground(GraphicsContext gc) {
        gc.setFill(Color.DARKBLUE);
        gc.fillRect(0,0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
    }

    private class TestPlanet {
        private double orbitTime = 360.0;
        private double currentTime = 70.0;

        private long orbitRadius = 30;
        private long planetRadius = 14;
        private String planetName = "Earth";

        void drawPlanet(GraphicsContext gc) {
            double angle = Math.toDegrees((currentTime / orbitTime) * orbitRadius);
            gc.setFill(Color.BLUE);
            gc.setStroke(Color.LIGHTGREEN);
            gc.setLineWidth(1);
            double planetX = 10 + orbitRadius  - planetRadius + orbitRadius * Math.sin(angle);
            double planetY = 10 + orbitRadius - planetRadius + orbitRadius * Math.cos(angle);
            gc.strokeOval(10, 10, orbitRadius * 2, orbitRadius * 2);
            gc.fillOval(planetX, planetY, planetRadius * 2, planetRadius * 2);
            gc.setFont(new Font("Arial", 10.0));
            gc.strokeText(planetName, planetX, planetY + planetRadius * 2 + 10);
        }
    }
}
