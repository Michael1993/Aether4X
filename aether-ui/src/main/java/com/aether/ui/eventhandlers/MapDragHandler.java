package com.aether.ui.eventhandlers;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.transform.Transform;

public class MapDragHandler {
    private Point2D start;

    public void drag(MouseEvent event, Node toDrag) {
        if(start != null) {
            toDrag.getTransforms().add(Transform.translate(event.getSceneX() - start.getX(), event.getSceneY() - start.getY()));
        }
        start = new Point2D(event.getSceneX(), event.getSceneY());
    }

    public void stop() {
        start = null;
    }
}
