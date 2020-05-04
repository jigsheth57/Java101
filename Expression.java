import java.util.ArrayDeque;
import java.util.Iterator;

public class Expression {
    public static void main(String[] args) {
        String expression = "5-4+11-3+45";
        ArrayDeque<String> signs = new ArrayDeque<String>();
        ArrayDeque<Integer> numbers = new ArrayDeque<Integer>();

        String holdNumbers = "";
        for (int i = 0; i < expression.length(); i++) {
            char tempChar = expression.charAt(i);

            if (tempChar == '+' || tempChar == '-') {
                signs.push(String.valueOf(tempChar));
                numbers.push(Integer.parseInt(holdNumbers));   
                holdNumbers = "";         
            } else {
                holdNumbers += tempChar;
            }
        }
        numbers.push(Integer.parseInt(holdNumbers));

        Iterator<String> iter = signs.iterator();

        // while (iter.hasNext()) {
        //     System.out.println(iter.next());
        // }

        // iter = numbers.iterator();
        // while (iter.hasNext()) {
        //     System.out.println(iter.next());
        // }

        boolean firstTime = true;
        int runningTotal  = 0;
        while (iter.hasNext()) {
            String op = (String) iter.next();
            if (firstTime) {
                Integer a1 = (Integer) numbers.pop();
                Integer a2 = (Integer) numbers.pop();
                if (op.equals("+")) {
                    runningTotal = a2.intValue() + a1.intValue();
                } else {
                    runningTotal = a2.intValue() - a1.intValue();
                }
                firstTime = false;
            } else {
                if(!numbers.isEmpty()) {
                    Integer a1 = (Integer) numbers.pop();
                    if (op.equals("+")) {
                        runningTotal = a1.intValue() + runningTotal;
                    } else {
                        runningTotal = a1.intValue() - runningTotal;
                    }
                    }                
            }
        }
        System.out.println("Expression: "+expression);
        System.out.println("Total = "+runningTotal);

    }
}