package com.example;

import java.util.ArrayList;
import java.util.Scanner;

public class GuessDistance {

    /**
     * Uses following website to populate cities https://www.latlong.net/countries.html
     */
    private Cities cities;

    /**
     * Retrieve list of cities
     * @return Cities 
     */
    public Cities getCities() {
        return cities;
    }

    /**
     * Set list of cities
     * @param cities holds list of cities
     */
    public void setCities(Cities cities) {
        this.cities = cities;
    }

    /**
     * Validates is your guess is within allowable threshold (+- 10%)
     * 
     * @param guess     value user guessed
     * @param actual    actual distance value
     * @param threshold threshold allowed to consider close enough
     * @return true or false if you guessed it close enough
     */
    public boolean checkGuess(double guess, double actual, double threshold) {
        if (guess / actual * 100 >= (100 - threshold) && guess / actual * 100 <= (100 + threshold)) {
            return true;
        }
        return false;
    }

    /**
     * Picks two random cities from the pre-populated US cities list
     * 
     * @return two cities to guess distance.
     */
    public City[] getRandomTwoCities() {
        City[] guess_cities = new City[2];
        ArrayList<City> prefetchCities = cities.getCities();
        int total_cities = prefetchCities.size();
        int rand_city1 = Double.valueOf(Math.random() * total_cities).intValue();
        int rand_city2 = Double.valueOf(Math.random() * total_cities).intValue();
        guess_cities[0] = prefetchCities.get(rand_city1);
        guess_cities[1] = prefetchCities.get(rand_city2);

        return guess_cities;
    }

    /**
     * Calculates disctance between two cities
     * 
     * @param start starting city
     * @param end   destination city
     * @return distance
     */
    public double calculateDistance(City start, City end) {
        return cities.calculateDistanceInMiles(start, end);
    }

    /**
     * Play the game
     */
    public void play() {
        String response = "Yeah"; // initialize default value as "Yeah"
        Scanner readInput = new Scanner(System.in); // setup scanner to read user input from console
        boolean yes = true; // initialize default value as true        
        do {
            try {
                City[] gCity = getRandomTwoCities();
                System.out.println("Starting city: " + gCity[0].getName());
                System.out.println("Destination city: " + gCity[1].getName());
                System.out.print("How far do you think these cities are from each other in miles? ");
                String guess_distance = readInput.nextLine();
                String numbers = guess_distance.replaceAll("[^0-9]", "");
                double distance = Double.parseDouble(numbers);
                double actual_distance = calculateDistance(gCity[0], gCity[1]);
                if (checkGuess(distance, actual_distance, 10)) {
                    System.out.println("\nAwsome job! You guessed it within +- 10%: "
                            + Math.floor(distance / actual_distance * 100));
                    System.out.println("Actual distance between cities: " + String.format("%.2f", actual_distance));
                } else {
                    System.out.println("\nGood luck next time! You were off by more than +- 10% ...");
                    System.out.println("Hint: your guess is too " + (distance > actual_distance ? "high" : "low"));
                    do {
                        System.out.print("Do you want to try to guess the distance again?? (y/n) ");
                        response = readInput.nextLine(); // read user input
                        yes = response.matches("(\\d+|y|Y|yes|Yes|YES|Yeah|yeah|YEAH|yep|Yep|YEP|ok|OK)");
                        if (yes) {
                            System.out.print("Try your best guess!! ");
                            guess_distance = readInput.nextLine();
                            numbers = guess_distance.replaceAll("[^0-9]", "");
                            distance = Double.parseDouble(numbers);
                            if (checkGuess(distance, actual_distance, 10)) {
                                System.out.println("\nAwsome job! You guessed it within +- 10%: "
                                        + Math.floor(distance / actual_distance * 100));
                                yes = false;
                            } else {
                                System.out.println("\nNot bad ... Good luck next time!");
                                System.out
                                        .println("Hint: your guess is too " + (distance > actual_distance ? "high" : "low"));
                            }
                        }
                    } while (yes);
                    System.out.println("Actual distance between the cities: " + String.format("%.2f", actual_distance));
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
            System.out.print("\nDo you want to play again?? (y/n) ");
            response = readInput.nextLine(); // read user input
            yes = response.matches("(\\d+|y|Y|yes|Yes|YES|Yeah|yeah|YEAH|yep|Yep|YEP|ok|OK)");
        } while(yes);
        System.out.println("\nThanks for playing the game!");
        readInput.close();
    }

    /**
     * Main class to run the program
     * 
     * @param args accepts arguments as String
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); // setup scanner to read user input from console
        boolean offline = true;
        String country = "US";
        if (args.length > 0) {
            if (args[0].matches("(o|O|on|ON|online|true)")) {
                offline = false;
            }
        }
        System.out.println("Let's play a game call \"Guess the Distance\" between two Cities!");
        System.out.println("\nYou have a choice of the countries [US or India] ... Please choose a country.");
        country = scan.nextLine();
        country = country.matches("(India|india|in|IN|In)") ? "India" : "US";
        GuessDistance guessDistance = new GuessDistance();
        if(!offline) {
            System.out.println("Please wait .... populating "+country+" cities from \"https://www.latlong.net/countries.html\"!");
        }
        if (country.equalsIgnoreCase("India")) {
            guessDistance.setCities(new IndiaCities(offline));
        } else {
            guessDistance.setCities(new USCities(offline));
        }
        guessDistance.play();
        scan.close();
    }
}