package cz.muni.fi.pb162.project.geometry;

/**
 * @author Lukáš Bašista
 */
public enum Color { RED, GREEN, BLUE, WHITE, BLACK, YELLOW, ORANGE;

    /**
     *
     * @return name of color
     */
    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
