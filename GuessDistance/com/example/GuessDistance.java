package com.example;

public class GuessDistance {

    /**
     * Main class to run the program
     * @param accepts arguments as String
     */
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