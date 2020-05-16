package com.betVictor.challenge;

import com.betVictor.challenge.webSocketService.config.ServicesMediator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.simp.SimpMessageSendingOperations;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    @Autowired
    public ServicesMediator servicesMediator(SimpMessageSendingOperations messagingTemplate){
        return new ServicesMediator(messagingTemplate);
    }

}