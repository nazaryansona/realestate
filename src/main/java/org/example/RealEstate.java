package org.example;

public class RealEstate implements PropertyInterface {
    protected String city;
    protected double price;      // price per sqm
    protected int sqm;
    protected double numberOfRooms;
    protected Genre genre;

    // Enum for property type
    public enum Genre {
        FAMILYHOUSE, CONDOMINIUM, FARM, FLAT
    }

    // Constructor
    public RealEstate(String city, double price, int sqm, double numberOfRooms, Genre genre) {
        this.city = city;
        this.price = price;
        this.sqm = sqm;
        this.numberOfRooms = numberOfRooms;
        this.genre = genre;
    }

    @Override
    public void makeDiscount(int percentage) {
        price = price * (1 - percentage / 100.0);
    }

    @Override
    public int getTotalPrice() {
        double total = price * sqm;
        // city modifiers
        switch(city) {
            case "Budapest": total *= 1.3; break;
            case "Debrecen": total *= 1.2; break;
            case "Nyíregyháza": total *= 1.15; break;
        }
        return (int) total;
    }

    @Override
    public double averageSqmPerRoom() {
        return sqm / numberOfRooms;
    }

    @Override
    public String toString() {
        return String.format(
                "City: %s, Price/sqm: %.2f, Sqm: %d, Rooms: %.1f, Genre: %s, Total Price: %d, Avg Sqm/Room: %.2f",
                city, price, sqm, numberOfRooms, genre, getTotalPrice(), averageSqmPerRoom()
        );
    }
}
