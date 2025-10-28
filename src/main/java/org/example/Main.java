package org.example;

import java.util.logging.*;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        try {
            FileHandler fileHandler = new FileHandler("realEstateApp.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            Logger rootLogger = Logger.getLogger("");
            rootLogger.addHandler(fileHandler);
            rootLogger.setLevel(Level.INFO);

            logger.info("Application started.");

            RealEstate r1 = new RealEstate("Budapest", 250000, 100, 4, RealEstate.Genre.FLAT);
            Panel p1 = new Panel("Budapest", 180000, 70, 3, RealEstate.Genre.FLAT, 4, false);

            logger.info("Created RealEstate and Panel objects.");

            System.out.println(r1);
            System.out.println(p1);

            r1.makeDiscount(10);  // 10% discount
            logger.info("Applied discount on RealEstate.");

            System.out.println("After discount: " + r1);

            logger.info("Program finished successfully.");

        } catch (Exception e) {
            logger.log(Level.SEVERE, "An error occurred in Main.", e);
        }
    }
}
