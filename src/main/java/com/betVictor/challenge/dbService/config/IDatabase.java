package com.betVictor.challenge.dbService.config;

public interface IDatabase {

    String insertDocument(String collection, String id, String content);

    String getDocument(String collection, String id);

    String updateDocument(String collection, String id, String content);

    String deleteDocument(String collection, String id);
}
