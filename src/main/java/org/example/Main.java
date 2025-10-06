package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        RealEstate r1 = new RealEstate("Budapest", 250000, 100, 4, RealEstate.Genre.FLAT);
        Panel p1 = new Panel("Budapest", 180000, 70, 3, RealEstate.Genre.FLAT, 4, false);

        System.out.println(r1);
        System.out.println(p1);

        r1.makeDiscount(10);  // 10% discount
        System.out.println("After discount: " + r1);
    }
}