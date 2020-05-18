package com.betVictor.challenge.uiHandlerService;

import com.betVictor.challenge.dbService.config.ConcreteMongoDb;
import com.betVictor.challenge.dbService.config.IDatabase;
import com.betVictor.challenge.common.model.AppProps;
import com.betVictor.challenge.common.model.HttpResponse;
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

    public HttpResponse insertDocument(String collection, String id, String content) {
        return httpRequest("inserting a document...",
                new HttpMethodInput(collection, id, content),
                httpMethodInput -> this.database.insertDocument(httpMethodInput.getCollection(), id, httpMethodInput.getContent()));
    }

    public HttpResponse getDocument(String collection, String id) {
        return httpRequest("getting a document...",
                new HttpMethodInput(collection, id),
                httpMethodInput -> this.database.getDocument(httpMethodInput.getCollection(), httpMethodInput.getId()));
    }

    public HttpResponse updateDocument(String collection, String id, String content) {
        return httpRequest("updating a document...",
                new HttpMethodInput(collection, id, content),
                httpMethodInput -> this.database.updateDocument(httpMethodInput.getCollection(), httpMethodInput.getId(), httpMethodInput.getContent()));
    }

    public HttpResponse deleteDocument(String collection, String id) {
        return httpRequest("deleting a document...",
                new HttpMethodInput(collection, id),
                httpMethodInput -> this.database.deleteDocument(httpMethodInput.getCollection(), httpMethodInput.getId()));
    }

    public HttpResponse httpRequest(String onStartingMessage,
                                    HttpMethodInput httpMethodInput,
                                    Function<HttpMethodInput, String> function){
        messagingTemplate.convertAndSend(props.getWebsocketDestination(),  onStartingMessage);
        try{
            final String result = function.apply(httpMethodInput);
            if(result == null){
                final String message = "404 for request: " + httpMethodInput.toJson();
                messagingTemplate.convertAndSend(props.getWebsocketDestination(), message);
                return new HttpResponse(message, 404);
            }
            messagingTemplate.convertAndSend(props.getWebsocketDestination(), "success for: " + result);
            return new HttpResponse(result, 200);
        } catch (Exception ex){
            messagingTemplate.convertAndSend(props.getWebsocketDestination(), ex.getMessage());
            return new HttpResponse(ex.getMessage(), 500);
        }
    }
}
