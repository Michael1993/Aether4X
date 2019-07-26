# Aether4X
A clone of [Aurora](), written in Java.

## Goals
I aim to create a highly modular clone of Aurora, meaning it should be fairly simple to:
 * Replace the data.
 * Replace the UI.
 * Replace some gameplay rules.
 
The current plan is to use 
 * PostGreSQL for data that doesn't change (i.e.: Space object data)
 * JSON for data subject to change (i.e.: game data)
 * JavaFX for UI
