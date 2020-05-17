package com.betVictor.challenge.dbService.config;

import com.betVictor.challenge.common.model.GenericRecord;
// import com.github.fakemongo.Fongo;
import org.junit.Assert;
import org.junit.Test;

public class ConcreteMongoDbTest extends Assert {

    @Test
    public void getConnectionUrlTest(){
        assertEquals("mongodb://host:port", ConcreteMongoDb.getConnectionUrl("host", "port"));
    }

    @Test
    public void insertDocumentTest(){
        // new Fongo("mongo-test").getMongo().getDatabase("").getCollection("");

    }
}
