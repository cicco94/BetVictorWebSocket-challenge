package com.betVictor.challenge.dbService.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GenericRecord {
    private final long _id;
    private final String content;

    @Override
    public String toString() {
        return "{" +
                "_id=" + _id +
                ", content='" + content + '\'' +
                '}';
    }

    public String toJson(){ return toString(); }
}
