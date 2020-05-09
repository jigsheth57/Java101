import java.util.Scanner;

public class SalAddNumbers {

    public static void main(String[] args) {

        Scanner scanObject = new Scanner(System.in);
        System.out.println("Welcome to your calculator!!");
        char operator;
        System.out.print("Input a number:");
        int a = scanObject.nextInt();
        System.out.print("Pick you operation(+,-,*,/,^):");
        operator = scanObject.next().charAt(0);
        System.out.print("Input a number:");
        int b = scanObject.nextInt();
        int total = 0;
        switch (operator) {
            case '+': total = a + b;
                    break;
            case '-': total = a - b;
                    break;
            case '*': total = a * b;
                    break;
            case '/': total = a / b;
                    break;
            case '^': total = (int) Math.pow(a, b);
        }
        System.out.println("Total = " + total);
        boolean cont = true;
        System.out.print("Do you want to continue calculating?(y/n):");
        String loop = scanObject.next();
        cont = loop.matches("(\\d+|y|Y|yes|Yes|YES|Yeah|yeah|YEAH|yep|Yep|YEP|ok|OK)");
        while (cont) {
            System.out.print("Pick you operation(+,-,*,/,^):");
            operator = scanObject.next().charAt(0);
            System.out.print("Input a number:");
            int c = scanObject.nextInt();
            switch (operator) {
                case '+': total = total + c;
                        break;
                case '-': total = total - c;
                        break;
                case '*': total = total * c;
                        break;
                case '/': total = total / c;
                        break;
                case '^': total = (int) Math.pow(total,c);
                        break;
            }
            System.out.println("Total = " + total);
            System.out.print("Do you want to continue calculating? (y/n) ");
            String answer = scanObject.next();
            cont = answer.matches("(\\d+|y|Y|yes|Yes|YES|Yeah|yeah|YEAH|yep|Yep|YEP|ok|OK)");

        } while (cont);

        scanObject.close();
    }

}