package com.tyr.pdfgenerator.service;

import com.tyr.pdfgenerator.domain.PdfRequest;
import com.tyr.pdfgenerator.exception.PdfFileException;
import org.springframework.core.io.ByteArrayResource;

public interface pdfGeneratorService {

    public ByteArrayResource pdfService(PdfRequest request) throws PdfFileException;
}
