package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PanelTest {

    @Test
    public void testTotalPriceWithFloorAndInsulation() {
        Panel panel1 = new Panel("Budapest", 1000, 50, 2, RealEstate.Genre.FLAT, 2, true);
        // base = 1000*50=50000, Budapest multiplier 1.3 => 65000
        // floor (0-2) => 65000*1.05=68250
        // insulation => 68250*1.05=71662.5
        int expected = (int) Math.round(50000 * 1.3 * 1.05 * 1.05);
        assertEquals(expected, panel1.getTotalPrice());
    }

    @Test
    public void testTotalPriceTopFloorNoInsulation() {
        Panel panel2 = new Panel("Debrecen", 800, 40, 2, RealEstate.Genre.FLAT, 10, false);
        // base = 800*40=32000, Debrecen multiplier 1.2 => 38400
        // top floor => 38400*0.95=36480
        int expected = (int) Math.round(32000 * 1.2 * 0.95);
        assertEquals(expected, panel2.getTotalPrice());
    }

    @Test
    public void testHasSameAmountFalse() {
        // Panel has floor=0 → floor modifier applies (1.05), RealEstate has no modifiers
        Panel panel1 = new Panel("Debrecen", 800, 40, 2, RealEstate.Genre.FLAT, 0, false);
        RealEstate re = new RealEstate("Debrecen", 800, 40, 2, RealEstate.Genre.FLAT);
        assertFalse(panel1.hasSameAmount(re));
    }

    @Test
    public void testHasSameAmountTrue() {
        // Panel with floor that does NOT trigger modifier, insulation=false → totals equal
        Panel panel2 = new Panel("Debrecen", 800, 40, 2, RealEstate.Genre.FLAT, 5, false);
        RealEstate re = new RealEstate("Debrecen", 800, 40, 2, RealEstate.Genre.FLAT);
        assertTrue(panel2.hasSameAmount(re));
    }

    @Test
    public void testRoomPriceCalculation() {
        Panel panel3 = new Panel("Budapest", 1000, 60, 3, RealEstate.Genre.CONDOMINIUM, 2, true);
        int expected = (int) (1000 * 60 / 3); // roomPrice uses base price, not totalPrice
        assertEquals(expected, panel3.roomPrice());
    }

    @Test
    public void testToStringContainsInfo() {
        Panel panel4 = new Panel("Budapest", 1200, 80, 4, RealEstate.Genre.FLAT, 3, false);
        String result = panel4.toString();
        assertTrue(result.contains("City: Budapest")); // check your RealEstate.toString() outputs this exactly
        assertTrue(result.contains("Floor: 3"));
        assertTrue(result.contains("Insulated: false"));
    }
}
