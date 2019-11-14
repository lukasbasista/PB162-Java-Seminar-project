package cz.muni.fi.pb162.project.geometry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author Lukáš Bašista
 */
public class CollectionPolygon extends SimplePolygon {
    private List<Vertex2D> vertices;

    /**
     * First constructor
     *
     * @param vertices Array of Vertex2D
     */
    public CollectionPolygon(Vertex2D[] vertices) {
        super(vertices);
        this.vertices = new ArrayList<>(Arrays.asList(vertices));
    }

    /**
     * Second constructor
     *
     * @param vertices List of Vertex2D
     */
    public CollectionPolygon(List<Vertex2D> vertices) {
        super(vertices.toArray());
        this.vertices = new ArrayList<>(vertices);
    }

    /**
     * withoutLeftmostVertices
     *
     * @return Collyctionpolygon without left most vertices
     * @throws IllegalArgumentException if vertices is empty
     */
    public CollectionPolygon withoutLeftmostVertices() throws IllegalArgumentException {
        if (vertices.isEmpty()) {
            throw new IllegalArgumentException("empty");
        }
        List<Vertex2D> tempList = new ArrayList<>();
        double tempX = 0;
        if (vertices.size() > 0) {
            tempX = vertices.get(0).getX();
        }
        for (Vertex2D vertex : vertices) {
            if (vertex.getX() < tempX) {
                tempX = vertex.getX();
            }
        }
        for (Vertex2D vertex : vertices) {
            if (vertex.getX() != tempX) {
                tempList.add(vertex);
            }
        }
        return new CollectionPolygon(tempList);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CollectionPolygon that = (CollectionPolygon) o;
        return Objects.equals(vertices, that.vertices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vertices);
    }

    @Override
    public Vertex2D getVertex(int index) throws IllegalArgumentException {
        if (index < 0) {
            throw new IllegalArgumentException("index");
        }
        return vertices.get(index % vertices.size());
    }

    @Override
    public int getNumVertices() {
        return vertices.size();
    }

}
