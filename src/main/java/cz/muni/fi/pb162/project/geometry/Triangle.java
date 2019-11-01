package cz.muni.fi.pb162.project.geometry;

/**
 * @author Lukáš Bašista
 */
public class Triangle {

    private Vertex2D[] vertices = new Vertex2D[3];
    private Triangle[] triangles = new Triangle[3];

    /**
     * @param a coordinates of the vertex of the triangle [x, y]
     * @param b coordinates of the vertex of the triangle [x, y]
     * @param c coordinates of the vertex of the triangle [x, y]
     */
    public Triangle(Vertex2D a, Vertex2D b, Vertex2D c) {
        this.vertices[0] = a;
        this.vertices[1] = b;
        this.vertices[2] = c;
    }

    /**
     * @param index Vertex index
     * @return null if index out of range
     *         vertex of the triangle
     */
    public Vertex2D getVertex(int index) {
        if (index < 0 || index > 2) {
            return null;
        }
        return vertices[index];
    }

    /**
     * Set the triangle vertex
     *
     * @param index  Vertex index <0, 2>
     * @param vertex (x, y)
     */
    void setVertex(int index, Vertex2D vertex) {
        if (index < 0 || index > 2) {
            return;
        }
        this.vertices[index] = vertex;
    }

    /**
     * Divide triangle to smaller triangles
     *
     * @return false if already is divided
     *         true after divide
     */
    public boolean divide() {
        if (isDivided()) {
            return false;
        }
        triangles[0] = new Triangle(getVertex(0), vertices[0].createMiddle(vertices[1]),
                vertices[0].createMiddle(vertices[2]));
        triangles[1] = new Triangle(getVertex(1), vertices[1].createMiddle(vertices[0]),
                vertices[1].createMiddle(vertices[2]));
        triangles[2] = new Triangle(getVertex(2), vertices[2].createMiddle(vertices[0]),
                vertices[2].createMiddle(vertices[1]));
        return true;

    }

    /**
     * @return true if triangle is divided
     * false if triangles are null
     */
    public boolean isDivided() {
        return triangles[0] != null && triangles[1] != null && triangles[2] != null;
    }

    /**
     * @param index Triangle index
     * @return null if index is out of range
     * Triangle's index-th subtriangle
     */
    public Triangle getSubTriangle(int index) {
        if (index < 0 || index > 2) {
            return null;
        }
        return triangles[index];
    }

    /**
     * @return message
     */
    @Override
    public String toString() {
        return "Triangle: vertices=" + vertices[0].toString() + " " +
                vertices[1].toString() + " " + vertices[2].toString();
    }
}
