package com.example;

public class City {

    /**
     * holds name of a city.
     */
    String name;

    /**
     * holds latitude value of a city in radian
     */
    double latitude;

    /**
     * holds longitude value of a city in radian
     */
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
    /**
     * converts City object as JSON String
     */
    public String toString() {
        StringBuffer sbuf = new StringBuffer();
        sbuf.append("{\"name\":\"").append(name).append("\",");
        sbuf.append("\"latitude\":\"").append(latitude).append("\",");
        sbuf.append("\"longitude\":\"").append(longitude).append("\"}");
        return sbuf.toString();
    }
}