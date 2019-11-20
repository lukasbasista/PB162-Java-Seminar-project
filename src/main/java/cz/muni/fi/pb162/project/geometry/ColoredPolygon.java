package cz.muni.fi.pb162.project.geometry;

import java.util.Objects;

/**
 * @author Lukáš Bašista
 */
public class ColoredPolygon {
    private Polygon polygon;
    private Color color;

    /**
     * Constructor
     *
     * @param polygon Polygon
     * @param color   Color
     */
    public ColoredPolygon(Polygon polygon, Color color) {
        this.polygon = polygon;
        this.color = color;
    }

    public Polygon getPolygon() {
        return polygon;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ColoredPolygon that = (ColoredPolygon) o;
        return Objects.equals(polygon, that.polygon) &&
                color == that.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(polygon, color);
    }


}
