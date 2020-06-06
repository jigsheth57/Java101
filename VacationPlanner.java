import java.util.Scanner;

public class VacationPlanner {
    

    public static void main(String[] args) {
        
        Scanner scanObject = new Scanner(System.in);
        // Intro
        System.out.println("Welcome to your vaction planner!!"); 
        System.out.println("Using this you will be able to calculate the average cost of your trip based on the city of your choice!!");
        System.out.println("To make this app run quicker you will need to answer some basic questions before we begin.");
        // Basic information
        char city;
        double planeTicketCost = 0;
        double hotelCost = 0;
        double rentalCarCost = 0;
        System.out.print("How many days do you plan on staying?");
        int days = scanObject.nextInt();
        int nights = days - 1;
        System.out.println("How many people will be going on this trip in total?");
        int people = scanObject.nextInt();
        System.out.println("You are starting off in Illinois. They cities you may choose to visit are New York, Los Angeles, and Miami.");
        System.out.print("Type in the city you would like to visit(N for NY, L for LA, M for Miami)");
        city = scanObject.next().charAt(0);
        // Plane ticket cost(Saloni)
        switch (city) {
            case 'L': planeTicketCost = 200 * people;
                break;
            case 'M': planeTicketCost = 130 * people;
                break;
            case 'N' : planeTicketCost = 99 * people;
        }
        System.out.println("It will cost on average about $" + planeTicketCost + " for " + people + " people.");
        // Hotel cost(Samay)
        System.out.print("Will you be staying at a hotel during your visit?(y/n)");
        String hotel = scanObject.next();
        if (hotel.matches("(\\d+|y|Y|yes|Yes|YES|Yeah|yeah|YEAH|yep|Yep|YEP|ok|OK)")) {
            switch (city) {
                case 'L': hotelCost = 260.27 * nights;
                    break;
                case 'M': hotelCost = 109 * nights;
                    break;
                case 'N' : hotelCost = 260.27 * nights;
            }
            System.out.println("It will cost on average about $" + hotelCost + " to stay at a hotel for " + nights + " nights.");
        }else {
            hotelCost = 0;
        }
        // Rental car cost(Sayan)
        System.out.print("Will you be needing a rental car during your stay?(y/n)");            
        String rental = scanObject.next();
        if (rental.matches("(\\d+|y|Y|yes|Yes|YES|Yeah|yeah|YEAH|yep|Yep|YEP|ok|OK)")) {
            switch (city) {
                case 'L': rentalCarCost = 22 * days;
                    break;
                case 'M': rentalCarCost = 16 * days;
                    break;
                case 'N' : rentalCarCost = 23 * days;
            }
            rentalCarCost = rentalCarCost * days;
            System.out.println("It will cost on average about $" + rentalCarCost + " to rent a car for " + days + " days.");
        }else {
            rentalCarCost = 0;
        }
        // Spending money
        System.out.println("You will most likely need extra money to spend per day for other needs such as food.");
        System.out.print("How much money would you like to spend per day on average?(This will be the amount split between everyone going on the trip)");
        double totalSpendingMoney = scanObject.nextInt();

        //Total trip cost
        double totalTripCost;
        totalTripCost = planeTicketCost + hotelCost + rentalCarCost + totalSpendingMoney;

        System.out.println("The average cost of your trip would be about $" + totalTripCost);
        System.out.println("The real cost of your trip may be higher or lower than the average that has been given.");

        scanObject.close();
    }
}