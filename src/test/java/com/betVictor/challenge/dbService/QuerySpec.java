package com.betVictor.challenge.dbService;

import com.betVictor.challenge.dbService.config.Database;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.junit.Test;

public class QuerySpec {

    @Test
    public void simple(){
        Database database = new Database("localhost", 27017, "yourdb");

        MongoCollection<Document> collection = database.getCollection("dummyColl");
        collection.insertOne(new Document().append("_id", 3).append("value", 3));

        FindIterable<Document> res = collection.find(new Document().append("_id", 3));
        for(Document document: res){
            System.out.println(document.toJson());
        }
    }
}
