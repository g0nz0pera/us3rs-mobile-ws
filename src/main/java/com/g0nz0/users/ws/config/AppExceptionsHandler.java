package com.g0nz0.users.ws.config;

import com.g0nz0.users.ws.config.exceptions.UserServiceException;
import org.apache.coyote.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class AppExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest webRequest){

        ErrorMessage errorMessage = new ErrorMessage(new Date(), ex.getLocalizedMessage() != null ? ex.toString() : ex.getLocalizedMessage()) ;

        return new ResponseEntity<>(
                errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler(value = {NullPointerException.class, UserServiceException.class})
    public ResponseEntity<Object> handleExceptions(Exception ex, WebRequest webRequest){

        ErrorMessage errorMessage = new ErrorMessage(new Date(), ex.getLocalizedMessage() != null ? ex.toString() : ex.getLocalizedMessage()) ;

        return new ResponseEntity<>(
                errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

}
