package cz.muni.fi.pb162.project.geometry;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Lukáš Bašista
 */
public class Paper implements Drawable {
    private Set<ColoredPolygon> polygons;
    private Color currentColor;

    /**
     * Constructor
     */
    public Paper() {
        this.currentColor = Color.BLACK;
        this.polygons = new HashSet<>();

    }

    /**
     * Constructor
     *
     * @param drawable drawable
     */
    public Paper(Drawable drawable) {
        this.polygons = new HashSet<>(drawable.getAllDrawnPolygons());

    }

    @Override
    public void changeColor(Color color) {
        this.currentColor = color;
    }

    @Override
    public void drawPolygon(Polygon polygon) {
        if (this.currentColor == Color.WHITE) {
            return;
        }
        ColoredPolygon coloredPolygon = new ColoredPolygon(polygon, this.currentColor);
        polygons.add(coloredPolygon);
    }

    @Override
    public void erasePolygon(ColoredPolygon polygon) {
        polygons.remove(polygon);
    }

    @Override
    public void eraseAll() {
        this.polygons.clear();

    }

    @Override
    public Collection<ColoredPolygon> getAllDrawnPolygons() {
        return Collections.unmodifiableSet(this.polygons);
    }

    @Override
    public int uniqueVerticesAmount() {
        Set<Vertex2D> verticesAmount = new LinkedHashSet<>();
        for (ColoredPolygon coloredPolygon : polygons) {
            for (int i = 0; i < coloredPolygon.getPolygon().getNumVertices(); i++) {
                verticesAmount.add(coloredPolygon.getPolygon().getVertex(i));
            }
        }
        return verticesAmount.size();
    }

}
