package cz.muni.fi.pb162.project.utils;

import cz.muni.fi.pb162.project.geometry.Triangle;
/**
 * @author Lukáš Bašista
 */
public class SimpleMath {

    /**
     *
     * @param triangle vertices of triangle
     * @return minimal X value
     */
    public static double minX(Triangle triangle) {
        double x1 = triangle.getVertex(0).getX();
        double x2 = triangle.getVertex(1).getX();
        double x3 = triangle.getVertex(2).getX();
        return Math.min(x1, Math.min(x2, x3));

    }

    /**
     *
     * @param triangle vertices of triangle
     * @return minimal Y value
     */
    public static double minY(Triangle triangle) {
        double x1 = triangle.getVertex(0).getY();
        double x2 = triangle.getVertex(1).getY();
        double x3 = triangle.getVertex(2).getY();
        return Math.min(x1, Math.min(x2, x3));

    }

    /**
     *
     * @param triangle vertices of triangle
     * @return maximal X value
     */
    public static double maxX(Triangle triangle) {
        double x1 = triangle.getVertex(0).getX();
        double x2 = triangle.getVertex(1).getX();
        double x3 = triangle.getVertex(2).getX();
        return Math.max(x1, Math.max(x2, x3));

    }

    /**
     *
     * @param triangle vertices of triangle
     * @return maximal Y value
     */
    public static double maxY(Triangle triangle) {
        double x1 = triangle.getVertex(0).getY();
        double x2 = triangle.getVertex(1).getY();
        double x3 = triangle.getVertex(2).getY();
        return Math.max(x1, Math.max(x2, x3));

    }
}
