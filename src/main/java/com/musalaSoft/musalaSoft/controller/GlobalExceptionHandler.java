package com.musalaSoft.musalaSoft.controller;

import java.time.LocalDate;
import java.util.Date;

import com.musalaSoft.musalaSoft.entity.ErrorDetail;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> resourceNotFoundException(RuntimeException ex, WebRequest request) {
        ErrorDetail errorDetails = new ErrorDetail(ex.getMessage(), request.getDescription(false), LocalDate.now());
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
        ErrorDetail errorDetails = new ErrorDetail(ex.getMessage(), request.getDescription(false), LocalDate.now());
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}