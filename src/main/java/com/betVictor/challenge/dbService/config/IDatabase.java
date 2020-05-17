package com.betVictor.challenge.dbService.config;

public interface IDatabase {

    String insertDocument(String collection, String content);

    String getDocument(String collection, long id);

    String updateDocument(String collection, long id, String content);

    String deleteDocument(String collection, long id);
}
