package cz.muni.fi.pb162.project.geometry;

import cz.muni.fi.pb162.project.exception.EmptyDrawableException;
import cz.muni.fi.pb162.project.exception.MissingVerticesException;
import cz.muni.fi.pb162.project.exception.TransparentColorException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Lukáš Bašista
 */
public class Paper implements Drawable, PolygonFactory {
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
    public void drawPolygon(Polygon polygon) throws TransparentColorException {
        if (this.currentColor == Color.WHITE) {
            throw new TransparentColorException("Transparent color" + this.currentColor);
        }
        ColoredPolygon coloredPolygon = new ColoredPolygon(polygon, this.currentColor);
        polygons.add(coloredPolygon);
    }

    @Override
    public void erasePolygon(ColoredPolygon polygon) {
        polygons.remove(polygon);
    }

    @Override
    public void eraseAll() throws EmptyDrawableException {
        if (this.polygons.isEmpty()) {
            throw new EmptyDrawableException("Empty polygons");
        }
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

    @Override
    public Polygon tryToCreatePolygon(List<Vertex2D> vertices) {
        if (vertices.isEmpty()) {
            throw new NullPointerException();
        }
        List<Vertex2D> copyVertices = new ArrayList<>(vertices);
        try {
            new CollectionPolygon(copyVertices);

        } catch (IllegalArgumentException e) {
            copyVertices.removeAll(Collections.singleton(null));
        }
        Polygon test = new CollectionPolygon(copyVertices);
        return test;
    }

    @Override
    public void tryToDrawPolygons(List<List<Vertex2D>> collectionPolygons) throws EmptyDrawableException {
        Exception exception = null;
        Boolean isEmpty = true;
        for (List<Vertex2D> list : collectionPolygons) {
            try {
                Polygon polygon = tryToCreatePolygon(list);
                try {
                    drawPolygon(polygon);
                } catch (TransparentColorException e) {
                    changeColor(Color.BLACK);
                }
            } catch (MissingVerticesException | NullPointerException e) {
                exception = e;
                continue;
            }
            isEmpty = false;

        }
        if (isEmpty) {
            throw new EmptyDrawableException("Empty polygon", exception);
        }
    }


    /**
     *
     * @param color color
     * @return polygons with color color
     */
    public Collection<Polygon> getPolygonsWithColor(Color color) {
        Collection<Polygon> nePolygon = polygons.stream()
                .filter(s -> s.getColor() == color)
                .map(s -> s.getPolygon())
                .collect(Collectors.toList());
        return nePolygon;
    }


}
