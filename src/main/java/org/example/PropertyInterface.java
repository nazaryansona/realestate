package org.example;

/**
 * Basic property operations.
 */
public interface PropertyInterface {
    /**
     * Apply a discount percentage to the property price.
     *
     * @param percentage discount percentage
     */
    void makeDiscount(int percentage);

    /**
     * Calculate total price with city modifiers.
     *
     * @return total price
     */
    int getTotalPrice();

    /**
     * Average square meters per room.
     *
     * @return average sqm per room
     */
    double averageSqmPerRoom();
}
