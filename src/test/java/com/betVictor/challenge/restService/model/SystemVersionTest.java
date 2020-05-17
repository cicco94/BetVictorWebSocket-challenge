package com.betVictor.challenge.restService.model;

import org.junit.Assert;
import org.junit.Test;

public class SystemVersionTest extends Assert {

    @Test
    public void toJsonTest(){
        assertEquals("{dbServiceVersion: 'null', restServiceVersion: 'null', uiHandlerServiceVersion: 'null', webSocketServiceVersion: 'null'}", new SystemVersion(null, null, null, null).toJson());
        assertEquals("{dbServiceVersion: 'v1', restServiceVersion: 'v2', uiHandlerServiceVersion: 'v3', webSocketServiceVersion: 'v4'}", new SystemVersion("v1", "v2", "v3", "v4").toJson());
    }
}
