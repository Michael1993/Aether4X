package com.aether.model;

/**
 * Everything implementing this interface has a prerequisite 'unlock criteria' i.e.: a technology.
 */
public interface Unlockable {
    /**
     * Gets the technology that's a prerequisite for the player to use the thing
     * implementing this interface.
     * @return the technology needed to unlock this.
     */
    Technology getUnlockCriteria();
}
