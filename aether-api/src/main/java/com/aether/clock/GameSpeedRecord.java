/*
    MIT License
    Copyright (c) 2026 Mihály Verhás
    See LICENSE file.
*/
package com.aether.clock;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * Package-private value record that backs {@link GameSpeed#of}.
 */
record GameSpeedRecord(BigDecimal value, TimeUnit unit) implements GameSpeed {
}
