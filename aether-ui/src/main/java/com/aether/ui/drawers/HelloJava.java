package com.aether.ui.drawers;

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

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
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
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Aether 0X");

        final Pane pane = new Pane();
        final Scene scene = new Scene(pane, 800, 800);
        final Point2D center = pane.localToScene(scene.getWidth() / 2, scene.getHeight() / 2);

        final var system = setUpSystem(pane, center);
        registerHandlers(system, scene);
        scene.setUserAgentStylesheet("system.css");
        pane.getStyleClass().add("system");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Group setUpSystem(Pane pane, Point2D center) {
        final Group system = new Group();
        drawSolarSystem(system, center);
        pane.getChildren().add(system);
        return system;
    }

    private void drawSolarSystem(Group system, Point2D center) {
        final PlanetDrawer drawer = new PlanetDrawer(center);
        drawer.draw(system, new Sun());
        drawer.draw(system, new Mercury());
        drawer.draw(system, new Venus());
        drawer.draw(system, new Earth());
        drawer.draw(system, new Mars());
        drawer.draw(system, new Jupiter());
        drawer.draw(system, new Saturn());
        drawer.draw(system, new Uranus());
        drawer.draw(system, new Neptune());
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
