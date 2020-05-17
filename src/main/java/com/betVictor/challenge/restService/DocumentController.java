package com.betVictor.challenge.restService;

import com.betVictor.challenge.dbService.model.GenericRecord;
import com.betVictor.challenge.uiHandlerService.ServicesMediator;
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
    public void insertDocument(@RequestParam String collection, @RequestParam String content) {
        servicesMediator.insertDocument(collection, content);
    }

    @GetMapping("/getDocument")
    @ApiOperation(value = "Get a document")
    public String getDocument(@RequestParam String collection, @RequestParam long id) {
        return servicesMediator.getDocument(collection, id).toJson();
    }

    @PostMapping("/updateDocument")
    @ApiOperation(value = "Update a document")
    public void updateDocument(@RequestParam String collection, @RequestParam long id, @RequestParam String content) {
        servicesMediator.updateDocument(collection, id, content);
    }

    @DeleteMapping("/deleteDocument")
    @ApiOperation(value = "Delete a document")
    public void deleteDocument(@RequestParam String collection, @RequestParam long id) {
        servicesMediator.deleteDocument(collection, id);
    }
}
