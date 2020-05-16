package com.betVictor.challenge.dbService.config;

import org.bson.Document;

public interface IDatabase {

    long insertDocument(String database, String collection, String content);

    Document getDocument(String database, String collection, long id);

    long updateDocument(String database, String collection, long id, String content);

    long deleteDocument(String database, String collection, long id);
}
