package kolmykov_shishkin_stepanov.exceptions;

import kolmykov_shishkin_stepanov.Window;

public class AddEdgeException extends Exception {
    public AddEdgeException() {

    }

    public AddEdgeException(String message) {
        super(message);
    }

    public AddEdgeException(String message, Throwable cause) {
        super(message, cause);
    }

    public AddEdgeException(Throwable cause) {
        super(cause);
    }

    public AddEdgeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
