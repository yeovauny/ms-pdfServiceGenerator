package com.tyr.pdfgenerator.mapper;

import com.tyr.pdfgenerator.domain.PdfRequest;
import com.tyr.pdfgenerator.exception.PdfFileException;


public interface MapperValuePdf {

     void mapperValidator(PdfRequest mapaGenerico) throws PdfFileException;
}
