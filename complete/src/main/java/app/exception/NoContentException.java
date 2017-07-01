package app.exception;


import org.springframework.http.HttpStatus;

public class NoContentException extends HttpException {

    static {
        httpStatus = HttpStatus.CONFLICT;
    }

    public NoContentException() {
        super ();
    }

    public NoContentException(String message) {
        super (message);
    }

    public NoContentException(String message, Throwable cause) {
        super (message, cause);
    }

    public NoContentException(Throwable cause) {
        super (cause);
    }
}
