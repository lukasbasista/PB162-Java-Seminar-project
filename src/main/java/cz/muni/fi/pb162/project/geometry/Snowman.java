package cz.muni.fi.pb162.project.geometry;

/**
 * @author Lukáš Bašista
 */

public class Snowman {

    public static final int NUM_OF_CIRCLES = 4;
    public static final double DEFAULT_FACTOR = 0.8;
    private Circular[] circles;
    private double factor;

    /**
     *
     * @param circular Center and radius
     * @param factor reduction factor
     */
    public Snowman(Circular circular, double factor) {
        if (factor <= 0 || factor >= 1) {
            factor = DEFAULT_FACTOR;
        }

        this.factor = factor;
        circles = new Circular[NUM_OF_CIRCLES];
        circles[0] = circular;
        for (int i = 1; i < NUM_OF_CIRCLES; i++) {
            circles[i] = calculateCircle(circles[i - 1], this.factor);
        }
    }

    /**
     *
     * @param previousCircle values ​​of a larger circle
     * @param factor reduction factor
     * @return Values of circle
     */
    private Circular calculateCircle(Circular previousCircle, double factor) {
        Vertex2D previousCenter = previousCircle.getCenter();
        double previousRadius = previousCircle.getRadius();
        double currenntRadius = previousRadius * factor;

        Vertex2D moveVertex = new Vertex2D(0 ,previousRadius + currenntRadius);
        double x = previousCenter.getX() + moveVertex.getX();
        double y = previousCenter.getY() + moveVertex.getY();
        Vertex2D currentCenter = new Vertex2D(x, y);

        Circular currentCircle = new Circle(currentCenter, currenntRadius);
        return currentCircle;
    }

    /**
     *
     * @return values of all circles
     */
    public Circular[] getBalls() {
        return circles;
    }
}
