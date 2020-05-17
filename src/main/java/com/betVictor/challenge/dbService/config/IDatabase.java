package com.betVictor.challenge.dbService.config;

import com.betVictor.challenge.dbService.model.GenericRecord;

public interface IDatabase {

    long insertDocument(String collection, String content);

    GenericRecord getDocument(String collection, long id);

    long updateDocument(String collection, long id, String content);

    long deleteDocument(String collection, long id);
}
