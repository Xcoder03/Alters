package com.springclass.student.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class CustomizedExceptionHandling  extends ResponseEntityExceptionHandler implements CustomizedExceptionHandling1 {
    @Override
    public ResponseEntity<Object> handleMethodArguementNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request){
        System.out.println("Validation failed");
        return   super.handleMethodArgumentNotValid(ex, headers,status,request);
    }

}
