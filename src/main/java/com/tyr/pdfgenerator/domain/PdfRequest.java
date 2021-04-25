package com.tyr.pdfgenerator.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Map;

public class PdfRequest {

    @NotBlank
    @NotNull(message=" the field title must be exist on request")
    private String title;

    @NotBlank
    @NotNull(message=" the field name must be exist on request")
    private String name;

    @NotNull(message=" the field data must be exist on request")
    private Map<String, Object> data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
