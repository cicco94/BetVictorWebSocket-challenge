package com.betVictor.challenge.common.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

@AllArgsConstructor
@NoArgsConstructor
public class GenericRecord extends HttpResponseObject {
    @Id
    private String _id;
    @Field("content")
    private String content;

    @Override
    public String toString() {
        return "{_id: " + _id + ", content: '" + content + "'}";
    }

    @Override
    public String toJson(){ return toString(); }
}
