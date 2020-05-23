import java.util.Scanner;

public class RsGuessNumber {


    public static void main(String[] args) {
        GuesstheNumber gtn = new GuesstheNumber(10);
        Probability prob = new Probability(0 , 10);

        int max = 10;
        int min = 0;

        Scanner Guess = new Scanner(System.in);

        boolean correct = false;


        System.out.println("This is a guess a number game the has a range from 0 - 10");

        do {

            System.out.println("The Probability of you getting this right is ...  " + prob.probability());
            prob.setRange(min, max--);

            System.out.println("\nEnter your Guess: ");

            int userGuess = Guess.nextInt();

            System.out.println("Your Guess is " + userGuess);

            correct = gtn.checkNumber(userGuess);

            if (correct) {

                System.out.println("You guessed it right!");
            }

            else {

                System.out.println("" + gtn.higherOrLower(userGuess));

            }

        } while (!correct);

        Guess.close();

    }

}