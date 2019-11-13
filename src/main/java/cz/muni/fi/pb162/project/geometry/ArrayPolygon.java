package cz.muni.fi.pb162.project.geometry;

import java.util.Arrays;

/**
 * @author Lukáš Bašista
 */
public class ArrayPolygon extends SimplePolygon {
    private Vertex2D[] vertices;

    /**
     *
     * @param v array of vertices
     * @throws IllegalArgumentException if array is/contains null
     */
    public ArrayPolygon(Vertex2D[] v) throws IllegalArgumentException {
        if (v == null) {
            throw new IllegalArgumentException("Array of Vertex2D is null");
        }

        this.vertices = new Vertex2D[v.length];
        for (int i = 0; i < v.length; i++) {
            if (v[i] == null) {
                throw new IllegalArgumentException("Array contains null pointer");
            }
            this.vertices[i] = v[i];
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ArrayPolygon)) {
            return false;
        }
        if (!(getClass() == o.getClass())) {
            return false;
        }
        ArrayPolygon that = (ArrayPolygon) o;
        return Arrays.equals(vertices, that.vertices);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(vertices);
    }


    @Override
    public Vertex2D getVertex(int index) {
        if(index < 0) {
            throw new IllegalArgumentException("Invalid index number.");
        }
        return this.vertices[index % getNumVertices()];

    }

    @Override
    public int getNumVertices() {
        return this.vertices.length;
    }
}
