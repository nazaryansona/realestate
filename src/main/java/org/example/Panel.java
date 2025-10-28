package org.example;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A panel (apartment) type of RealEstate with floor and insulation attributes.
 */
public class Panel extends RealEstate implements PanelInterface {
    private static final Logger logger = Logger.getLogger(Panel.class.getName());
    static { LoggerConfig.configureLogger(logger); }

    private int floor;
    private boolean isInsulated;

    /**
     * Constructor for Panel.
     *
     * @param city          city name
     * @param price         price per sqm
     * @param sqm           square meters
     * @param numberOfRooms number of rooms
     * @param genre         property genre
     * @param floor         floor number
     * @param isInsulated   true if insulated
     */
    public Panel(String city, double price, int sqm, double numberOfRooms, Genre genre, int floor, boolean isInsulated) {
        super(city, price, sqm, numberOfRooms, genre);
        logger.info("Creating Panel: floor=" + floor + ", insulated=" + isInsulated);
        this.floor = floor;
        this.isInsulated = isInsulated;
    }

    /**
     * Calculate the total price for the panel, applying floor and insulation modifiers.
     *
     * @return total price as integer
     */
    @Override
    public int getTotalPrice() {
        logger.info("Panel.getTotalPrice called (floor=" + floor + ", insulated=" + isInsulated + ")");
        double total = super.getTotalPrice();
        try {
            if (floor >= 0 && floor <= 2) total *= 1.05;
            if (floor == 10) total *= 0.95;
            if (isInsulated) total *= 1.05;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Exception in Panel.getTotalPrice", e);
        }
        int result = (int) total;
        logger.info("Panel.getTotalPrice result=" + result);
        return result;
    }

    /**
     * Include panel-specific details in the string representation.
     *
     * @return detailed string
     */
    @Override
    public String toString() {
        logger.info("Panel.toString called");
        return super.toString() + String.format(", Floor: %d, Insulated: %b", floor, isInsulated);
    }

    /**
     * Checks if two properties have the same total price.
     *
     * @param other other real estate to compare
     * @return true if total prices are equal
     */
    @Override
    public boolean hasSameAmount(RealEstate other) {
        logger.info("Panel.hasSameAmount called comparing to other");
        try {
            return this.getTotalPrice() == other.getTotalPrice();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Exception in hasSameAmount", e);
            return false;
        }
    }

    /**
     * Price per room for the panel (simple integer conversion).
     *
     * @return price per room as integer
     */
    @Override
    public int roomPrice() {
        logger.info("Panel.roomPrice called");
        try {
            return (int) (price * sqm / numberOfRooms);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Exception in roomPrice", e);
            return 0;
        }
    }
}
