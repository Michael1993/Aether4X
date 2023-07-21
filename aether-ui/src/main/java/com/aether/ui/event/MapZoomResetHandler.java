/*
    MIT License
    Copyright (c) 2023 Mihály Verhás
    See LICENSE file.
*/
package com.aether.ui.event;

import java.util.EnumSet;

import javafx.event.EventType;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;

/**
 * Handles key presses related to map zoom reset.
 */
public class MapZoomResetHandler implements NodeBasedEventHandler<KeyEvent> {

	private Node map;

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
	public EventType<KeyEvent> eventType() {
		return KeyEvent.ANY;
	}

	/**
	 * Resets the zoom level to default if Ctrl + 0 is pressed.
	 *
	 * @param event the event we check
	 */
	@Override
	public void handle(KeyEvent event) {
		if (new KeyCodeCombination(KeyCode.DIGIT0, KeyCombination.CONTROL_ANY).match(event)) {
			map.setScaleX(MapZoomHandler.DEFAULT_ZOOM_LEVEL);
			map.setScaleY(MapZoomHandler.DEFAULT_ZOOM_LEVEL);
		}
	}

}
