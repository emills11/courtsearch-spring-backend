package com.courtsearch.courtsearchspringbackend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "keys")
public class KeyModel {
    
    @Id
    private String id;

    @Field
    private String type;

    @Field
    private String key;

    public KeyModel() {}

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
    
    @Override
    public String toString() {
        return String.format("key[type=%s,key=%s]", type, key);
    }
}
