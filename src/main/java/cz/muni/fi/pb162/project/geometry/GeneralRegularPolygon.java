package cz.muni.fi.pb162.project.geometry;

/**
 * @author Lukáš Bašista
 */

public class GeneralRegularPolygon implements RegularPolygon, Colored {

    private Vertex2D center;
    private int numEdges;
    private Color color;
    private double radius;

    /**
     * @param center   Vertex(x, y)
     * @param numEdges numbers of edges
     * @param radius   int
     */
    public GeneralRegularPolygon(Vertex2D center, int numEdges, double radius) {
        this.center = center;
        this.numEdges = numEdges;
        this.radius = radius;
        this.color = Color.BLACK;
    }

    @Override
    public Color setColor(Color color) {
        this.color = color;
        return null;
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public int getNumEdges() {
        return this.numEdges;
    }

    @Override
    public double getEdgeLength() {
        return 2 * radius * Math.sin(Math.PI / numEdges);
    }

    @Override
    public Vertex2D getVertex(int index) {
        double posX = center.getX() - radius * Math.cos(index * 2 * Math.PI / numEdges);
        double posY = center.getY() - radius * Math.sin(index * 2 * Math.PI / numEdges);
        return new Vertex2D(posX, posY);
    }

    @Override
    public Vertex2D getCenter() {
        return this.center;
    }

    @Override
    public double getRadius() {
        return radius;
    }

    @Override
    public double getWidth() {
        return radius * 2;
    }

    @Override
    public double getHeight() {
        return radius * 2;
    }

    /**
     * @return String
     */
    public String toString() {
        return this.numEdges + "-gon: center=" + center + ", radius=" + radius + ", color=" + this.getColor();
    }
}
