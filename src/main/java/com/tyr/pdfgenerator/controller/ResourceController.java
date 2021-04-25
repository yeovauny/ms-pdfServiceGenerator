package com.tyr.pdfgenerator.controller;

import com.tyr.pdfgenerator.domain.PdfRequest;
import com.tyr.pdfgenerator.exception.PdfFileException;
import com.tyr.pdfgenerator.exception.PdfGeneratorFileException;
import com.tyr.pdfgenerator.service.pdfGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("api")
public class ResourceController {

    @Autowired
    pdfGeneratorService pdfGeneratorService;

    @PostMapping(value="generatepdf" , produces = {"application/pdf"})
    public Object createPdfFile(@Valid @RequestBody PdfRequest pdfRequest) throws PdfGeneratorFileException, PdfFileException{
        ByteArrayResource arrayByte= null;

        arrayByte = pdfGeneratorService.pdfService(pdfRequest);

        String namedFile = addingFileName(pdfRequest);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + namedFile).contentType(MediaType.APPLICATION_PDF)
                .contentLength(arrayByte.contentLength()).body(arrayByte);
    }


    private String addingFileName(PdfRequest pdfRequest){
        StringBuilder pdfName=new StringBuilder();
        pdfName.append((pdfRequest.getName()!=null)? (!pdfRequest.getName().isBlank())? pdfRequest.getName():"response":"response");
        pdfName.append(".pdf");
        return pdfName.toString();
    }




}
