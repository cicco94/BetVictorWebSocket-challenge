package com.betVictor.challenge.dbService.config;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Database {
    private final MongoClient mongoClient;
    private final MongoDatabase mongoDatabase;

    public Database(String host, int port, String databaseName) {
        mongoClient = new MongoClient(host, port);
        mongoDatabase = mongoClient.getDatabase(databaseName);
    }

    public MongoCollection<Document> getCollection(String collectionName){
        return mongoDatabase.getCollection(collectionName);
    }
}
