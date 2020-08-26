/*
    MIT License
    Copyright (c) 2020 Mihály Verhás
    See LICENSE file.
*/
package com.aether.ui.transformers;

import com.aether.model.celestials.bodies.CelestialBody;
import com.aether.ui.views.CelestialBodyView;

/** Transforms a CelestialBody into a CelestialBodyView. */
public final class CelestialBodyTransformer {

	private CelestialBodyTransformer() {
	}

	/**
	 * Transforms a CelestialBody into a CelestialBodyView.
	 *
	 * @param body the body to convert.
	 * @return a CelestialBodyView with 0 rotation.
	 */
	public static CelestialBodyView transform(CelestialBody body) {
		return new CelestialBodyView(body);
	}

}
