package com.betVictor.challenge.dbService.config;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class ConcreteMongoDb implements IDatabase{
    private static long id = System.currentTimeMillis();
    private final MongoClient mongoClient;

    public ConcreteMongoDb(String host, int port) {
        mongoClient = new MongoClient(host, port);
    }

    private MongoCollection<Document> getCollection(String database, String collection){
        return mongoClient.getDatabase(database).getCollection(collection);
    }

    @Override
    public long insertDocument(String database, String collection, String content) {
        getCollection(database, collection)
                .insertOne(new Document("_id", ++id).append("content", content));
        return id;
    }

    @Override
    public Document getDocument(String database, String collection, long id) {
        return getCollection(database, collection).find(new Document("_id", id)).iterator().next();
    }

    @Override
    public long updateDocument(String database, String collection, long id, String content) {
        getCollection(database, collection).findOneAndUpdate(
                new Document("_id", id),
                new Document("content", content)); // TODO do I have to pass the id again?
        return id;
    }

    @Override
    public long deleteDocument(String database, String collection, long id) {
        getCollection(database, collection).findOneAndDelete(new Document("_id", id));
        return id;
    }
}
