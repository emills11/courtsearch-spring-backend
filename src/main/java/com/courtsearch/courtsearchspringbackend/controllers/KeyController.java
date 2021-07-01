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

/**
 * Rest controller for interacting with keys collection in MongoDB
 * @author Eli Mills
 */
@RestController
public class KeyController {
    
    private final KeyRepository keyRepository;

    /**
     * Constructor
     * @param keyRepository The repository used for accessing keys data
     */
    @Autowired
    public KeyController(KeyRepository keyRepository) {
        this.keyRepository = keyRepository;
    }

    /**
     * Takes GET requests to retrieve all keys within a given type in keys collection
     * @param type The type of key, e.g. "mapbox"
     * @return ResponseEntity with response body and status
     */
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
