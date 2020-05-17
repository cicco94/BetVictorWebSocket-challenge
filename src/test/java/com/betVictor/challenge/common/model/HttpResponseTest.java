package com.betVictor.challenge.common.model;

import org.junit.Assert;
import org.junit.Test;

public class HttpResponseTest extends Assert {

    @Test
    public void toJson(){
        assertEquals("{message: 'message', statusCode: 200}", new HttpResponse("message", 200).toJson());
        assertEquals("{message: 'null', statusCode: 200}", new HttpResponse(null, 200).toJson());
    }
}
