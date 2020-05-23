import java.text.DecimalFormat;
import java.util.Scanner;

public class JSGuessTheNumber extends BaseGuessTheNumber {

    private int maxTries;
    /**
     * Constructor to define minimum and maximum range of numbers for user to guess.
     * 
     * @param min lower bound of range
     * @param max upper bound of range
     */
    public JSGuessTheNumber(int min, int max) {
        super(min, max);
        // set max tries user has to guess the number correct.
        maxTries = (max - min) + 1;
    }

    /**
     * calculates probability that user has to guess it correctly
     * @return percentage user has chance to guess it correctly.
     */
    public double probability() {
        double probabilityOfWinning = 1.0 / maxTries * 100;
        // Format `probabilityOfWinning` to single decimal #.#
        String probabilityOfWinningStr = new DecimalFormat("#.#").format(probabilityOfWinning);
        return Double.parseDouble(probabilityOfWinningStr);
    }

    /**
     * check to see if user's guess matches the number to guess??
     * @return true if user guess the number correct
     */
    public boolean isMatch(int userGuess) {
        boolean matched = (userGuess == getNumber2Guess()) ? true : false;
        // subtract 1 from max tries user has chance to guess it correct.
        maxTries--;
        return matched;
    } 

    public static void main(String[] args) {
        int[] range = new int[] {20,35};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Let's play game \"Guess the number\"!\n");
        do {
            JSGuessTheNumber jsGuessTheNumber = new JSGuessTheNumber(range[MIN], range[MAX]);
            boolean matched = false;
            do {
                System.out.println("Your chance of guessing it correctly " + jsGuessTheNumber.probability() + "%!");
                System.out.println("Guess the number between "+range[MIN]+" and "+range[MAX]);
                int userGuess = scanner.nextInt();
                matched = jsGuessTheNumber.isMatch(userGuess);
            } while (!matched);
            System.out.println("Dude, you're awesome!");
            System.out.print("Do you want to play a new game? (yes/no)"); // prompt user to input yes or no
        } while (scanner.next().matches("(y|Y|yes|Yes|YES|Yeah|yeah|YEAH|yep|Yep|YEP|ok|OK)"));
        scanner.close();
    }
}