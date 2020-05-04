import java.util.ArrayDeque;
import java.util.Iterator;

public class Stacks {

    public static void main(String[] args) {
        
        String response = "2+3-12+2-4";

        ArrayDeque<String> signs = new ArrayDeque<String>();
        ArrayDeque<Integer> numbers = new ArrayDeque<Integer>();

        String tempHolder = "";
        for(int idx=0; idx < response.length(); idx++) {
            char x = response.charAt(idx);
            System.out.println(x);
            if(x == '+' || x == '-') {
                if(!tempHolder.equals("")) {
                    numbers.push(Integer.parseInt(tempHolder));
                    tempHolder = "";
                }
                signs.push(Character.toString(x));
            } else {
                tempHolder += x;
            }
        }
        numbers.push(Integer.parseInt(tempHolder));

        System.out.println(signs);
        System.out.println(numbers);

        Iterator<String> signIter = signs.iterator();
        int running_total = 0;
        boolean firstTime = true;
        while(signIter.hasNext()) {
            String sign = (String)signIter.next();
            if(firstTime) {
                Integer a1 = numbers.pop();
                Integer a2 = numbers.pop();
                if (sign.equals("+")) {
                    running_total = a1 + a2;
                } else {
                    running_total = a1 - a2;
                }
                firstTime = false;
            } else {
                Integer a1 = numbers.pop();
                if (sign.equals("+")) {
                    running_total = a1 + running_total;
                } else {
                    running_total = a1 - running_total;
                }
            }
        }
        System.out.println("Expression: "+response);
        System.out.println("Total: "+running_total);

    }

    
}