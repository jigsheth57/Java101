import java.util.Scanner;

public class Calculator {

public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    boolean operation = true;
    boolean add = true;
    boolean subtract = true;
    boolean divide = true;
    boolean multiply = true;

    double total = 0;


while (operation) {

System.out.println("This program can add, subtract, multiply, or divide numbers. Which would you like to do? (add/subtract/multiply/divide)");
String answer;
answer = scan.next();

if (answer.matches("subtract")){
    while (subtract){

        System.out.println("Please provide value to subtract to a running total." );
        
        double x = scan.nextInt();

        total -= x;

        System.out.println("Answer = " +total);

            System.out.println("Do you wanna subtract more numbers together? (Yes/No)");
            String response = scan.next();
            subtract = response.matches("(y|Y|yes|Yes|YES|Yeah|yeah|YEAH|yep|Yep|YEP|ok|OK|\\d+)");
        
        
        }
}

else if (answer.matches("add")){

        while (add){
        
        System.out.println("Please provide value for x" );
        
        double x = scan.nextInt();
        
        total += x;

        System.out.println("Answer = " +total);
        
        
            System.out.println("Do you wanna add more numbers together? (Yes/No)");
            String response = scan.next();
            add = response.matches("(y|Y|yes|Yes|YES|Yeah|yeah|YEAH|yep|Yep|YEP|ok|OK|\\d+)");
        }

}

else if (answer.matches("multiply")){
    while (multiply){

        System.out.println("Please provide value for x" );
        
        double x = scan.nextInt();
        
        total *= x;

        System.out.println("Answer = " +total);
        
        
            System.out.println("Do you wanna multiply more numbers together? (Yes/No)");
            String response = scan.next();
            multiply = response.matches("(y|Y|yes|Yes|YES|Yeah|yeah|YEAH|yep|Yep|YEP|ok|OK|\\d+)");
            
        }

}

else if (answer.matches("divide")){

    while (divide){

        System.out.println("Please provide value for x" );
        
        double x = scan.nextInt();
        
        total /= x;

        System.out.println("Answer = " +total);
        
        
            System.out.println("Do you wanna divide more numbers together? (Yes/No)");
            String response = scan.next();
            divide = response.matches("(y|Y|yes|Yes|YES|Yeah|yeah|YEAH|yep|Yep|YEP|ok|OK|\\d+)");
        
        
        }
}













    }

    scan.close();

}

}

