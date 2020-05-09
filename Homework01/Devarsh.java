public class Devarsh {
    public static void main(String args[]) {

        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        String math = args[2];

        double add = (a + b);
        double sub = a - b;
        double mul = a * b;
        double division = a / b;
        int quotient = (int) (a / b);
        int reminder = (int) (a % b);

        System.out.println("Hello. world!");
        System.out.println("A = " + a);
        System.out.println("B = " + b);
        if (math.equals("+")) {
            System.out.println("Addition of A and B is " + add);
        } else if (math.equals("-")) {
            System.out.println("Subtraction of A and B is " + sub);
        } else if (math.equals("*")) {
            System.out.println("Multiplication of A and B is " + mul);
        } else if (math.equals("/")) {
            System.out.println("Division of A and B is " + division + " to be specific the quotient is " + quotient
                    + " and the reminder is " + reminder);
        } else {
            System.out.println("Please use valid symbols");
        }

    }

}