package com.betVictor.challenge.uiHandlerService;

import com.betVictor.challenge.dbService.config.ConcreteMongoDb;
import com.betVictor.challenge.dbService.config.IDatabase;
import com.betVictor.challenge.model.GenericRecord;
import com.betVictor.challenge.model.HttpResponse;
import com.betVictor.challenge.uiHandlerService.model.HttpMethodInput;
import org.springframework.messaging.simp.SimpMessageSendingOperations;

import java.util.function.Function;

public class ServicesMediator {
    private final IDatabase database = new ConcreteMongoDb("localhost", 27017, "databaseName"); // TODO pass by conf
    private final SimpMessageSendingOperations messagingTemplate;

    public ServicesMediator(SimpMessageSendingOperations messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public HttpResponse insertDocument(String collection, String content) {
        return httpRequest("inserting a document...",
                new HttpMethodInput(collection, content),
                httpMethodInput -> this.database.insertDocument(httpMethodInput.getCollection(), httpMethodInput.getContent()));
    }

    public HttpResponse getDocument(String collection, long id) {
        return httpRequest("getting a document...",
                new HttpMethodInput(collection, id),
                httpMethodInput -> this.database.getDocument(httpMethodInput.getCollection(), httpMethodInput.getId()));
    }

    public HttpResponse updateDocument(String collection, long id, String content) {
        return httpRequest("updating a document...",
                new HttpMethodInput(collection, id, content),
                httpMethodInput -> this.database.updateDocument(httpMethodInput.getCollection(), httpMethodInput.getId(), httpMethodInput.getContent()));
    }

    public HttpResponse deleteDocument(String collection, long id) {
        return httpRequest("deleting a document...",
                new HttpMethodInput(collection, id),
                httpMethodInput -> this.database.deleteDocument(httpMethodInput.getCollection(), httpMethodInput.getId()));
    }

    public HttpResponse httpRequest(String onStartingMessage,
                                    HttpMethodInput httpMethodInput,
                                    Function<HttpMethodInput, GenericRecord> function){
        messagingTemplate.convertAndSend("/topic/greetings",  onStartingMessage);
        try{
            final GenericRecord genericRecord = function.apply(httpMethodInput);
            messagingTemplate.convertAndSend("/topic/greetings", "success for: " + genericRecord.toJson());
            return new HttpResponse(genericRecord, 200);
        } catch (Exception ex){
            final String message = ex.getMessage() + " on '" + httpMethodInput.toJson() + "'";
            messagingTemplate.convertAndSend("/topic/greetings", message);
            return new HttpResponse(new GenericRecord(-1, httpMethodInput.toJson()), 500);
        }
    }
}
