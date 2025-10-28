package org.example;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Basic RealEstate class representing a property with city, price per sqm, area and rooms.
 */
public class RealEstate implements PropertyInterface {
    private static final Logger logger = Logger.getLogger(RealEstate.class.getName());
    static { LoggerConfig.configureLogger(logger); }

    protected String city;
    protected double price;      // price per sqm
    protected int sqm;
    protected double numberOfRooms;
    protected Genre genre;

    /**
     * Enum for property type
     */
    public enum Genre {
        FAMILYHOUSE, CONDOMINIUM, FARM, FLAT
    }

    /**
     * Constructor for RealEstate objects.
     *
     * @param city          city name
     * @param price         price per square meter
     * @param sqm           total square meters
     * @param numberOfRooms number of rooms
     * @param genre         type of the property
     */
    public RealEstate(String city, double price, int sqm, double numberOfRooms, Genre genre) {
        logger.info("Creating RealEstate: city=" + city + ", price=" + price + ", sqm=" + sqm + ", rooms=" + numberOfRooms + ", genre=" + genre);
        this.city = city;
        this.price = price;
        this.sqm = sqm;
        this.numberOfRooms = numberOfRooms;
        this.genre = genre;
    }

    /**
     * Apply a percentage discount to the price per sqm.
     *
     * @param percentage discount percent (e.g., 10 means 10%)
     */
    @Override
    public void makeDiscount(int percentage) {
        logger.info("makeDiscount called with percentage=" + percentage);
        try {
            price = price * (1 - percentage / 100.0);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Exception in makeDiscount", e);
        }
    }

    /**
     * Calculate the total price of the property, applying city-specific modifiers.
     *
     * @return total price as integer
     */
    @Override
    public int getTotalPrice() {
        logger.info("getTotalPrice called for city=" + city);
        double total = price * sqm;
        try {
            switch (city) {
                case "Budapest":
                    total *= 1.3;
                    break;
                case "Debrecen":
                    total *= 1.2;
                    break;
                case "Nyíregyháza":
                    total *= 1.15;
                    break;
                default:
                    // no modifier
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Exception calculating total price", e);
        }
        int result = (int) total;
        logger.info("getTotalPrice result=" + result);
        return result;
    }

    /**
     * Calculate average square meters per room.
     *
     * @return average sqm per room
     */
    @Override
    public double averageSqmPerRoom() {
        logger.info("averageSqmPerRoom called");
        try {
            return sqm / numberOfRooms;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Exception calculating average sqm per room", e);
            return 0;
        }
    }

    /**
     * Provide a readable string representation of the property.
     *
     * @return formatted string with property details
     */
    @Override
    public String toString() {
        logger.info("toString called");
        return String.format(
                "City: %s, Price/sqm: %.2f, Sqm: %d, Rooms: %.1f, Genre: %s, Total Price: %d, Avg Sqm/Room: %.2f",
                city, price, sqm, numberOfRooms, genre, getTotalPrice(), averageSqmPerRoom()
        );
    }
}
