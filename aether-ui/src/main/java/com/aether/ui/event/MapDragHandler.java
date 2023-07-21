/*
    MIT License
    Copyright (c) 2023 Mihály Verhás
    See LICENSE file.
*/
package com.aether.ui.event;

import java.util.EnumSet;

import javafx.event.EventType;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.transform.Transform;

/** Handles mouse drag events for the map. */
public final class MapDragHandler implements NodeBasedEventHandler<MouseEvent> {

	private Point2D start;

	private Node map;

	/**
	 * Creates a map drag handler.
	 * This should be called automatically when loading in handlers.
	 */
	public MapDragHandler() {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void init(Node node) {
		this.map = node;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EnumSet<Nodes> nodes() {
		return EnumSet.of(Nodes.MAP);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EventType<MouseEvent> eventType() {
		return MouseEvent.ANY;
	}

	/**
	 * This method handles the actual dragging of the map.
	 *
	 * @param event the mouse event that contains the data about the dragging.
	 */
	@Override
	public void handle(MouseEvent event) {
		if (event.getEventType().equals(MouseEvent.MOUSE_DRAGGED)) {
			if (start != null) {
				map
						.getTransforms()
						.add(Transform
								.translate((event.getSceneX() - start.getX()) / map.getScaleX(),
									(event.getSceneY() - start.getY()) / map.getScaleY()));
			}
			start = new Point2D(event.getSceneX(), event.getSceneY());
		} else {
			start = null;
		}
	}

}
