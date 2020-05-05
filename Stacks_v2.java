import java.util.*;

public class Stacks_v2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        /* Create stacks for operators and operands */
        Stack<Integer> op = new Stack<Integer>();
        Stack<Double> val = new Stack<Double>();
        /* Create temporary stacks for operators and operands */
        Stack<Integer> optmp = new Stack<Integer>();
        Stack<Double> valtmp = new Stack<Double>();
        /* Accept expression */
        System.out.println("Evaluation Of Arithmetic Expression Using Stacks Test\n");
        System.out.println("Enter expression\n");
        String input = scan.nextLine(); // read line from console
        input = input.replaceAll(" ", ""); // remove all spaces
        input = input.replaceAll("-", "+-"); // replace all subtraction(-) with addtion w/ negative nnumber(+-)
        /* Store operands and operators in respective stacks */
        String temp = "";
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '-')
                temp = "-" + temp;
            else if (ch != '+' && ch != '*' && ch != '/')
                temp = temp + ch;
            else {
                val.push(Double.parseDouble(temp));
                op.push((int) ch);
                temp = "";
            }
        }
        val.push(Double.parseDouble(temp));

        System.out.println("Value stack: "+val);
        System.out.println("Operators stack: "+op);

        char operators[] = { '/', '*', '+' }; // Order of operators

        for (int i = 0; i < 3; i++) {
            boolean it = false;
            // loop if Operators stack is not empty
            while (!op.isEmpty()) {
                int optr = op.pop();
                double v1 = val.pop();
                double v2 = val.pop();
                if (optr == operators[i]) {
                    // if operator matches evaluate and store in temporary stack
                    if (i == 0) {
                        valtmp.push(v2 / v1);
                        it = true;
                        break;
                    } else if (i == 1) {
                        valtmp.push(v2 * v1);
                        it = true;
                        break;
                    } else if (i == 2) {
                        valtmp.push(v2 + v1);
                        it = true;
                        break;
                    }
                } else {
                    // hold first value in temporary stack
                    valtmp.push(v1);
                    // put back the second value back in stack
                    val.push(v2);
                    // if the operator is not in order, put it temporary stack
                    optmp.push(optr);
                }
            }
            // Push back all elements from temporary stacks to main stacks
            while (!valtmp.isEmpty())
                val.push(valtmp.pop());
            while (!optmp.isEmpty())
                op.push(optmp.pop());
            // Iterate again for same operator
            if (it)
                i--;
        }
        System.out.println("\nResult = " + val.pop());        
    }
}