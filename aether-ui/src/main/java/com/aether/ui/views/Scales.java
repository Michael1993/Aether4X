/*
    MIT License
    Copyright (c) 2021 Mihály Verhás
    See LICENSE file.
*/
package com.aether.ui.views;

/** Scaling the astronomical units to computer screen pixels. */
enum Scales {

	KM_TO_PIXEL(1.0 / 1000.0), AU_TO_PIXEL(105.0);
	private final double scale;

	Scales(double scale) {
		this.scale = scale;
	}

	double scale() {
		return scale;
	}

}
