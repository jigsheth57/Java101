package com.example;

public class GuessDistance {

    public static void main(String[] args) {
        USCities cities = new USCities();
        try {
            // ArrayList<City> usCities = cities.getUSCities();
            // System.out.println("Total cities: "+usCities.size());
            System.out.println(cities);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}