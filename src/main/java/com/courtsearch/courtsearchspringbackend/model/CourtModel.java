package com.courtsearch.courtsearchspringbackend.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * MongoDB document model to represent a court on the map
 * @author Eli Mills
 */
@Document(collection = "courts")
public class CourtModel {

    @Id
    private String id;

    @Field
    private String address;

    @Field
    private GeoJsonPoint location;

    /**
     * Default constructor
     */
    public CourtModel() {}

    /**
     * Constructor for court on the map
     * @param address The address of the court
     * @param location GeoJsonPoint object which includes coordinates of the court
     */
    public CourtModel(String address, GeoJsonPoint location) {
        this.address = address;
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public GeoJsonPoint getLocation() {
        return location;
    }

    public void setLocation(GeoJsonPoint location) {
        this.location = location;
    }

    /**
     * String format is: Court[id, address, location]
     */
    @Override
    public String toString() {
        List<Double> coords = location.getCoordinates();
        return String.format("Court[id=%s,address=%s,location={type: %s, coordinates: [%f, %f]]}",
                                id, address, location.getType(), coords.get(0), coords.get(1));

    }

}