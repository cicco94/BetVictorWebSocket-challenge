package com.betVictor.challenge.restService;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import com.betVictor.challenge.model.GenericDocument;

@RestController
// @RequestMapping("/api/v1/")
public class DocumentController {
    @GetMapping("/getDocument")
    @ApiOperation(value = "Get a new document")
    public GenericDocument test(@RequestParam String id) {
        return new GenericDocument();
    }

    @PostMapping("/insertDocument")
    @ApiOperation(value = "Insert a new document")
    public GenericDocument insertDocument(@RequestParam String content) {
        return new GenericDocument();
    }

    @PostMapping("/updateDocument")
    @ApiOperation(value = "Update a document")
    public GenericDocument updateDocument(@RequestParam String id, @RequestParam String content) {
        return new GenericDocument();
    }

    @PostMapping("/upsertDocument")
    @ApiOperation(value = "Upsert a document")
    public GenericDocument upsertDocument(@RequestParam String id, @RequestParam String content) {
        return new GenericDocument();
    }

    @DeleteMapping("/deleteDocument")
    @ApiOperation(value = "Delete a document")
    public GenericDocument deleteDocument(@RequestParam String id) {
        return new GenericDocument();
    }
}
