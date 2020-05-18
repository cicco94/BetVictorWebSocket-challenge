package com.betVictor.challenge.restService;

import com.betVictor.challenge.uiHandlerService.ServicesMediator;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class DocumentController {
    @Autowired
    ServicesMediator servicesMediator;

    @PostMapping("/insertDocument")
    @ApiOperation(value = "Insert a new document")
    public String insertDocument(@RequestParam String collection, @RequestParam String id, @RequestParam String content) {
        return servicesMediator.insertDocument(collection, id, content).toJson();
    }

    @GetMapping("/getDocument")
    @ApiOperation(value = "Get a document")
    public String getDocument(@RequestParam String collection, @RequestParam String id) {
        return servicesMediator.getDocument(collection, id).toJson();
    }

    @PostMapping("/updateDocument")
    @ApiOperation(value = "Update a document")
    public String updateDocument(@RequestParam String collection, @RequestParam String id, @RequestParam String content) {
        return servicesMediator.updateDocument(collection, id, content).toJson();
    }

    @DeleteMapping("/deleteDocument")
    @ApiOperation(value = "Delete a document")
    public String deleteDocument(@RequestParam String collection, @RequestParam String id) {
        return servicesMediator.deleteDocument(collection, id).toJson();
    }
}
