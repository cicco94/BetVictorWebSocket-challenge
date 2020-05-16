package com.betVictor.challenge.dbService.config;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class ConcreteMongoDb implements IDatabase{
    private static long _id = 0;
    private final MongoClient mongoClient;

    public ConcreteMongoDb(String host, int port) {
        mongoClient = new MongoClient(host, port);
    }

    private MongoCollection<Document> getCollection(String database, String collection){
        return mongoClient.getDatabase(database).getCollection(collection);
    }

    @Override
    public boolean insertDocument(String database, String collection, String content) {
        getCollection(database, collection)
                .insertOne(new Document("_id", _id++).append("content", content));
        return true;
    }

    @Override
    public FindIterable<Document> getDocument(String database, String collection, long id) {
        return getCollection(database, collection).find(new Document("_id", id));
    }

    @Override
    public boolean updateDocument(String database, String collection, String id, String content) {
        return getCollection(database, collection).findOneAndUpdate(
                new Document("_id", id),
                new Document("_id", id).append("content", content)) != null;
    }

    @Override
    public boolean deleteDocument(String database, String collection, String id) {
        return getCollection(database, collection).findOneAndDelete(new Document("_id", id)) != null;
    }
}
