package com.aether.model;

/**
 * Everything implementing this interface has an exotic material and/or a regular material cost.
 */
public interface CostAssociated {
    /**
     * Gets the associated cost of basic materials.
     * @return the cost associated with the object implementing this interface.
     */
    Material[] getBasicMaterialCost();

    /**
     * Gets the associated cost of exotic materials.
     * @return the cost associated with the object implementing this interface.
     */
    ExoticMaterial[] getExoticMaterialCost();
}
