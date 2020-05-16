public class JSArrays {

    public static void main(String[] args) {
        int[] x = {1,2,3,4,5,6,7,8,9};
        String[] y = new String[3];
        y[0] = "Hi";
        y[1] = ",";
        y[2] = "My name is Jig...";
        // System.out.println(x[5]);
        // System.out.println(y[2]);

        int x_size = x.length;
        System.out.println("x_size: "+x_size);
        for (int i = 0; i<x_size; i++) {
            System.out.println("x["+i+"]: "+x[i]);
        }
        // int y_size = y.length;
        // System.out.println("y_size: " + y_size);
        // for (int i = 0; i < y_size; i++) {
        //     System.out.println("y[" + i + "]: " + y[i]);
        // }

        System.out.println("==========");
        int random_index = (int)(Math.random() * x_size);
        System.out.println("x["+ random_index+"] = "+x[random_index]);

    }
}