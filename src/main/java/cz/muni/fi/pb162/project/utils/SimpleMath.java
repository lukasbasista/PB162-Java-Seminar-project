package cz.muni.fi.pb162.project.utils;

import cz.muni.fi.pb162.project.geometry.Polygon;
/**
 * @author Lukáš Bašista
 */
public class SimpleMath {

    /**
     *
     * @param polygon vertices of triangle
     * @return minimal X value
     */
    public static double minX(Polygon polygon) {
        double minimalX;
        minimalX = polygon.getVertex(0).getX();
        for (int i = 0; i < polygon.getNumVertices(); i++) {
            if (minimalX > polygon.getVertex(i).getX()) {
                minimalX = polygon.getVertex(i).getX();
            }
        }
        return minimalX;


    }

    /**
     *
     * @param polygon vertices of triangle
     * @return minimal Y value
     */
    public static double minY(Polygon polygon) {
        double minimalY;
        minimalY = polygon.getVertex(0).getY();
        for (int i = 0; i < polygon.getNumVertices(); i++) {
            if (minimalY > polygon.getVertex(i).getY()) {
                minimalY = polygon.getVertex(i).getY();
            }
        }
        return minimalY;


    }

    /**
     *
     * @param polygon vertices of triangle
     * @return maximal X value
     */
    public static double maxX(Polygon polygon) {
        double maximalX;
        maximalX = polygon.getVertex(0).getX();
        for (int i = 0; i < polygon.getNumVertices(); i++) {
            if (maximalX < polygon.getVertex(i).getX()) {
                maximalX = polygon.getVertex(i).getX();
            }
        }
        return maximalX;


    }

    /**
     *
     * @param polygon vertices of triangle
     * @return maximal Y value
     */
    public static double maxY(Polygon polygon) {
        double maximalY;
        maximalY = polygon.getVertex(0).getY();
        for (int i = 0; i < polygon.getNumVertices(); i++) {
            if (maximalY < polygon.getVertex(i).getY()) {
                maximalY = polygon.getVertex(i).getY();
            }
        }
        return maximalY;


    }
}
