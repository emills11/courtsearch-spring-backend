package com.courtsearch.courtsearchspringbackend.repository;

import java.util.List;

import com.courtsearch.courtsearchspringbackend.model.KeyModel;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface KeyRepository extends MongoRepository<KeyModel, String> {
    
    @Query("{ 'type' : ?0 }")
    List<KeyModel> findByKeyType(String type);

}
