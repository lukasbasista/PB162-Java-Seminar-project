package cz.muni.fi.pb162.project.geometry;

import cz.muni.fi.pb162.project.utils.SimpleMath;

/**
 * @author Lukáš Bašista
 */
public class Triangle implements Measurable {

    private final Vertex2D[] vertices = new Vertex2D[3];
    private final Triangle[] triangles = new Triangle[3];

    /**
     *
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
     *
     * @param a the coordinates of the triangle vertex
     * @param b the coordinates of the triangle vertex
     * @param c the coordinates of the triangle vertex
     * @param j depth of triangle division
     */
    public Triangle(Vertex2D a, Vertex2D b, Vertex2D c, int j) {
        this(a, b, c);
        divide(j);
    }

    /**
     *
     * @param index index of the vertex of the triangle
     * @return vertex of the triangle
     */
    public Vertex2D getVertex(int index) {
        if (index > 2 || index < 0) {
            return null;
        }
        return vertices[index];

    }
    /**
     *
     * @param index index of the triangle <0,2>
     * @return vertex of the triangle
     */
    public  Triangle getSubTriangle(int index) {
        if (index > 2 || index < 0) {
            return null;
        }
        return triangles[index];
    }



    /**
     *
     * @return <code>false</code> if it is divided
     *         <code>true</code> after divide
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
     *
     * @param depth set depth of triangle division
     * @return <code>false</code> if it is divided
     *         <code>true</code> after divide
     */
    public boolean divide(int depth) {
        if (depth < 1) {
            return false;
        }

        this.divide();

        triangles[0].divide(depth - 1);
        triangles[1].divide(depth - 1);
        triangles[2].divide(depth - 1);

        return true;

    }

    /**
     *
     * @return <code>true</code> if triangle was divided
     */
    public boolean isDivided() {
        return triangles[0] != null && triangles[1] != null && triangles[2] != null;
    }

    /**
     *
     * @return true if the triangle is equilateral
     */
    public boolean isEquilateral() {
        double s1 = this.getVertex(0).distance(this.getVertex(1));
        double s2 = this.getVertex(0).distance(this.getVertex(2));
        double s3 = this.getVertex(1).distance(this.getVertex(2));

        return ((Math.abs(s1-s2) < 0.001) && (Math.abs(s1-s3) < 0.001) && (Math.abs(s2-s3) < 0.001));
    }

    /**
     *
     * @return String
     */
    public String toString() {
        return "Triangle: vertices=" + vertices[0] + " " + vertices[1] + " " + vertices[2];
    }

    /**
     *
     * @return max width of triangle
     */
    @Override
    public double getWidth() {
        return SimpleMath.maxX(this) - SimpleMath.minX(this);
    }

    /**
     * max height of triangle
     * @return
     */
    @Override
    public double getHeight() {
        return SimpleMath.maxY(this) - SimpleMath.minY(this);
    }
}
