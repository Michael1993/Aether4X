package com.aether.ui.eventhandlers;

import javafx.scene.Node;
import javafx.scene.input.ScrollEvent;

/**
 * Handles mousewheel events for the map.
 */
public final class MapScrollHandler {
    private static final double MIN_ZOOM_LEVEL = 0.5;
    private static final double MAX_ZOOM_LEVEL = 2.0;
    private double scrollLevel = 1.0;

    /**
     * Handles the mouse scrolling.
     * @param event the scroll event.
     * @param toScroll the map we want to zoom in on.
     */
    public void scroll(ScrollEvent event, Node toScroll) {
        final double delta = event.getDeltaY() / 400;
        if (!(scrollLevel <= MIN_ZOOM_LEVEL && delta < 0)
            && !(scrollLevel >= MAX_ZOOM_LEVEL && delta > 0)) {
            scrollLevel += delta;
            toScroll.setScaleY(scrollLevel);
            toScroll.setScaleX(scrollLevel);
        }
    }
}
