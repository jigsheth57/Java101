package com.example;

import java.util.ArrayList;
import java.util.Scanner;

public class GuessDistance {

    public USCities cities;

    /**
     * Default constructor. populates US cities
     */
    public GuessDistance() {
        System.out.println("Please wait .... populating US Cities!");
        cities = new USCities();
    }

    /**
     * Validates is your guess is within allowable threshold (+- 10%)
     * @param guess value user guessed
     * @param actual actual distance value
     * @param threshold threshold allowed to consider close enough
     * @return true or false if you guessed it close enough
     */
    public boolean checkGuess(double guess, double actual, double threshold) {
        if (guess/actual * 100 >= (100-threshold) && guess/actual * 100 <= (100+threshold)) {
            return true;
        }
        return false;
    }

    /**
     * Picks two random cities from the pre-populated US cities list
     * @return two cities to guess distance.
     */
    public City[] getRandomTwoCities() {
        City[] guess_cities = new City[2];
        ArrayList<City> usCities = cities.getUSCities();
        int total_cities = usCities.size();
        int rand_city1 = Double.valueOf(Math.random() * total_cities).intValue();
        int rand_city2 = Double.valueOf(Math.random() * total_cities).intValue();
        guess_cities[0] = usCities.get(rand_city1);
        guess_cities[1] = usCities.get(rand_city2);

        return guess_cities;
    }

    /**
     * Calculates disctance between two cities
     * @param start starting city
     * @param end destination city
     * @return distance
     */
    public double calculateDistance(City start, City end) {
        return cities.calculateDistance(start, end);
    }

    /**
     * Main class to run the program
     * @param args accepts arguments as String
     */
    public static void main(String[] args) {
        String response = "Yeah"; // initialize default value as "Yeah"
        Scanner scan = new Scanner(System.in); // setup scanner to read user input from console
        boolean yes = true; // initialize default value as true
        System.out.println("We will be playing game call \"Guess the Distance\" between two US Cities!");
        System.out.print("Are you ready? (y/n)");
        response = scan.next(); // read user input
        yes = response.matches("(y|Y|yes|Yes|YES|Yeah|yeah|YEAH|yep|Yep|YEP|ok|OK)");
        GuessDistance gDistance = new GuessDistance();
        while(yes) {
        // if (yes) {
            try {
                City[] gCity = gDistance.getRandomTwoCities();
                System.out.println("Starting city: "+gCity[0].name);
                System.out.println("Destination city: "+gCity[1].name);
                System.out.print("How far do you think these cities are from each other in miles? ");
                double distance = scan.nextDouble();
                double actual_distance = gDistance.calculateDistance(gCity[0], gCity[1]);
                if (gDistance.checkGuess(distance,actual_distance,10)) {
                    System.out.println("\nAwsome job! You guessed it within +- 10%: "+Math.floor(distance/actual_distance*100));
                    System.out.println("\nActual distance between cities: "+String.format("%.2f", actual_distance));
                } else {
                    System.out.println("\nGood luck next time! You were off by more than 10% ...");
                    do {
                        System.out.print("\nDo you want to try to guess again?? (y/n) ");
                        response = scan.next(); // read user input
                        yes = response.matches("(y|Y|yes|Yes|YES|Yeah|yeah|YEAH|yep|Yep|YEP|ok|OK)");
                        if(yes) {
                            System.out.print("\nTry your best guess!! ");
                            distance = scan.nextDouble();
                            if (gDistance.checkGuess(distance,actual_distance,10)) {
                                System.out.println("\nAwsome job! You guessed it within +- 10%: "+Math.floor(distance/actual_distance*100));
                                yes = false;
                            } else {
                                System.out.println("\nNot bad ... Good luck next time!");
                                System.out.println("Your guess is too "+(distance > actual_distance ? "high" : "low"));
                            }
                        }
                    } while (yes);
                    System.out.println("\nActual distance between cities: "+String.format("%.2f", actual_distance));
                }
                // System.out.println(cities);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
            System.out.print("\nDo you want to try to guess again?? (y/n) ");
            response = scan.next(); // read user input
            yes = response.matches("(y|Y|yes|Yes|YES|Yeah|yeah|YEAH|yep|Yep|YEP|ok|OK)");
        }
        System.out.println("\nThanks for playing the game!");
        scan.close();
    }
}