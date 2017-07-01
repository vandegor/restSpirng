package app.exception;


import org.springframework.http.HttpStatus;

public class HttpException extends Exception {


    protected static HttpStatus httpStatus;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    protected HttpException() {
        super ();
    }

    protected HttpException(String message) {
        super (message);
    }

    protected HttpException(String message, Throwable cause) {
        super (message, cause);
    }

    protected HttpException(Throwable cause) {
        super (cause);
    }
}
