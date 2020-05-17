package com.betVictor.challenge.uiHandlerService;

import com.betVictor.challenge.dbService.config.ConcreteMongoDb;
import com.betVictor.challenge.dbService.config.IDatabase;
import com.betVictor.challenge.dbService.model.GenericRecord;
import org.springframework.messaging.simp.SimpMessageSendingOperations;

public class ServicesMediator {
    private final IDatabase database = new ConcreteMongoDb("localhost", 27017, "databaseName"); // TODO pass by conf
    private final SimpMessageSendingOperations messagingTemplate;

    public ServicesMediator(SimpMessageSendingOperations messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void insertDocument(String collection, String content) {
        messagingTemplate.convertAndSend("/topic/greetings", "inserting a document...");
        try{
            final long id = this.database.insertDocument(collection, content);
            messagingTemplate.convertAndSend("/topic/greetings", "document inserted with id: " + id);
        } catch (Exception ex){
            messagingTemplate.convertAndSend("/topic/greetings", ex.getMessage() + " on inserting '" + content + "'");
        }
    }

    public GenericRecord getDocument(String collection, long id) {
        messagingTemplate.convertAndSend("/topic/greetings", "getting a document...");
        try{
            final GenericRecord genericRecord = this.database.getDocument(collection, id);
            messagingTemplate.convertAndSend("/topic/greetings", "get document: " + genericRecord.toString());
            return genericRecord;
        } catch (Exception ex){
            messagingTemplate.convertAndSend("/topic/greetings", ex.getMessage() + " on getting document with id: '" + id + "'");
            return null;
        }
    }

    public void updateDocument(String collection, long id, String content) {
        messagingTemplate.convertAndSend("/topic/greetings",  "updating a document...");
        try{
            final long updateDocumentId = this.database.updateDocument(collection, id, content);
            messagingTemplate.convertAndSend("/topic/greetings", "document updated with id: " + updateDocumentId);
        } catch (Exception ex){
            messagingTemplate.convertAndSend("/topic/greetings", ex.getMessage() + " on updating '" + id + "'");
        }
    }

    public void deleteDocument(String collection, long id) {
        messagingTemplate.convertAndSend("/topic/greetings",  "deleting a document...");

        try{
            final long deleteDocumentId = this.database.deleteDocument(collection, id);
            messagingTemplate.convertAndSend("/topic/greetings", "document deleted with id: " + deleteDocumentId);
        } catch (Exception ex){
            messagingTemplate.convertAndSend("/topic/greetings", ex.getMessage() + " on deleting document with id: '" + id + "'");
        }
    }
}
