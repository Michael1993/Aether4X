/*
    MIT License
    Copyright (c) 2023 Mihály Verhás
    See LICENSE file.
*/
package com.aether.ui.event;

import java.util.EnumSet;

import javafx.event.EventType;
import javafx.scene.Node;
import javafx.scene.input.ScrollEvent;

/** Handles mouse wheel events for the map. */
public final class MapZoomHandler implements NodeBasedEventHandler<ScrollEvent> {

	static final double DEFAULT_ZOOM_LEVEL = 1.0;
	private static final double MIN_ZOOM_LEVEL = 0.5;
	private static final double MAX_ZOOM_LEVEL = 2.0;
	private static final double SCROLL_SCALING = 400.0;

	private Node map;

	/**
	 * Creates a new map zoom handler.
	 * This should be called automatically when loading in handlers.
	 */
	public MapZoomHandler() {
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
	public EventType<ScrollEvent> eventType() {
		return ScrollEvent.ANY;
	}

	/**
	 * Handles the mouse scrolling - zooms in or zooms out.
	 *
	 * @param event the scroll event.
	 */
	@Override
	public void handle(ScrollEvent event) {
		final double delta = event.getDeltaY() / SCROLL_SCALING;
		if (!(map.getScaleX() <= MIN_ZOOM_LEVEL && delta < 0) && !(map.getScaleX() >= MAX_ZOOM_LEVEL && delta > 0)) {
			map.setScaleY(map.getScaleY() + delta);
			map.setScaleX(map.getScaleX() + delta);
		}
	}

}
