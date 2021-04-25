package com.tyr.pdfgenerator.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import javax.validation.ConstraintViolationException;


@ControllerAdvice
public class PdfServiceExceptionHandler {

    @ExceptionHandler(value = { IllegalArgumentException.class})
    protected ResponseEntity<Object> handleConflictDefaul(Exception ex, WebRequest request) {
        String bodyOfResponse = ex.getMessage();
        return new ResponseEntity<Object>(
                bodyOfResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = { PdfGeneratorFileException.class})
    protected ResponseEntity<Object> handleConflictMissingFile(
            RuntimeException ex, WebRequest request) {
        String bodyOfResponse = ex.getMessage();
        return new ResponseEntity<Object>(
                bodyOfResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = { Exception.class})
    protected ResponseEntity<Object> handleConflictDefaulException(
            RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "This should be application specific";
        return new ResponseEntity<Object>(
                "paso exception"+ ex.getMessage(), new HttpHeaders(), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(value = { ConstraintViolationException.class})
    protected ResponseEntity<Object> handleConflictBadRequest(
            RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "This should be application specific";
        return new ResponseEntity<Object>(
               "paso 2"+ ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }


}
