import java.util.Scanner;

public class AaravCalc {

    public static void main(String[] args) {
        SimpleCalculator simpleCalc = new SimpleCalculator();

        Scanner scan = new Scanner(System.in);

        boolean sign = true;
        boolean add = true;
        boolean subtract = true;
        boolean divide = true;
        boolean multiply = true;
        double answer2 = 0;
        {

            while (sign) {
                System.out.println("Do you want to add, subtract, divide, or multiply");
                String answer;
                answer = scan.next();

                if (answer.matches("add")) {
                    while (add) {
                        System.out.println("Add something else");
                        answer2 = simpleCalc.performOperation("+", answer2);
                        System.out.println(answer2);
                        System.out.println("Do you want to multiply more numbers together? (Yes/No))");
                        String response = scan.next();
                        add = response.matches("(y|Y|yes|Yes)");
                    }
                }

                else if (answer.matches("subtract")) {
                    while (subtract) {
                        System.out.println("Provide a number for a");
                        answer2 = simpleCalc.performOperation("-", answer2);
                        System.out.println("total: "+ answer2);
                        System.out.println("Do you want to multiply more numbers together? (Yes/No))");
                        String response = scan.next();
                        subtract = response.matches("(y|Y|yes|Yes)");
                    }
                }

                else if (answer.matches("multiply")) {
                    while (multiply) {
                        System.out.println("Provide a number for a ");
                        answer2 = simpleCalc.performOperation("*", answer2);
                        System.out.println("total: "+ answer2);
                        System.out.println("Do you want to multiply more numbers together? (Yes/No))");
                        String response = scan.next();
                        multiply = response.matches("(y|Y|yes|Yes)");
                    }
                }

                else if (answer.matches("divide")) {
                    while (divide) {
                        System.out.println("Provide a number for a");
                        answer2 = simpleCalc.performOperation("/", answer2);
                        System.out.println("total: "+ answer2);
                        System.out.println("Do you want to divide more numbers together (Yes/No)3");
                        String response = scan.next();
                        divide = response.matches("(y|Y|yes|Yes)");
                    }
                }
            }

        }
        scan.close();
    }
}
