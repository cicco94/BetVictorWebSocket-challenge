package com.betVictor.challenge.common.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AppProps {
    private final String mongodbHost, mongodbPort, mongodbDatabase;
    private final String websocketEndpoint, websocketDestination;
    private final String systemVersionDbService, systemVersionRestService,
            systemVersionUiHandlerService, systemVersionWebSocketService;
}
