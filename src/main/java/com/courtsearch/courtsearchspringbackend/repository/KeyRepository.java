package com.courtsearch.courtsearchspringbackend.repository;

import java.util.List;

import com.courtsearch.courtsearchspringbackend.model.KeyModel;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

/** 
 * Repository interface for any API keys associated with the software which should be kept private
 * @author Eli Mills
 */
@Repository
public interface KeyRepository extends MongoRepository<KeyModel, String> {
    
    /**
     * Performs a read of keys in DB, filtered by parameter type
     * @param type The type of key to find, e.g. "mapbox"
     * @return A list of KeyModel objects which represent key DB documents
     */
    @Query("{ 'type' : ?0 }")
    List<KeyModel> findByKeyType(String type);

}
