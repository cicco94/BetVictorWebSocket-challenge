package com.betVictor.challenge.common.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class HttpResponse {
    private String message;
    private final int statusCode;

    @Override
    public String toString() {
        return "{message: '" + message + "', statusCode: " + statusCode + "}";
    }

    public String toJson(){ return toString(); }
}
