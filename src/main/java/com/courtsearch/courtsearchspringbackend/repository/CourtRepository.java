package com.courtsearch.courtsearchspringbackend.repository;

import com.courtsearch.courtsearchspringbackend.model.CourtModel;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/** 
 * Repository interface for set of all courts which should appear on map
 * @author Eli Mills
 */
@Repository
public interface CourtRepository extends MongoRepository<CourtModel, String> {
    
}
