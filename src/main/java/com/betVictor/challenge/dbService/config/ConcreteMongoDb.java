package com.betVictor.challenge.dbService.config;

import com.betVictor.challenge.common.model.GenericRecord;
import com.mongodb.client.MongoClients;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Update.update;

public class ConcreteMongoDb implements IDatabase{
    private final MongoOperations mongoOps;

    public ConcreteMongoDb(String host, String port, String database) {
        this.mongoOps = new MongoTemplate(MongoClients.create(getConnectionUrl(host, port)), database);
    }

    public static String getConnectionUrl(String host, String port) { return "mongodb://" + host + ":" + port; }

    @Override
    public String insertDocument(String collection, String id, String content) {
        return mongoOps.insert(new GenericRecord(id, content), collection).toJson();
    }

    @Override
    public String getDocument(String collection, String id) {
        GenericRecord genericRecord = mongoOps.findOne(new Query(where("_id").is(id)), GenericRecord.class, collection);
        if(genericRecord != null) return genericRecord.toJson();
        return null;
    }

    @Override
    public String updateDocument(String collection, String id, String content) {
        return mongoOps.updateFirst(new Query(where("_id").is(id)), update("content", content), GenericRecord.class, collection).toString();
    }

    @Override
    public String deleteDocument(String collection, String id) {
        return mongoOps.remove(new Query(where("_id").is(id)), GenericRecord.class, collection).toString();
    }
}
