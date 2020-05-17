package com.betVictor.challenge.dbService.config;

import com.betVictor.challenge.model.GenericRecord;

public interface IDatabase {

    String getConnectionUrl(String host, int port);

    GenericRecord insertDocument(String collection, String content);

    GenericRecord getDocument(String collection, long id);

    GenericRecord updateDocument(String collection, long id, String content);

    GenericRecord deleteDocument(String collection, long id);
}
