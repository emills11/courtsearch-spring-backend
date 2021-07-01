package com.courtsearch.courtsearchspringbackend.controllers;

import java.util.ArrayList;
import java.util.List;

import com.courtsearch.courtsearchspringbackend.model.CourtModel;
import com.courtsearch.courtsearchspringbackend.repository.CourtRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<CourtModel>> getCourts() {
        try {
            List<CourtModel> courts = new ArrayList<CourtModel>();

            courtRepository.findAll().forEach(courts::add);

            if (courts.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(courts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}