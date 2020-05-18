package com.betVictor.challenge.common.model;

import org.junit.Assert;
import org.junit.Test;

public class GenericRecordTest extends Assert {

    @Test
    public void toJsonTest(){
        assertEquals("{_id: 1, content: 'content1'}", new GenericRecord("1", "content1").toJson());
        assertEquals("{_id: 1, content: 'null'}", new GenericRecord("1", null).toJson());
    }
}
