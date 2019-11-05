package cz.muni.fi.pb162.project.geometry;

/**
 * @author Lukáš Bašista
 */

public class Snowman {

    private static final int NUM_OF_CIRCLES = 3;
    private static final double DEFAULT_FACTOR = 0.8;
    private RegularPolygon[] polygons;
    private double factor;

    /**
     * @param regularPolygon regularPolygon
     * @param factor         reduction factor
     */
    public Snowman(RegularPolygon regularPolygon, double factor) {
        if (factor <= 0 || factor >= 1) {
            factor = DEFAULT_FACTOR;
        }

        this.factor = factor;
        polygons = new RegularPolygon[NUM_OF_CIRCLES];
        polygons[0] = new GeneralRegularPolygon(regularPolygon.getCenter(), regularPolygon.getNumEdges(),
                regularPolygon.getRadius());
        for (int i = 1; i < NUM_OF_CIRCLES; i++) {
            polygons[i] = calculatePolygon(polygons[i - 1], this.factor);
        }
    }

    /**
     * @param previousPolygon values ​​of a larger polygon
     * @param factor          reduction factor
     * @return Values of polygon
     */
    private RegularPolygon calculatePolygon(RegularPolygon previousPolygon, double factor) {
        Vertex2D previousCenter = previousPolygon.getCenter();
        int numEdges = previousPolygon.getNumEdges();
        double previousRadius = previousPolygon.getRadius();
        double currenntRadius = previousRadius * factor;

        Vertex2D moveVertex = new Vertex2D(0, previousRadius + currenntRadius);
        double x = previousCenter.getX() + moveVertex.getX();
        double y = previousCenter.getY() + moveVertex.getY();
        Vertex2D currentCenter = new Vertex2D(x, y);

        RegularPolygon currentPolygon = new GeneralRegularPolygon(currentCenter, numEdges, currenntRadius);
        return currentPolygon;
    }

    /**
     * @return values of all circles
     */
    public RegularPolygon[] getBalls() {
        return polygons;
    }
}
