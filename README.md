# Aether4X
<img src="https://travis-ci.org/Michael1993/Aether4X.svg?branch=master"/>
A clone of [Aurora](http://aurora2.pentarch.org), written in Java.

## Goals
I aim to create a highly modular clone of Aurora, meaning it should be fairly simple to:
 * Replace the data.
 * Replace the UI.
 * Replace some gameplay rules.
Aether should also be able to load additional game logic/data and merge it with it's base.
 
The current plan is to use 
 * [PostGreSQL](https://www.postgresql.org) for data that doesn't change (i.e.: Space object data)
 * [JSON](https://www.json.org) for data subject to change (i.e.: game data)
 * [GSON](https://github.com/google/gson) for JSON serialization.
 * [JavaFX](https://openjfx.io) for UI
