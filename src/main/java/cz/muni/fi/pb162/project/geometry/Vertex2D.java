package cz.muni.fi.pb162.project.geometry;

/**
 * @author Ema Liptakova
 */
public class Vertex2D {


    private double x;
    private double y;

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
     *
     * @return String
     */
    public String getInfo() {
        return "[" + this.x + ", " + this.y + "]";
    }

    /**
     *
     * @return sum of coordinates
     */
    public double sumCoordinates() {
        return x + y;
    }

    /**
     *
     * @param vertex (x, y)
     */
    public void move(Vertex2D vertex) {
        this.x += vertex.getX();
        this.y += vertex.getY();
    }

}
