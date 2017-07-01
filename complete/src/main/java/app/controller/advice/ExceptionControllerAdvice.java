package app.controller.advice;

import app.exception.HttpException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(HttpException.class)
    public ResponseEntity conflictException(HttpException e) {
        return ResponseEntity
                .status (e.getHttpStatus ())
                .contentType (MediaType.APPLICATION_JSON)
                .eTag ("CONFLICT")
                .header (e.getMessage ())
                .varyBy (e.getMessage ())
                .build ();
    }
}
