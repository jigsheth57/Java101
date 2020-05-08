package com.example;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public abstract class Cities {

    ArrayList<City> cities = new ArrayList<City>();

    public Cities() {
    }

    public Cities(boolean offline, String country) {
        // pre-populate U.S.A cities.
        try {
            ObjectMapper mapper = new ObjectMapper();
            if (offline) {
                // create object mapper instance
                List<City> tempcities = Arrays.asList(mapper.readValue(this.getClass().getClassLoader()
                        .getResourceAsStream("assets/" + country.toLowerCase() + "_cities.json"), City[].class));
                cities.addAll(tempcities);
            } else {
                this.getCitiesFromInternet();
                mapper.writeValue(new File("./" + country.toLowerCase() + "_cities.json"), cities);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
    }

    /**
     * Set the websites URL to retrieve cities
     */
    public abstract String[] getWebsites();

    /**
     * Pre-populates US Cities from Internet
     */
    void getCitiesFromInternet() throws Exception {
        // These websites will be used to get the Cities information
        String[] urls = getWebsites();
        int i = 0;
        do {
            Document doc = Jsoup.connect(urls[i++]).get(); // Connect to website and grab the HTML source
            Elements table = doc.select("table"); // Grab HTML table from the source
            Elements tr = table.first().getElementsByTag("tr"); // Grab all the table rows
            for (int idx = 1; idx < tr.size(); idx++) { // For each rows, grab the place name, latitude & longitude
                Elements td = tr.get(idx).getElementsByTag("td");
                City city = new City();
                city.setName(td.get(0).child(0).attr("title"));
                city.setLatitude(Double.parseDouble(td.get(1).text()));
                city.setLongitude(Double.parseDouble(td.get(2).text()));
                cities.add(city);
            }
        } while (i < urls.length);
    }

    /**
     * 
     * @return pre-populated cities from internet as ArrayList
     */
    public ArrayList<City> getCities() {
        return cities;
    }

    /**
     * Calculates distance between two cities as-the-crow-flies. It will use
     * 'haversine' formula to calculate distance. reference:
     * https://andrew.hedges.name/experiments/haversine/
     * 
     * @param start starting city
     * @param end   destination city
     * @return distance in miles.
     */
    public double calculateDistanceInMiles(City start, City end) {
        // Earth’s radius (mean radius = 6,371km / 3961 miles)
        double EARTH_RADIUS = 3961;
        double dlon = Math.toRadians(end.getLongitude()) - Math.toRadians(start.getLongitude());
        double dlat = Math.toRadians(end.getLatitude()) - Math.toRadians(start.getLatitude());
        double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(Math.toRadians(start.getLatitude()))
                * Math.cos(Math.toRadians(end.getLatitude())) * Math.pow(Math.sin(dlon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double d = EARTH_RADIUS * c;
        return d;
    }

    /**
     * @return Converts Cities as JSON String
     */
    public String toString() {
        String citiesString = "";
        ObjectMapper mapper = new ObjectMapper();
        try {
            citiesString = mapper.writeValueAsString(cities);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return citiesString;
    }    
}