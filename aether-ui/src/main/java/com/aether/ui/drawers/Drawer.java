package com.aether.ui.drawers;

/**
 * Draws or updates the specified resource with data from the specified resource.
 * Once I am more familiar with JavaFX, this should be updated with non-generic type params.
 * This interface will be moved to aether-api, to make replacing the UI easier.
 * @param <I> the resource that should be updated.
 * @param <T> the resource that should provide the data.
 */
public interface Drawer<I, T> {
    /**
     * Draw the map from the type.
     * @param context the screen.
     * @param type the data that should be used for the update.
     */
    void draw(I context, T type);

    /**
     * Update the map from the type.
     * This should take into consideration that the map was already drawn previously,
     * e.g.: Should not re-draw orbits for the solar system map.
     * @param context the screen.
     * @param type the data that should be used for the update.
     */
    void update(I context, T type);
}
