package com.courtsearch.courtsearchspringbackend.repository;

import com.courtsearch.courtsearchspringbackend.model.AddCourtModel;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/** 
 * Repository interface for new courts to be potentially added to map
 * @author Eli Mills
 */
@Repository
public interface AddCourtRepository extends MongoRepository<AddCourtModel, String> {
    
}
