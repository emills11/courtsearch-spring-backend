package com.courtsearch.courtsearchspringbackend.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "courts")
public class CourtModel {

    @Id
    private String id;

    @Field
    private String address;

    @Field
    private GeoJsonPoint location;

    public CourtModel() {}

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

    @Override
    public String toString() {
        List<Double> coords = location.getCoordinates();
        return String.format("Court[id=%s,address=%s,location={type: %s, coordinates: [%f, %f]]}",
                                id, address, location.getType(), coords.get(0), coords.get(1));

    }

}