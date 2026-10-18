package com.app.lps.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HelloWorldResponse {

    @JsonProperty("id")
    Long id;

    @JsonProperty("content")
    String content;

    public HelloWorldResponse(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
