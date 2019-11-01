package cz.muni.fi.pb162.project.geometry;

/**
 * @author Lukáš Bašista
 */
public class Vertex2D {

    private final double x;
    private final double y;

    /**
     * @param x double
     * @param y double
     */
    public Vertex2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @param vertex second vertex coordinates (x, ,y)
     * @return distance between 2 vertices
     */
    public double distance(Vertex2D vertex) {
        if (vertex == null) {
            return -1.0;
        }
        return Math.sqrt(Math.pow(vertex.x - this.x, 2) + Math.pow(vertex.y - this.y, 2));
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    /**
     * @return String "[x, y]"
     */
    @Override
    public String toString() {
        return "[" + this.x + ", " + this.y + "]";
    }

    /**
     * @param otherVertex vertices of second vertex
     * @return Vertex2D
     */
    public Vertex2D createMiddle(Vertex2D otherVertex) {
        return new Vertex2D((this.x + otherVertex.x) / 2, (this.y + otherVertex.y) / 2);
    }

    /**
     * @return sum of coordinates
     */
    public double sumCoordinates() {
        return x + y;
    }


}
