package com.betVictor.challenge.uiHandlerService.model;

import org.junit.Assert;
import org.junit.Test;

public class HttpMethodInputTest extends Assert {

    @Test
    public void toStringTest(){
        assertEquals("{collection: '', id: 1, content: 'null'}", new HttpMethodInput("", 1).toJson());
        assertEquals("{collection: 'null', id: 1, content: 'null'}", new HttpMethodInput(null, 1).toJson());

        assertEquals("{collection: '', id: -1, content: ''}", new HttpMethodInput("", "").toJson());
        assertEquals("{collection: 'null', id: -1, content: ''}", new HttpMethodInput(null, "").toJson());
        assertEquals("{collection: '', id: -1, content: 'null'}", new HttpMethodInput("", null).toJson());
        assertEquals("{collection: 'null', id: -1, content: 'null'}", new HttpMethodInput(null, null).toJson());

        assertEquals("{collection: '', id: -1, content: ''}", new HttpMethodInput("", -1, "").toJson());
        assertEquals("{collection: 'null', id: -1, content: ''}", new HttpMethodInput(null, -1, "").toJson());
        assertEquals("{collection: '', id: -1, content: 'null'}", new HttpMethodInput("", -1, null).toJson());
    }
}
