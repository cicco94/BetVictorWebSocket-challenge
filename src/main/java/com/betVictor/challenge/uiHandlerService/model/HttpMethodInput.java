package com.betVictor.challenge.uiHandlerService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class HttpMethodInput {
    private final String collection;
    private final long id;
    private final String content;

    public HttpMethodInput(String collection, long id) {
        this.collection = collection;
        this.id = id;
        this.content = null;
    }

    public HttpMethodInput(String collection, String content) {
        this.collection = collection;
        this.id = -1;
        this.content = content;
    }

    public String toJson() {
        return "{collection: '" + collection + "', id: " + id + ", content: '" + content + "'}";
    }

    @Override
    public String toString(){ return toJson(); }
}
