package com.tyr.pdfgenerator.service.impl;


import com.lowagie.text.DocumentException;
import com.tyr.pdfgenerator.domain.PdfRequest;
import com.tyr.pdfgenerator.exception.PdfFileException;
import com.tyr.pdfgenerator.exception.PdfGeneratorFileException;
import com.tyr.pdfgenerator.mapper.MapperValuePdf;
import com.tyr.pdfgenerator.service.pdfGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;
import java.io.*;


@Service
public class pdfGeneratorServiceImpl implements pdfGeneratorService {

    @Autowired
    TemplateEngine templateEngine;

    @Autowired
    MapperValuePdf requestrequest;


    @Override
    public ByteArrayResource pdfService(PdfRequest request) throws PdfGeneratorFileException, PdfFileException {

        requestrequest.mapperValidator(request);

        Context context = new Context();
        request.getData().forEach((k,v)-> context.setVariable(k,v));

        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(templateEngine.process("exampletemplate", context), "http://localhost:8088");

        renderer.layout();
        try {
            renderer.createPDF(bos, false);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        renderer.finishPDF();
        ByteArrayResource inputStreamResourcePDF = new ByteArrayResource(bos.toByteArray());

        return inputStreamResourcePDF;
    }






}
