package com.courtsearch.courtsearchspringbackend.repository;

import com.courtsearch.courtsearchspringbackend.model.AddCourtModel;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddCourtRepository extends MongoRepository<AddCourtModel, String> {
    
}
