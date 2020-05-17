package com.betVictor.challenge.common.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class HttpResponse {
    private final HttpResponseObject httpResponseObject;
    private final int statusCode;

    @Override
    public String toString() {
        return "{httpResponseObject: " + httpResponseObject.toJson() + ", statusCode: " + statusCode + "}";
    }

    public String toJson(){ return toString(); }
}
