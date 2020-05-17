package com.betVictor.challenge;

import com.betVictor.challenge.model.AppProps;
import com.betVictor.challenge.uiHandlerService.ServicesMediator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.env.Environment;
import org.springframework.messaging.simp.SimpMessageSendingOperations;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean("appProps")
    @Autowired
    public AppProps getProperties(Environment env) {
        return new AppProps(env.getProperty("mongodb.host"), env.getProperty("mongodb.port"), env.getProperty("mongodb.database"),
                env.getProperty("websocket.endpoint"), env.getProperty("websocket.destination"));
    }

    @Bean
    @DependsOn({"appProps"})
    @Autowired
    public ServicesMediator servicesMediator(SimpMessageSendingOperations messagingTemplate, AppProps appProps){
        return new ServicesMediator(messagingTemplate, appProps);
    }
}