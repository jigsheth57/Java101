import java.util.Scanner;

public class JSGuessTheNumber extends BaseGuessTheNumber {

    /**
     * Constructor to define minimum and maximum range of numbers for user to guess.
     * 
     * @param min lower bound of range
     * @param max upper bound of range
     */
    public JSGuessTheNumber(int min, int max) {
        super(min, max);
    }

    public static void main(String[] args) {
        int[] range = new int[] {5,10};
        JSGuessTheNumber jsGuessTheNumber = new JSGuessTheNumber(range[0],range[1]);
        Scanner scanner = new Scanner(System.in);
        boolean matched = false;
        do {
            jsGuessTheNumber.newNumber2Guess();
            do {
                System.out.println("Guess the number between "+range[0]+":"+range[1]);
                int userGuess = scanner.nextInt();
                matched = jsGuessTheNumber.isMatch(userGuess);
            } while (!matched);
            System.out.println("Dude, you're awesome!");
            System.out.print("Do you want to play a new game? (yes/no)"); // prompt user to input yes or no
        } while (scanner.next().matches("(y|Y|yes|Yes|YES|Yeah|yeah|YEAH|yep|Yep|YEP|ok|OK)"));
        scanner.close();
    }
}