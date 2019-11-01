package cz.muni.fi.pb162.project.utils;

import cz.muni.fi.pb162.project.geometry.Measurable;
import cz.muni.fi.pb162.project.geometry.Triangle;

/**
 * @author Lukáš Bašista
 */
public class Gauger {

    /**
     *
     * @param object any Measurable object
     */
    public static void printMeasurement (Measurable object) {
        System.out.println("Width: " + object.getWidth());
        System.out.println("Height: " + object.getHeight());
    }

    /**
     *
     * @param triangle Triangle values
     */
    public static void printMeasurement (Triangle triangle) {
        System.out.println(triangle);
        printMeasurement((Measurable)triangle);
    }
}
