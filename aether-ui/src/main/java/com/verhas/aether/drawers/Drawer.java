package com.verhas.aether.drawers;

import javafx.scene.canvas.GraphicsContext;

public interface Drawer <T> {
    void draw(GraphicsContext context, T type);
}
