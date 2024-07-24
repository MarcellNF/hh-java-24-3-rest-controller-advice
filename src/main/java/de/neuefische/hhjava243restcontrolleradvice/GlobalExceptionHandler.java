package de.neuefische.hhjava243restcontrolleradvice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public CustomErrorMessage handleException(MethodArgumentTypeMismatchException e) {
        return new CustomErrorMessage(
                e.getMessage(),
                LocalDateTime.now(),
                "https://api.sampleapis.com/futurama",
                HttpStatus.NOT_FOUND.value()
        );
    }

    @ExceptionHandler(NoSuchCharacterException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public CustomErrorMessage handleException(NoSuchCharacterException e) {
        return new CustomErrorMessage(
                e.getMessage(),
                LocalDateTime.now(),
                "https://api.sampleapis.com/futurama",
                HttpStatus.NOT_FOUND.value()
        );
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public CustomErrorMessage handleException(Exception e) {
        return new CustomErrorMessage(
                e.getMessage(),
                LocalDateTime.now(),
                "https://api.sampleapis.com/futurama",
                HttpStatus.INTERNAL_SERVER_ERROR.value()
        );
    }

}
