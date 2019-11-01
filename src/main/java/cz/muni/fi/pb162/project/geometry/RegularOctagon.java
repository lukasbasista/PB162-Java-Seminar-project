package cz.muni.fi.pb162.project.geometry;

/**
 * @author Lukáš Bašista
 */

public class RegularOctagon extends GeneralRegularPolygon {

    /**
     * @param center      Vertex(x, y)
     * @param edgesLength radius
     */
    public RegularOctagon(Vertex2D center, double edgesLength) {
        super(center, 8, edgesLength);
    }


}
