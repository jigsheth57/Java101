import java.util.HashMap;

public class TestArray {
    
    public static void main(String[] args) {
        int[] testInt = new int[]{10,51,42,23,4,5,56,7,8,9};
        testInt[2] = 52;

        int[][] multiInt = new int[4][11];

        multiInt[0][0] = 1;
        multiInt[0][1] = 2;
        multiInt[1][0] = 3;
        multiInt[1][1] = 4;
        multiInt[2][0] = 5;
        multiInt[2][1] = 6;

        for(int x = 1; x <= 3; x++) {
            for(int y=1; y <= 10; y++) {
                System.out.println(x+" * "+y+" = "+(x*y));
                multiInt[x][y]=(x*y);
            }
        }

        System.out.println(multiInt);

        //System.out.println("5th stack: "+testInt[2]);

        // for (int i=9; i >=0 && i<testInt.length; i--) {
        //     if ((i % 2) == 1) {
        //         System.out.println(testInt[i]);
        //     }
        //     // System.out.println(i+") "+testInt[i]);
        //     // if(9 == testInt[i]) {
        //     //     System.out.println("i) "+i);
        //     // }
        // }

        // HashMap testMap = new HashMap<String,JSGuessTheNumber>();
        // testMap.put("Jig", new JSGuessTheNumber(5, 10));
        // testMap.put("", new JSGuessTheNumber(2, 90));

        // // System.out.println(testMap.containsKey("Jig"));
        // if(testMap.containsKey("Rahil")) {
        //     System.out.println(testMap.get("Rahil"));
        // }

        // System.out.println(testMap.get("Rahil"));
    }
}