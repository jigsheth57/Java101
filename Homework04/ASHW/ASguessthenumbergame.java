import java.util.Scanner;

public class ASguessthenumbergame {

    public static void main(String[] args) {
        Guessthenumber gtn = new Guessthenumber();
        Prob prob = new Prob(0, 5);

        int max = 5;
        int min = 0;

        Scanner guess = new Scanner(System.in);
        boolean correct = false;
        do {
            System.out.println("The Probability of you getting this right was ...  " + prob.probability());
            prob.setRange(min, max--);
            System.out.println("Whats you guess bwtween 1-5:");
            int user = guess.nextInt();
            System.out.println("Your guess is " + user);

            correct = gtn.checknumber(user);
            if (correct)
                System.out.println("Nice job you got it right");
            else {
                System.out.println(gtn.booleancheckNumber(user));
            }
        } while (!correct);
        guess.close();
    }
}