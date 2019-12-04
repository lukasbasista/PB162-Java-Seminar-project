package cz.muni.fi.pb162.project.exception;

/**
 * @author Lukáš Bašista
 */
public class MissingVerticesException extends RuntimeException {

    /**
     *
     * @param message message
     */
    public MissingVerticesException(String message) {
        super(message);
    }

    /**
     *
     * @param message message
     * @param cause cause
     */
    public MissingVerticesException(String message, Throwable cause) {
        super(message, cause);
    }
}
