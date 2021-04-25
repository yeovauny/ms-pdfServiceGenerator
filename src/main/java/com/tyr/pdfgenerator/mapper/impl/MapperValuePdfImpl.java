package com.tyr.pdfgenerator.mapper.impl;

import com.tyr.pdfgenerator.domain.PdfRequest;
import com.tyr.pdfgenerator.exception.PdfFileException;
import com.tyr.pdfgenerator.exception.PdfGeneratorFileException;
import com.tyr.pdfgenerator.mapper.MapperValuePdf;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class MapperValuePdfImpl implements MapperValuePdf {


    @Override
    public void mapperValidator(PdfRequest request ) throws  PdfFileException {
        StringBuilder title= new StringBuilder("/variablesValidator/");
        if(request.getTitle()!= null || !request.getTitle().isBlank()){
            title.append(request.getTitle());
            title.append(".txt");
        }else
            throw new PdfFileException("Bad reques,miss the title key");


        List<String> lista=new ArrayList<>();

        try {
            try (InputStream inputStream = getClass().getResourceAsStream(title.toString());
                 BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                String contents = reader.lines().collect(Collectors.joining(System.lineSeparator()));
                lista = Arrays.asList(contents.split("\\s*,\\s*"));
            }

        } catch (Exception e) {
           throw  new PdfGeneratorFileException("this file with that name, don't exist on configurations properties");
        }

        Map<String, Object> mapaGenerico = request.getData();
            boolean fal= lista.stream().allMatch( l -> mapaGenerico.containsKey(l));

            // Assertion usses for new way to validate
        Assert.isTrue(fal, "miss on request body values on "+title.toString()+" file validator");

        return ;
    }
}
