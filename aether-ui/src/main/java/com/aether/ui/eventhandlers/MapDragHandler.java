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

    private final Node map;

    /**
     * Creates a MapDragHandler which acts on the specified Node.
     *
     * @param map the map we want to drag.
     */
    public MapDragHandler(Node map) {
        this.map = map;
    }

    /**
     * This method handles the actual dragging of the map.
     *
     * @param event the mouse event that contains the data about the dragging.
     */
    public void drag(MouseEvent event) {
        if (start != null) {
            map.getTransforms().add(
                    Transform.translate(
                            (event.getSceneX() - start.getX()) / map.getScaleX(),
                            (event.getSceneY() - start.getY()) / map.getScaleY()
                    )
            );
        }
        start = new Point2D(event.getSceneX(), event.getSceneY());
    }

    /**
     * Called when the dragging ends.
     *
     * @param event the event we check for dragging end.
     */
    public void stopAtDragEnd(MouseEvent event) {
        if (!event.isDragDetect()) {
            start = null;
        }
    }
}
