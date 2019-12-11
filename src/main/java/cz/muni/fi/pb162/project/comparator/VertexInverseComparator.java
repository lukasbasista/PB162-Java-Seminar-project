package cz.muni.fi.pb162.project.comparator;

import cz.muni.fi.pb162.project.geometry.Vertex2D;

import java.util.Comparator;

/**
 * @author Lukáš Bašista
 */
public class VertexInverseComparator implements Comparator<Vertex2D> {
    @Override
    public int compare(Vertex2D o1, Vertex2D o2) {
        double diff = o2.getX() - o1.getX();

        if(diff != 0.0) {
            return ((int) Math.signum(diff));
        }else {
            diff = o2.getY() - o1.getY();
            return ((int) Math.signum(diff));
        }
    }
}

