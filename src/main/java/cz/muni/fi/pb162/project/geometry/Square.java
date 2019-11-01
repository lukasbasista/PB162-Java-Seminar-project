package cz.muni.fi.pb162.project.geometry;

/**
 * @author Lukáš Bašista
 */
public class Square extends GeneralRegularPolygon implements Circular {

    /**
     * @param center   center coordinates
     * @param diameter of Square
     */
    public Square(Vertex2D center, double diameter) {
        super(center, 4, diameter / 2);
    }


    /**
     * @param circular Center and radius
     */
    public Square(Circular circular) {
        super(circular.getCenter(), 4, circular.getRadius());

    }

    /**
     * @return the values ​​of the co-ordinates of all vertices
     */
    public String toString() {
        Vertex2D left = this.getVertex(0);
        Vertex2D bottom = this.getVertex(1);
        Vertex2D right = this.getVertex(2);
        Vertex2D top = this.getVertex(3);
        return "Square: vertices=" + left + " " + bottom + " " + right + " " + top;
    }
}
