package cz.muni.fi.pb162.project.exception;

/**
 * @author Lukáš Bašista
 */
public class TransparentColorException extends Exception {

    /**
     *
     * @param message message
     */
    public TransparentColorException(String message) {
        super(message);
    }

    /**
     *
     * @param message message
     * @param cause cause
     */
    public TransparentColorException(String message, Throwable cause) {
        super(message, cause);
    }
}
