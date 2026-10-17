package com.app.lps.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HelloWorldResponse {

    @JsonProperty("text")
    String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public HelloWorldResponse(String text) {
        this.text = text;
    }
}
