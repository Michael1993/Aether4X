/*
    MIT License
    Copyright (c) 2020 Mihály Verhás
    See LICENSE file.
*/
package com.aether.ui.drawers;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import com.aether.ui.drawers.temp.SolarSystem;
import com.aether.ui.eventhandlers.MapDragHandler;
import com.aether.ui.eventhandlers.MapZoomHandler;

/** Class for experimenting with JavaFX. */
public final class HelloJava extends Application {

	/**
	 * Standard entry point of the application.
	 *
	 * @param args parameter arguments for the application when called from the command line.
	 */
	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Aether 0X");

		final var scene = createScene();
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private Scene createScene() {
		final Pane pane = new Pane();
		final Scene scene = new Scene(pane, 800, 800);
		final Point2D center = pane.localToScene(scene.getWidth() / 2, scene.getHeight() / 2);

		final var system = setUpSystem(pane, center);
		registerHandlers(system, scene);
		scene.setUserAgentStylesheet("system.css");
		pane.getStyleClass().add("system");
		return scene;
	}

	private Group setUpSystem(Pane pane, Point2D center) {
		final Group system = new Group();
		drawSolarSystem(system, center);
		pane.getChildren().add(system);
		return system;
	}

	private void drawSolarSystem(Group system, Point2D center) {
		final SolarSystemDrawer drawer = new SolarSystemDrawer(center);
		drawer.draw(system, new SolarSystem());
	}

	private void registerHandlers(Node system, Scene scene) {
		final var dragHandler = new MapDragHandler(system);
		scene.setOnMouseDragged(dragHandler::drag);
		scene.setOnMouseReleased(dragHandler::stopAtDragEnd);
		final var zoomHandler = new MapZoomHandler(system);
		scene.setOnScroll(zoomHandler::scroll);
		scene.setOnKeyPressed(zoomHandler::resetOnControlZero);
	}

}
