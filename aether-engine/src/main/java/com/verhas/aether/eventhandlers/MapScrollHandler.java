package com.verhas.aether.eventhandlers;

import javafx.scene.Node;
import javafx.scene.input.ScrollEvent;

public class MapScrollHandler {
    private static final double MIN_ZOOM_LEVEL = 0.5;
    private static final double MAX_ZOOM_LEVEL = 2.0;
    private double scrollLevel = 1.0;

    public void scroll(ScrollEvent event, Node toScroll) {
        final double delta = event.getDeltaY() / 400;
        if(!(scrollLevel <= MIN_ZOOM_LEVEL && delta < 0) && !(scrollLevel >= MAX_ZOOM_LEVEL && delta > 0)) {
            scrollLevel += delta;
            toScroll.setScaleY(scrollLevel);
            toScroll.setScaleX(scrollLevel);
        }
    }
}
