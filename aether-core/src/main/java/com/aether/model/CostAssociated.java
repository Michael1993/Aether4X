package com.aether.model;

/**
 * Everything implementing this interface has a trans-newtonian cost and/or a material need.
 */
public interface CostAssociated {
    /**
     * Gets the associated cost of basic materials.
     * @return the cost associated with this.
     */
    Material[] getBasicMaterialCost();

    /**
     * Gets the associated cost of trans-newtonian materials.
     * @return the cost associated with this.
     */
    TransNewtonianMaterial getTransNewtonianMaterialCost();
}
