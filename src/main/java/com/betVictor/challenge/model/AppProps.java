package com.betVictor.challenge.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AppProps {
    private final String mongodbHost, mongodbPort, mongodbDatabase, websocketEndpoint, websocketDestination;
}
