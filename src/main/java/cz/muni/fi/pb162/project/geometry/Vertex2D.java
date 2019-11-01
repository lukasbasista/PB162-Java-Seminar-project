package cz.muni.fi.pb162.project.geometry;

/**
 * @author Lukáš Bašista
 */
public class Vertex2D {


    private double x;
    private double y;

    /**
     *
     * @param x double
     * @param y double
     */
    public Vertex2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
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

}
