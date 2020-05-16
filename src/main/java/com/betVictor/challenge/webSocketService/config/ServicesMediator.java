package com.betVictor.challenge.webSocketService.config;

import com.betVictor.challenge.dbService.config.ConcreteMongoDb;
import com.betVictor.challenge.dbService.config.IDatabase;
// import com.mongodb.client.FindIterable;
// import org.bson.Document;
import org.springframework.messaging.simp.SimpMessageSendingOperations;

public class ServicesMediator {
    private final IDatabase database = null; // new ConcreteMongoDb("localhost", 8080); // TODO pass by conf
    private final SimpMessageSendingOperations messagingTemplate;

    public ServicesMediator(SimpMessageSendingOperations messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void insertDocument(String database, String collection, String content) {
        messagingTemplate.convertAndSend("/topic/greetings", "inserting a document...");
        //if(this.database.insertDocument(database, collection, content)){
         //   messagingTemplate.convertAndSend("document inserted!");
       // }
        //else messagingTemplate.convertAndSend("error on inserting!");
    }

    public void updateDocument(String database, String collection, String id, String content) {
        messagingTemplate.convertAndSend("/app", "updating a document...");
        //if(this.database.updateDocument(database, collection, id, content)){
        //    messagingTemplate.convertAndSend("document updated!");
      //  }
      //  else messagingTemplate.convertAndSend("error on updating!");
    }

    public void deleteDocument(String database, String collection, String id) {
        messagingTemplate.convertAndSend("/app", "deleting a document...");
       // if(this.database.deleteDocument(database, collection, id)){
       //     messagingTemplate.convertAndSend("document deleted!");
       // }
       // else messagingTemplate.convertAndSend("error on deleting!");
    }
}
