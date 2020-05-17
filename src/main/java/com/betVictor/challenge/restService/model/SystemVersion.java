package com.betVictor.challenge.restService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SystemVersion {
    private final String dbServiceVersion, restServiceVersion,
            uiHandlerServiceVersion, webSocketServiceVersion;

    @Override
    public String toString() {
        return "{" +
                "dbServiceVersion: '" + dbServiceVersion + '\'' +
                ", restServiceVersion: '" + restServiceVersion + '\'' +
                ", uiHandlerServiceVersion: '" + uiHandlerServiceVersion + '\'' +
                ", webSocketServiceVersion: '" + webSocketServiceVersion + '\'' +
                '}';
    }

    public String toJson(){ return toString(); }
}
