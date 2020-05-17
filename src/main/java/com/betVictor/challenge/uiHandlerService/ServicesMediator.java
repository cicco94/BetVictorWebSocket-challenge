package com.betVictor.challenge.uiHandlerService;

import com.betVictor.challenge.dbService.config.ConcreteMongoDb;
import com.betVictor.challenge.dbService.config.IDatabase;
import com.betVictor.challenge.model.AppProps;
import com.betVictor.challenge.model.GenericRecord;
import com.betVictor.challenge.model.HttpResponse;
import com.betVictor.challenge.uiHandlerService.model.HttpMethodInput;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import java.util.function.Function;

public class ServicesMediator {
    private final IDatabase database;
    private final SimpMessageSendingOperations messagingTemplate;
    private final AppProps props;

    public ServicesMediator(SimpMessageSendingOperations messagingTemplate, AppProps props) {
        database = new ConcreteMongoDb(props.getMongodbHost(),
                props.getMongodbPort(), props.getMongodbDatabase());
        this.messagingTemplate = messagingTemplate;
        this.props = props;
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
        messagingTemplate.convertAndSend(props.getWebsocketDestination(),  onStartingMessage);
        try{
            final GenericRecord genericRecord = function.apply(httpMethodInput);
            messagingTemplate.convertAndSend(props.getWebsocketDestination(), "success for: " + genericRecord.toJson());
            return new HttpResponse(genericRecord, 200);
        } catch (Exception ex){
            final String message = ex.getMessage() + " on '" + httpMethodInput.toJson() + "'";
            messagingTemplate.convertAndSend(props.getWebsocketDestination(), message);
            return new HttpResponse(new GenericRecord(-1, httpMethodInput.toJson()), 500);
        }
    }
}
