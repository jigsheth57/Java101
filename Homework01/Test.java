
public class Test {

    public static void main(String args[]) {

        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        long c = a % b;

        if (c > 15) {
            System.out.println("C is > 15!!");
        } else {
            System.out.println("c is < 15!");
        }

        System.out.println("Hello, world!");

        System.out.println("a "+"%"+" b "+" = "+c);

    }

}
