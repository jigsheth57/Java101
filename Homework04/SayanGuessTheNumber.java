import java.util.Scanner;
public class SayanGuessTheNumber  {
 
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int min = 1;
        int max = 10;
        int guess;
        System.out.println("Welcome to the guess the number game!");
        int random_index = (int) (Math.random() * (max - min + 1) + min);
       
        boolean right = false;
        while (!right) {
            System.out.println("Guess a number 1-10: ");
            guess = scan.nextInt();

            if (guess == random_index) {
                right = true;
                System.out.println("Correct! Nice guess!");
            }
            else if (guess != random_index) {
                right = false;
                System.out.println("Wrong guess. Try again.");

            } 
            
        }
      
        scan.close();
    }
}