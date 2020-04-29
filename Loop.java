import java.util.Scanner;

public class Loop {
    public static void main(String[] args) {
        String response = "Yeah"; // initialize default value as "Yeah"
        Scanner scan = new Scanner(System.in); // setup scanner to read user input from console
        boolean yes = true; // initialize default value as true

        // Loop until the yes is no longer true!
        while (yes) {
            System.out.print("Do you want to play a game? (yes/no)"); // prompt user to input yes or no
            response = scan.next(); // read user input
            /*
            * compare user input to match various ways user would say yes to continue otherwise exit the loop.
            */
            yes = response.matches("(y|Y|yes|Yes|YES|Yeah|yeah|YEAH|yep|Yep|YEP|ok|OK)");
        }
        // Say good bye to user and close the input stream.
        System.out.println("Thanks for playing!");
        scan.close();
    }
}