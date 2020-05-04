import java.util.ArrayDeque;
import java.util.Iterator;

public class AdvExpression {
    public static void main(String[] args) {
        String expression = "11-22*4+23*2";
        ArrayDeque<String> signs = new ArrayDeque<String>();
        ArrayDeque<Integer> numbers = new ArrayDeque<Integer>();

        String holdNumbers = "";
        for (int i = 0; i < expression.length(); i++) {
            char tempChar = expression.charAt(i);

            if (tempChar == '+' || tempChar == '-' || tempChar == '*' ) {
                signs.push(String.valueOf(tempChar));
                numbers.push(Integer.parseInt(holdNumbers));   
                holdNumbers = "";         
            } else {
                holdNumbers += tempChar;
            }
        }
        numbers.push(Integer.parseInt(holdNumbers));

        Iterator<String> iterSign = signs.iterator();

        System.out.println("Sign stack:");
        while (iterSign.hasNext()) {
            System.out.println(iterSign.next());
        }

        Iterator<Integer>iterNum = numbers.iterator();
        System.out.println("Number stack:");
        while (iterNum.hasNext()) {
            System.out.println(iterNum.next());
        }

        int runningTotal  = 0;
        iterSign = signs.iterator();
        ArrayDeque<String> signsTemp = new ArrayDeque<String>();
        ArrayDeque<Integer> numbersTemp = new ArrayDeque<Integer>();

        while (iterSign.hasNext()) {
            String op = (String) iterSign.next();
            if(op.equals("*")) {
                Integer a1 = (Integer) numbers.pop();
                Integer a2 = (Integer) numbers.pop();
                runningTotal = a2.intValue() * a1.intValue();
                System.out.println("a1: "+a1);
                System.out.println("a2: "+a2);
                System.out.println("runningTotal: "+runningTotal);
            } else {
                signsTemp.push(op);
                if(!numbers.isEmpty()) {
                    numbersTemp.push(numbers.pop());
                }
                
            }
        }

        iterSign = signsTemp.iterator();
        while (iterSign.hasNext()) {
            String op = (String) iterSign.next();
            if(!numbersTemp.isEmpty()) {
                Integer a1 = (Integer) numbersTemp.pop();
                if (op.equals("+")) {
                    runningTotal = runningTotal + a1.intValue();
                } else {
                    runningTotal = runningTotal - a1.intValue();
                }
            }                
        }

        System.out.println("Expression: "+expression);
        System.out.println("Total = "+runningTotal);

    }
}