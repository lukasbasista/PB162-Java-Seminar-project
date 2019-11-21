package cz.muni.fi.pb162.project.exception;

/**
 * @author Lukáš Bašista
 */
public class EmptyDrawableException extends Exception {

    /**
     *
     * @param message message
     */
    public EmptyDrawableException(String message) {
        super(message);
    }

    /**
     *
     * @param message message
     * @param cause cause
     */
    public EmptyDrawableException(String message, Throwable cause) {
        super(message, cause);
    }
}
