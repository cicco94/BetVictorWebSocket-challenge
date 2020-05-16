package com.betVictor.challenge.dbService.config;

import com.mongodb.client.FindIterable;
import org.bson.Document;

public interface IDatabase {

    boolean insertDocument(String database, String collection, String content);

    FindIterable<Document> getDocument(String database, String collection, long id);

    boolean updateDocument(String database, String collection, String id, String content);

    boolean deleteDocument(String database, String collection, String id);
}
