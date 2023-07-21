/*
    MIT License
    Copyright (c) 2023 Mihály Verhás
    See LICENSE file.
*/
package com.aether.view;

/** Represents a screen/window. */
public interface Screen {

	/**
	 * Called when the screen/window should be created. Should NOT be called when an open window
	 * regains the focus.
	 */
	void show();

	/** Called when the screen/window is closed. */
	void hide();

	/**
	 * Called when the screen should be updated with new data. Should be called when it regains the
	 * focus.
	 */
	void update();

}
