package com.example;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class USCities {

    private ArrayList<City> usCities = new ArrayList<City>();

    /**
     * Default constructor.
     */
    public USCities() {
        // pre-populate us cities.
        try {
            this.getCitiesFromInternet();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    /**
     * Pre-populates US Cities from Internet
     */
    private void getCitiesFromInternet() throws Exception {
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

        int i = 0;
        do {
            Document doc = Jsoup.connect(urls[i++]).get(); // Connect to website and grab the HTML source
            Elements table = doc.select("table"); // Grab HTML table from the source
            Elements tr = table.first().getElementsByTag("tr"); // Grab all the table rows
            for (int idx = 1; idx < tr.size(); idx++) {   // For each rows, grab the place name, latitude & longitude
                Elements td = tr.get(idx).getElementsByTag("td");
                City city = new City();
                city.name = td.get(0).child(0).attr("title");
                city.latitude = Double.parseDouble(td.get(1).text());
                city.longitude = Double.parseDouble(td.get(2).text());
                usCities.add(city);
            }
        } while (i < urls.length);
    }

    /**
     * 
     * @return pre-populated us cities from internet as ArrayList
     */
    public ArrayList<City> getUSCities() {
        return usCities;
    }

    /**
     * @return Converts USCities as JSON String
     */
    public String toString() {
        StringBuffer sbuff = new StringBuffer("[");
        for (int idx = 0; idx < usCities.size(); idx++) {
            sbuff.append(usCities.get(idx));
            if (idx < usCities.size()-1) {
                sbuff.append(",");
            }
        }
        sbuff.append("]");
        return sbuff.toString();
    }
}