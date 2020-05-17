package com.betVictor.challenge.restService;

import com.betVictor.challenge.common.model.AppProps;
import com.betVictor.challenge.restService.model.SystemVersion;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class SystemController {
    @Autowired
    private AppProps appProps;

    @GetMapping("/checkAppStatus")
    @ApiOperation(value = "Check if app is on")
    public boolean isAppOn() {
        return true;
    }

    @GetMapping("/checkSystemVersion")
    @ApiOperation(value = "Get version of the app")
    public String checkSystemVersion() {
        return new SystemVersion(appProps.getSystemVersionDbService(),
                appProps.getSystemVersionRestService(),
                appProps.getSystemVersionUiHandlerService(),
                appProps.getSystemVersionWebSocketService()).toJson();
    }
}
