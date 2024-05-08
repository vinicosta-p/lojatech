package com.pecastech.app.infra;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.HandlerMethodValidationException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.pecastech.app.exceptions.ProductNotFoundException;

import org.springframework.web.bind.MethodArgumentNotValidException;


@RestControllerAdvice
public class GlobalExpectionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleNoResourceFoundException(NoResourceFoundException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionDto(HttpStatus.BAD_REQUEST, ex.getMessage()));
    }
    
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionDto(HttpStatus.BAD_REQUEST, ex.getMessage()));
    }
    
    @Override
    protected ResponseEntity<Object> handleHandlerMethodValidationException(HandlerMethodValidationException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionDto(HttpStatus.BAD_REQUEST, ex.getMessage()));
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDto> handleGenericErrors(Exception ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(new ExceptionDto(HttpStatus.INTERNAL_SERVER_ERROR, "An error has occurred"));
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleNotFound(Exception ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(new ExceptionDto(HttpStatus.NOT_FOUND, ex.getMessage()));
    }
    

}
