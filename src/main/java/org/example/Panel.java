package org.example;

public class Panel extends RealEstate implements PanelInterface {
    private int floor;
    private boolean isInsulated;

    // Constructor
    public Panel(String city, double price, int sqm, double numberOfRooms, Genre genre, int floor, boolean isInsulated) {
        super(city, price, sqm, numberOfRooms, genre);
        this.floor = floor;
        this.isInsulated = isInsulated;
    }

    @Override
    public int getTotalPrice() {
        double total = super.getTotalPrice(); // base price with city modifier
        // floor modifier
        if (floor >= 0 && floor <= 2) total *= 1.05;
        if (floor == 10) total *= 0.95;
        // insulation modifier
        if (isInsulated) total *= 1.05;
        return (int) total;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Floor: %d, Insulated: %b", floor, isInsulated);
    }

    @Override
    public boolean hasSameAmount(RealEstate other) {
        return this.getTotalPrice() == other.getTotalPrice();
    }

    @Override
    public int roomPrice() {
        return (int) (price * sqm / numberOfRooms);
    }
}
