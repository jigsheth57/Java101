package com.example;

public class USCities extends Cities {

    final static String COUNTRY = "USA";

    public USCities(boolean offline) {
        super(offline, COUNTRY);
    }

    /**
     * Set the websites URL to retrieve cities
     */
    @Override
    public String[] getWebsites() {
        // These 9 websites will be used to get the US Cities information
        String[] urls = new String[9];
        urls[0] = "https://www.latlong.net/category/cities-236-15.html";
        urls[1] = "https://www.latlong.net/category/cities-236-15-2.html";
        urls[2] = "https://www.latlong.net/category/cities-236-15-3.html";
        urls[3] = "https://www.latlong.net/category/cities-236-15-4.html";
        urls[4] = "https://www.latlong.net/category/cities-236-15-5.html";
        urls[5] = "https://www.latlong.net/category/cities-236-15-6.html";
        urls[6] = "https://www.latlong.net/category/cities-236-15-7.html";
        urls[7] = "https://www.latlong.net/category/cities-236-15-8.html";
        urls[8] = "https://www.latlong.net/category/cities-236-15-9.html";

        return urls;
    }
}