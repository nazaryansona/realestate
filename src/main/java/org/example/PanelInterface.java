package org.example;

/**
 * Additional operations for panel type properties.
 */
public interface PanelInterface {
    /**
     * Compare price equality with another RealEstate instance.
     *
     * @param other other property
     * @return true if equal
     */
    boolean hasSameAmount(RealEstate other);

    /**
     * Calculate price per room.
     *
     * @return integer price per room
     */
    int roomPrice();
}
