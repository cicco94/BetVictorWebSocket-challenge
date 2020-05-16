package com.betVictor.challenge.restService;

import com.betVictor.challenge.webSocketService.config.ServicesMediator;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
// @RequestMapping("/api/v1/")
public class DocumentController {
    @Autowired
    ServicesMediator servicesMediator;

    @PostMapping("/insertDocument")
    @ApiOperation(value = "Insert a new document")
    public void insertDocument(@RequestParam String database, @RequestParam String collection, @RequestParam String content) {
        servicesMediator.insertDocument(database, collection, content);
    }

    @PostMapping("/updateDocument")
    @ApiOperation(value = "Update a document")
    public void updateDocument(@RequestParam String database, @RequestParam String collection, @RequestParam String id, @RequestParam String content) {
        servicesMediator.updateDocument(database, collection, id, content);
    }

    @DeleteMapping("/deleteDocument")
    @ApiOperation(value = "Delete a document")
    public void deleteDocument(@RequestParam String database, @RequestParam String collection, @RequestParam String id) {
        servicesMediator.deleteDocument(database, collection, id);
    }
}
