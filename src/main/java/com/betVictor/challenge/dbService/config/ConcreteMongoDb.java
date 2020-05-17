package com.betVictor.challenge.dbService.config;

import com.betVictor.challenge.dbService.model.GenericRecord;
import com.mongodb.client.MongoClients;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Update.update;

public class ConcreteMongoDb implements IDatabase{
    private static long id = System.currentTimeMillis();
    private final MongoOperations mongoOps;

    public ConcreteMongoDb(String host, int port, String database) {
        this.mongoOps = new MongoTemplate(MongoClients.create("mongodb://" + host + ":" + port), database);
    }

    @Override
    public long insertDocument(String collection, String content) {
        mongoOps.insert(new GenericRecord(++id, content), collection);
        return id;
    }

    @Override
    public GenericRecord getDocument(String collection, long id) {
        return mongoOps.findOne(new Query(where("_id").is(id)), GenericRecord.class, collection);
    }

    @Override
    public long updateDocument(String collection, long id, String content) {
        mongoOps.updateFirst(new Query(where("_id").is(id)), update("content", content), GenericRecord.class, collection);
        return id;
    }

    @Override
    public long deleteDocument(String collection, long id) {
        mongoOps.remove(new Query(where("_id").is(id)), GenericRecord.class, collection);
        return id;
    }
}
