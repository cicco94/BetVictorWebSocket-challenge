package com.betVictor.challenge.uiHandlerService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class HttpMethodInput {
    private final String collection;
    private final String id;
    private String content;

    public HttpMethodInput(String collection, String id) {
        this.collection = collection;
        this.id = id;
    }

    @Override
    public String toString() {
        return "{" +
                "collection: '" + collection + '\'' +
                ", id: " + id +
                ", content: '" + content + '\'' +
                '}';
    }

    public String toJson(){ return toString(); }
}
