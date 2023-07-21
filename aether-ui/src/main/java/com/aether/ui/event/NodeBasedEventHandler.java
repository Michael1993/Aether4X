/*
    MIT License
    Copyright (c) 2023 Mihály Verhás
    See LICENSE file.
*/
package com.aether.ui.event;

import java.util.EnumSet;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Node;

/**
 * An event handler that must be initialized with a {@link Node}.
 *
 * @param <T> the event class this handler can handle
 */
public interface NodeBasedEventHandler<T extends Event> extends EventHandler<T> {

	/**
	 * Initializes the event handler with the given node.
	 *
	 * @param node the node the event handler is working with
	 */
	void init(Node node);

	/**
	 * The nodes this event handler works on.
	 *
	 * @return a set of {@link Nodes} identifying
	 * what this event handler should be registered on
	 */
	EnumSet<Nodes> nodes();

	/**
	 * The event type this event handler must be registered with.
	 *
	 * @return the event type this event handler must be registered with
	 */
	EventType<T> eventType();

}
