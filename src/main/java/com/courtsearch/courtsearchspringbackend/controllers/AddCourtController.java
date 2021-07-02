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

/**
 * Rest controller for interacting with add_courts collection in MongoDB
 * @author Eli Mills
 */
@CrossOrigin
@RestController
public class AddCourtController {
    
    private final AddCourtRepository addCourtRepository;

    /**
     * Constructor
     * @param addCourtRepository The repository used for accessing add_courts data
     */
    @Autowired
    public AddCourtController(AddCourtRepository addCourtRepository) {
        this.addCourtRepository = addCourtRepository;
    }

    /**
     * Takes GET requests to retrieve all documents in add_courts collection
     * @return ResponseEntity with response body and status
     */
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

    /**
     * Takes POST requests to add a new document to the add_courts collection, typically after user submits front end form
     * @param newCourt The document that will be created in add_courts
     * @return ResponseEntity with response body and status
     */
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
