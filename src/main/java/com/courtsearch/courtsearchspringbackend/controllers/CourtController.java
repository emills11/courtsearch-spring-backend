package com.courtsearch.courtsearchspringbackend.controllers;

import java.util.List;

import com.courtsearch.courtsearchspringbackend.model.CourtModel;
import com.courtsearch.courtsearchspringbackend.repository.CourtRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourtController {

    private final CourtRepository courtRepository;

    @Autowired
    public CourtController(CourtRepository courtRepository) {
        this.courtRepository = courtRepository;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/courts")
    public List<CourtModel> getCourts() {
        return courtRepository.findAll();
    }
}