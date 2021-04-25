package com.tyr.pdfgenerator.exception;

public class PdfFileException extends RuntimeException{

    String message;

    public  PdfFileException(String message){
        super(message);
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "PdfFileException{" +
                "message='" + message + '\'' +
                '}';
    }
}
