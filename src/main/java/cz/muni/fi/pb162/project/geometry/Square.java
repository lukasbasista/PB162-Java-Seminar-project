package cz.muni.fi.pb162.project.geometry;

/**
 * @author Lukáš Bašista
 */
public class Square implements Circular {

    private Vertex2D center;
    private double diameter;
    private Circular circular;

    /**
     *
     * @param center center coordinates
     * @param diameter of Square
     */
    public Square(Vertex2D center, double diameter) {
        this.center = center;
        this.diameter = diameter;
    }

    /**
     *
     * @param circular Center and radius
     */
    public Square(Circular circular) {
        this.center = circular.getCenter();
        this.diameter = circular.getRadius()*2;

    }

    /**
     *
     * @param index 0 - left corner
     *              1 - bottom corner
     *              2 - right corner
     *              3 - top corner
     * @return coordinates of corner
     */
    public Vertex2D getVertex(int index) {
        switch (index) {
            case 0: return new Vertex2D(this.getCenter().getX() - this.getRadius(), this.getCenter().getY());

            case 1: return new Vertex2D(this.getCenter().getX(), this.getCenter().getY() - this.getRadius());

            case 2: return new Vertex2D(this.getCenter().getX() + this.getRadius(), this.getCenter().getY());

            case 3: return new Vertex2D(this.getCenter().getX(), this.getCenter().getY() + this.getRadius());

            default: return null;
        }
    }

    /**
     *
     * @return coordinates of center
     */
    @Override
    public Vertex2D getCenter() {
        return this.center;
    }

    /**
     *
     * @return radius
     */
    @Override
    public double getRadius() {
        return this.diameter/2;
    }

    /**
     *
     * @return the values ​​of the co-ordinates of all vertices
     */
    public String toString() {
        Vertex2D left = this.getVertex(0);
        Vertex2D bottom = this.getVertex(1);
        Vertex2D right = this.getVertex(2);
        Vertex2D top = this.getVertex(3);
        return "Square: vertices=" + left + " " + bottom + " " +  right + " " +  top;
    }
}
