package com.tyr.pdfgenerator.exception;

public class PdfGeneratorFileException extends RuntimeException{

    private String message;

    public PdfGeneratorFileException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
