package app.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by Adam on 2017-06-30.
 */
public class ConflictException extends HttpException {

    static {
        httpStatus = HttpStatus.CONFLICT;
    }

    public ConflictException() {
        super ();
    }

    public ConflictException(String message) {
        super (message);
    }

    public ConflictException(String message, Throwable cause) {
        super (message, cause);
    }

    public ConflictException(Throwable cause) {
        super (cause);
    }
}
