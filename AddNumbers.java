import java.util.Scanner;

public class AddNumbers {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("This program adds numbers!");

        boolean cont = false;
        int total = 0;
        while (cont) {
            System.out.print("Please provide value a nunber value (< 127): ");
            int a = scan.nextInt();
            total += a; // total = total + a
            System.out.println("Total = " + total);
            System.out.print("Do you have more number to add?? (y/n) ");
            String readInput = scan.next();
            cont = readInput.matches("(\\d+|y|Y|yes|Yes|YES|Yeah|yeah|YEAH|yep|Yep|YEP|ok|OK)");
            // if (readInput.equalsIgnoreCase("y")) {
            // cont = true;
            // } else {
            // cont = false;
            // }
        }

        do {
            System.out.print("Please provide value a nunber value (< 127): ");
            int a = scan.nextInt();
            total += a; // total = total + a
            System.out.println("Total = " + total);
            System.out.print("Do you have more number to add?? (y/n) ");
            String readInput = scan.next();
            cont = readInput.matches("(\\d+|y|Y|yes|Yes|YES|Yeah|yeah|YEAH|yep|Yep|YEP|ok|OK)");
            // if (readInput.equalsIgnoreCase("y")) {
            // cont = true;
            // } else {
            // cont = false;
            // }
        } while (cont);

        for (int i = 10; (i <= 10 && i > 0); i--) {
            System.out.println("i = " + i);

        }

        System.out.println("Math.pow(3,2)" + Math.pow(3, 2));

        scan.close();
    }

}
