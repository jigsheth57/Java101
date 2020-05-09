import java.util.Scanner;

public class SayanHW02 {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Caclculator");

        System.out.println("Enter a number ");
        int a = scan.nextInt();
        System.out.println("Enter a number ");
        int b = scan.nextInt();
        char op;
        int answer = 0;
        System.out.println("Pick an operation: +, -, *, /, ^");
        op = scan.next().charAt(0);
        switch(op) {
            case '+' : answer = a + b;
                break;
            case '-' : answer = a - b;
                break;
            case '*' : answer = a * b;
                break;
            case '/' : answer = a / b;
                break;
            case '^' : answer = (int) Math.pow(a,b);
                break;
        }
        System.out.println("Answer = " + answer);
        boolean cont = true;
        System.out.println("Continue? (y/n)");
            String input = scan.next();
            cont = input.matches("\\d+|y|Y|n|N");
        while (cont) {
            System.out.println("Enter a number ");
            int c = scan.nextInt();
            System.out.println("Pick your operation: +, -, *, /, ^");

            op = scan.next().charAt(0);
            switch(op) {
                case '+' : answer = answer + c;
                    break;
                case '-' : answer = answer - c;
                    break;
                case '*' : answer = answer * c;
                    break;
                case '/' : answer = answer / c;
                    break;
                case '^' : answer = (int) Math.pow(answer,c);
                    break;

            }

            System.out.println("Answer = " + answer);

            System.out.println("Continue? (y/n)");
            String readInput = scan.next();
            cont = readInput.matches("\\d+|y|Y");
   
        }
       while(cont);

        
        scan.close();
    }
}