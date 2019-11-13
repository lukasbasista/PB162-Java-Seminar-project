package cz.muni.fi.pb162.project.geometry;

import java.util.Arrays;

/**
 * @author Lukáš Bašista
 */
public class Triangle extends ArrayPolygon implements Measurable {

    private final Triangle[] triangles = new Triangle[3];

    /**
     *
     * @param a coordinates of the vertex of the triangle [x, y]
     * @param b coordinates of the vertex of the triangle [x, y]
     * @param c coordinates of the vertex of the triangle [x, y]
     */
    public Triangle(Vertex2D a, Vertex2D b, Vertex2D c) {
        super(new Vertex2D[] {a, b, c});
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Triangle)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Triangle triangle = (Triangle) o;
        return Arrays.equals(triangles, triangle.triangles);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(triangles);
        return result;
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
        triangles[0] = new Triangle(getVertex(0), getVertex(0).createMiddle(getVertex(1)),
                getVertex(0).createMiddle(getVertex(2)));
        triangles[1] = new Triangle(getVertex(1), getVertex(1).createMiddle(getVertex(0)),
                getVertex(1).createMiddle(getVertex(2)));
        triangles[2] = new Triangle(getVertex(2), getVertex(2).createMiddle(getVertex(0)),
                getVertex(2).createMiddle(getVertex(1)));
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
        return "Triangle: vertices=" + this.getVertex(0) + " " + this.getVertex(1) + " " + this.getVertex(2);
    }
}
