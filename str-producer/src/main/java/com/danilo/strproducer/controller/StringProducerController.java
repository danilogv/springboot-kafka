package com.danilo.strproducer.controller;

import com.danilo.strproducer.service.StringProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/producer")
public class StringProducerController {

    @Autowired
    private StringProducerService stringService;

    @PostMapping
    public ResponseEntity<?> sendMessage(@RequestBody String message) {
        this.stringService.sendMessage(message);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
