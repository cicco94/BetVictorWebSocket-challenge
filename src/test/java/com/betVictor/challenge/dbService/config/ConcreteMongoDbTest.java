package com.betVictor.challenge.dbService.config;

import org.junit.Assert;
import org.junit.Test;

public class ConcreteMongoDbTest extends Assert {

    @Test
    public void getConnectionUrlTest(){
        assertEquals("mongodb://host:port", ConcreteMongoDb.getConnectionUrl("host", "port"));
    }
}
