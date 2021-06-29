package com.courtsearch.courtsearchspringbackend.controllers;

import java.util.ArrayList;
import java.util.List;

import com.courtsearch.courtsearchspringbackend.model.AddCourtModel;
import com.courtsearch.courtsearchspringbackend.repository.AddCourtRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddCourtController {
    
    private final AddCourtRepository addCourtRepository;

    @Autowired
    public AddCourtController(AddCourtRepository addCourtRepository) {
        this.addCourtRepository = addCourtRepository;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/add_courts")
    public ResponseEntity<List<AddCourtModel>> getNewCourts() {
        try {
            List<AddCourtModel> newCourts = new ArrayList<AddCourtModel>();
            
            addCourtRepository.findAll().forEach(newCourts::add);

            if (newCourts.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(newCourts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/api/add_courts")
    public ResponseEntity<AddCourtModel> createNewCourt(@RequestBody AddCourtModel newCourt) {
        try {
            AddCourtModel _newCourt = addCourtRepository.save(new AddCourtModel(newCourt.getAddress(), newCourt.getLocation()));
            return new ResponseEntity<>(_newCourt, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
