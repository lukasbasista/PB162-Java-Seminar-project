package cz.muni.fi.pb162.project.geometry;

/**
 * @author Lukáš Bašista
 */
public class Circle implements Measurable, Circular {

    private final Vertex2D center;
    private final double radius;

    /**
     *
     * @param center set the center coordinates of the circle.
     * @param radius set radius of circle.
     */
    public Circle(Vertex2D center, double radius) {
        this.center = center;
        this.radius = radius;

    }

    /**
     *
     */
    public Circle() {
        this(new Vertex2D(0.0, 0.0), 1);
    }

    public Vertex2D getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

    /**
     *
     * @return center and radius of circle
     */
    public String toString() {
        return "Circle: center=" + getCenter() + ", radius=" + getRadius();
    }

    /**
     *
     * @return width of circle
     */
    @Override
    public double getWidth() {
        return 2 * radius;
    }

    /**
     *
     * @return height of circle
     */
    @Override
    public double getHeight() {
        return 2 * radius;
    }
}
