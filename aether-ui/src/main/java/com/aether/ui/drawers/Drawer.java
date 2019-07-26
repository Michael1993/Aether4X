package com.aether.ui.drawers;

public interface Drawer<I, T> {
    void draw(I context, T type);
    void update(I context, T type);
}
