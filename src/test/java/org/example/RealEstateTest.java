package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RealEstateTest {

    @Test
    void testTotalPriceForBudapest() {
        RealEstate re = new RealEstate("Budapest", 1000, 50, 2, RealEstate.Genre.FLAT);
        int expected = (int) (1000 * 50 * 1.3);
        assertEquals(expected, re.getTotalPrice());
    }

    @Test
    void testTotalPriceForNyiregyhaza() {
        RealEstate re = new RealEstate("Nyíregyháza", 800, 40, 1, RealEstate.Genre.FAMILYHOUSE);
        int expected = (int) (800 * 40 * 1.15);
        assertEquals(expected, re.getTotalPrice());
    }

    @Test
    void testAverageSqmPerRoom() {
        RealEstate re = new RealEstate("Debrecen", 900, 60, 3, RealEstate.Genre.CONDOMINIUM);
        assertEquals(20.0, re.averageSqmPerRoom());
    }

    @Test
    void testMakeDiscount() {
        RealEstate re = new RealEstate("Budapest", 1000, 50, 2, RealEstate.Genre.FLAT);
        re.makeDiscount(10);
        assertEquals(900, re.price); // price should decrease by 10%
    }
}
