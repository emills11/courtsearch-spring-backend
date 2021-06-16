package com.courtsearch.courtsearchspringbackend.controllers;

import java.util.List;

import com.courtsearch.courtsearchspringbackend.model.KeyModel;
import com.courtsearch.courtsearchspringbackend.repository.KeyRepository;

import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/api/keys")
    public List<KeyModel> getKey(@RequestParam String type) {
        return keyRepository.findByKeyType(type);
    }
}
