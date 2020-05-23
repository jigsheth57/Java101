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
        maxTries = (max - min) + 1;
    }

    /**
     * calculates probability that user has to guess it correctly
     * @return percentage user has chance to guess it correctly.
     */
    public double probability() {
        int[] range = getRange();
        return Double.parseDouble(String.format("%.1f", (1.0 / maxTries * 100)));
    }

    @Override
    public boolean isMatch(int userGuess) {
        boolean matched = (userGuess == getNumber2Guess()) ? true : false;
        maxTries--;
        return matched;
    } 

    public static void main(String[] args) {
        int[] range = new int[] {20,35};
        JSGuessTheNumber jsGuessTheNumber = new JSGuessTheNumber(range[MIN],range[MAX]);
        Scanner scanner = new Scanner(System.in);
        boolean matched = false;
        do {
            do {
                System.out.println("Your chance of guessing it correctly " + jsGuessTheNumber.probability() + "%!");
                System.out.println("Guess the number between "+range[MIN]+"-"+range[MAX]);
                int userGuess = scanner.nextInt();
                matched = jsGuessTheNumber.isMatch(userGuess);
            } while (!matched);
            System.out.println("Dude, you're awesome!");
            System.out.print("Do you want to play a new game? (yes/no)"); // prompt user to input yes or no
            jsGuessTheNumber = new JSGuessTheNumber(range[MIN], range[MAX]);
            jsGuessTheNumber.newNumber2Guess();
        } while (scanner.next().matches("(y|Y|yes|Yes|YES|Yeah|yeah|YEAH|yep|Yep|YEP|ok|OK)"));
        scanner.close();
    }
}