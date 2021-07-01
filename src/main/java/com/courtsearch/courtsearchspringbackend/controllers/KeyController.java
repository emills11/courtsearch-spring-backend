package com.courtsearch.courtsearchspringbackend.controllers;

import java.util.ArrayList;
import java.util.List;

import com.courtsearch.courtsearchspringbackend.model.KeyModel;
import com.courtsearch.courtsearchspringbackend.repository.KeyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KeyController {
    
    private final KeyRepository keyRepository;

    @Autowired
    public KeyController(KeyRepository keyRepository) {
        this.keyRepository = keyRepository;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/keys")
    public ResponseEntity<List<KeyModel>> getKey(@RequestParam String type) {
        try {
            List<KeyModel> keys = new ArrayList<KeyModel>();

            keyRepository.findByKeyType(type).forEach(keys::add);

            if (keys.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(keys, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
