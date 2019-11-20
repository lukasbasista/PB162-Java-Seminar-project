package cz.muni.fi.pb162.project.geometry;

/**
 * @author Lukáš Bašista
 */
public abstract class SimplePolygon implements Polygon {

    /**
     *
     * @param vertices Array of vertices
     */
    public SimplePolygon(Object[] vertices) {
        if (vertices == null) {
            throw new IllegalArgumentException("Null pointer instead of array.");
        }
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i] == null) {
                throw new IllegalArgumentException("Array contains null pointer.");
            }
        }

    }


    @Override
    public double getWidth() {
        double minX, maxX;

        minX = getVertex(0).getX();
        maxX = minX;

        for(int i = 1; i < getNumVertices(); i++){
            minX = Math.min(minX, getVertex(i).getX());
            maxX = Math.max(maxX, getVertex(i).getX());
        }

        return maxX - minX;
    }

    @Override
    public double getHeight() {
        double minY, maxY;

        minY = getVertex(0).getY();
        maxY = minY;

        for(int i = 1; i < getNumVertices(); i++){
            minY = Math.min(minY, getVertex(i).getY());
            maxY = Math.max(maxY, getVertex(i).getY());
        }

        return maxY - minY;
    }

    /**
     *
     * @return String
     */
    public String toString() {
        String ret =  new String("Polygon: vertices =");

        for(int i = 0; i < getNumVertices(); i++){
            ret += " ";
            ret += getVertex(i);
        }

        return ret;
    }

}
