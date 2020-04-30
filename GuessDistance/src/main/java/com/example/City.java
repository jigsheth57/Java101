package com.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class City {

    /**
     * holds name of a city.
     */
    @JsonProperty(value="name")
    String name;

    /**
     * holds latitude value of a city in radian
     */
    @JsonProperty(value="latitude")
    double latitude;

    /**
     * holds longitude value of a city in radian
     */
    @JsonProperty(value="longitude")
    double longitude;

    /**
     * Default constructor
     */
    public City () {}

    /**
     * Assigns name, latitude and longitude during creation.
     * @param name name of the city
     * @param latitude latitude value in degree for the city
     * @param longitude longitude value in degree for the city
     */
    public City (String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}