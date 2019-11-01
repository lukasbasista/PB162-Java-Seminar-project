package cz.muni.fi.pb162.project.geometry;

/**
 * @author Lukáš Bašista
 */
public class Circle extends GeneralRegularPolygon implements Measurable, Circular {

    /**
     * Circle with center in (0, 0) and radius 1
     */
    public Circle() {
        this(new Vertex2D(0.0, 0.0), 1);
    }

    /**
     * @param center set the center coordinates of the circle.
     * @param radius set radius of circle.
     */
    public Circle(Vertex2D center, double radius) {
        super(center, Integer.MAX_VALUE, radius);
        this.setColor(Color.RED);
    }

    @Override
    public double getEdgeLength() {
        return 0;
    }

    /**
     * @return center and radius of circle
     */
    public String toString() {
        return "Circle: center=" + getCenter() + ", radius=" + getRadius();
    }

}
