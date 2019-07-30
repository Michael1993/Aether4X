package com.aether.ui.eventhandlers;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.transform.Transform;

/**
 * Handles mouse drag events for the map.
 */
public final class MapDragHandler {
    private Point2D start;

    /**
     * This method handles the actual dragging of the map.
     * @param event the mouse event that contains the data about the dragging.
     * @param toDrag the map we want to drag around.
     */
    public void drag(MouseEvent event, Node toDrag) {
        if (start != null) {
            toDrag.getTransforms().add(
                Transform.translate(
                    event.getSceneX() - start.getX(),
                    event.getSceneY() - start.getY()
                )
            );
        }
        start = new Point2D(event.getSceneX(), event.getSceneY());
    }

    /**
     * Called when the dragging ends.
     */
    public void stop() {
        start = null;
    }
}
