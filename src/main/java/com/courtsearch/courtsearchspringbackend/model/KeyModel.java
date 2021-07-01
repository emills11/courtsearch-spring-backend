package com.courtsearch.courtsearchspringbackend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * MongoDB document model to represent an API key used by the software
 * @author Eli Mills
 */
@Document(collection = "keys")
public class KeyModel {
    
    @Id
    private String id;

    @Field
    private String type;

    @Field
    private String key;

    /**
     * Default constructor
     */
    public KeyModel() {}

    /**
     * Constructor for API key model
     * @param type The type (association) of the key
     * @param key Value of the key itself
     */
    public KeyModel(String type, String key) {
        this.type = type;
        this.key = key;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
    
    /**
     * String format is: key[type, key]
     */
    @Override
    public String toString() {
        return String.format("key[type=%s,key=%s]", type, key);
    }
}
