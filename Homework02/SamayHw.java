

import java.util.Scanner;

public class SamayHw {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int total = 0;
        System.out.println("This is your Calculator!! ");
        System.out.print("Please Give a number (> 127): ");
        int e = scan.nextInt();
        System.out.print("Please Give a number (> 127): ");
        int f = scan.nextInt();
        char operation;
        System.out.print("Pick operation(+, -, *, /):");
        operation = scan.next().charAt(0);
        switch (operation) {
            case '+': total = e + f;
                    break;
            case '-': total = e - f;
                    break;
            case '*': total = e * f;
                    break;
            case '/': total = e / f;
                    break;      
            case '^': total = (int) Math.pow(e, f);
                    break;              
        }
        System.out.println("Answer = " + total);
        
        boolean cont = true;
        while (cont) {

            System.out.print("Please Give a number (> 127): ");
            int d = scan.nextInt();
            System.out.print("Pick operation(+, -, *, /, ^):");
            operation = scan.next().charAt(0);
            switch (operation) {
                case '+': total = total + d;
                        break;
                case '-': total = total - d;
                        break;
                case '*': total = total * d;
                        break;
                case '/': total = total / d;
                        break;      
                case '^': total = (int) Math.pow(total, d);   
                        break;          
            }
            System.out.println("Total = " + total);

        }
    
        scan.close();
            
    }
        
}

    



       