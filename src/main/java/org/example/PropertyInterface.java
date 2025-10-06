package org.example;

public interface PropertyInterface {
    void makeDiscount(int percentage);  // reduces price per square meter
    int getTotalPrice();                 // calculates total price
    double averageSqmPerRoom();          // average sqm per room
}
