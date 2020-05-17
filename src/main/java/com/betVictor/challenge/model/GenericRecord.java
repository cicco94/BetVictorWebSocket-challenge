package com.betVictor.challenge.model;

import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

@AllArgsConstructor
public class GenericRecord extends HttpResponseObject {
    @Id
    private long _id;
    @Field("content")
    private String content;

    public GenericRecord() { }

    public GenericRecord(long _id) {
        this._id = _id;
    }

    @Override
    public String toString() {
        return "{_id: " + _id + ", content: '" + content + "}";
    }

    @Override
    public String toJson(){ return toString(); }
}
