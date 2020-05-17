package com.betVictor.challenge.common.model;

import org.junit.Assert;
import org.junit.Test;

public class HttpResponseTest extends Assert {

    @Test
    public void toJsonTest(){
        assertEquals("{httpResponseObject: {_id: 1, content: 'content1'}, statusCode: 200}", new HttpResponse(new GenericRecord(1, "content1"), 200).toJson());
        assertEquals("{httpResponseObject: {_id: 1, content: 'null'}, statusCode: 200}", new HttpResponse(new GenericRecord(1, null), 200).toJson());
    }
}
