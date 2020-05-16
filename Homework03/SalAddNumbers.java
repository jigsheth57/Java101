import java.util.Scanner;

public class SalAddNumbers extends SimpleCalculator {

    public double power(char operation, double x) {
        double z = Math.pow(getRunningTotal(), x);
        setRunningTotal(z);
        return getRunningTotal();
    }
    public static void main(String[] args) {

        // SimpleCalculator simpCalc = new SimpleCalculator();
        SalAddNumbers simpCalc = new SalAddNumbers();
        Scanner scanObject = new Scanner(System.in);
        System.out.println("Welcome to your calculator!!");
        char operator;
        boolean cont = true;
        do {
            System.out.print("Pick you operation(+,-,*,/,%):");
            operator = scanObject.next().charAt(0);
            System.out.print("Input a number:");
            int a = scanObject.nextInt();
            //System.out.print("Input a number:");
            //int b = scanObject.nextInt();
            //int total = 0;
            //switch (operator) {
            //   case '+': total = a + b;
            //         break;
            //    case '-': total = a - b;
            //            break;
            //    case '*': total = a * b;
            //            break;
            //    case '/': total = a / b;
            //            break;
            //    case '^': total = (int) Math.pow(a, b);
            //}
            if(operator == '%') {
                System.out.println("Total = "+ simpCalc.power(operator, a));
            } else {
                System.out.println("Total = " + simpCalc.performOperation(operator, a));
            }
            System.out.print("Do you want to continue calculating? (y/n) ");
            String loop = scanObject.next();
            cont = loop.matches("(\\d+|y|Y|yes|Yes|YES|Yeah|yeah|YEAH|yep|Yep|YEP|ok|OK)");
            
        } while (cont);

        scanObject.close();
    }

}