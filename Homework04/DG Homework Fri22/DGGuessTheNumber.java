import java.util.Scanner;

public class DGGuessTheNumber {

      public static void main(String[] args) {
            GuessTheNumber gtn = new GuessTheNumber(50);
            Probability prob = new Probability(0, 50);
            // int randomNumber = gtn.generateRandomNumber(50);

            // System.out.println("The number is " + randomNumber);
            int max =50;
            int min= 0;
            Scanner guess = new Scanner(System.in);

            boolean isCorrect = false;
            
            do {
                  System.out.println(".");
                  System.out.println(".");
                  System.out.println(".");
                  System.out.println("Prob of you getting this right is " + prob.probability()+ " %");
                  prob.setRange(min, max--);
                  System.out.println("Enter your guess: ");

                  int userGuess = guess.nextInt();

                  System.out.println("Your guess is " + userGuess);

                  isCorrect = gtn.checkNumber(userGuess);
                  if (isCorrect)

                        System.out.println("Your guess is correct.");
                  else {
                        System.out.println("Your guess is " + gtn.higherOrLower(userGuess));
                  }

            } while (!isCorrect);
            guess.close();

      }

}