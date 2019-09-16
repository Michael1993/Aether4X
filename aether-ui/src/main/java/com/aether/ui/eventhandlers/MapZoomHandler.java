package com.aether.ui.eventhandlers;

import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.ScrollEvent;

/**
 * Handles mousewheel events for the map.
 */
public final class MapZoomHandler {
    private static final double MIN_ZOOM_LEVEL = 0.5;
    private static final double DEFAULT_ZOOM_LEVEL = 1.0;
    private static final double MAX_ZOOM_LEVEL = 2.0;
    private static final double SCROLL_SCALING = 400.0;
    private double scrollLevel;

    private final Node map;

    /**
     * Creates a new map zoom handler.
     */
    public MapZoomHandler(Node map) {
        scrollLevel = DEFAULT_ZOOM_LEVEL;
        this.map = map;
    }

    /**
     * Handles the mouse scrolling.
     * @param event the scroll event.
     */
    public void scroll(ScrollEvent event) {
        final double delta = event.getDeltaY() / SCROLL_SCALING;
        if (!(scrollLevel <= MIN_ZOOM_LEVEL && delta < 0)
            && !(scrollLevel >= MAX_ZOOM_LEVEL && delta > 0)) {
            scrollLevel += delta;
            scrollToLevel();
        }
    }

    private void scrollToLevel() {
        map.setScaleY(scrollLevel);
        map.setScaleX(scrollLevel);
    }

    /**
     * Resets the zoom level to default if Ctrl + 0 is pressed.
     * @param event the event we check
     */
    public void resetOnControlZero(KeyEvent event) {
        final KeyCodeCombination controlZero = new KeyCodeCombination(KeyCode.DIGIT0, KeyCombination.CONTROL_ANY);
        if (controlZero.match(event)) {
            scrollLevel = DEFAULT_ZOOM_LEVEL;
            scrollToLevel();
        }
    }
}
