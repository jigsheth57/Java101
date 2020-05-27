import java.util.HashMap;

public class TestArray {
    
    public static void main(String[] args) {
        int[] testInt = new int[]{10,51,42,23,4,5,56,7,8,9};
        //System.out.println("5th stack: "+testInt[2]);

        for (int i=0; i<testInt.length; i++) {
            // System.out.println(i+") "+testInt[i]);
            if(9 == testInt[i]) {
                System.out.println("i) "+i);
            }
        }

        HashMap testMap = new HashMap<String,JSGuessTheNumber>();
        testMap.put("Jig", new JSGuessTheNumber(5, 10));
        testMap.put("", new JSGuessTheNumber(2, 90));

        // System.out.println(testMap.containsKey("Jig"));
        if(testMap.containsKey("Rahil")) {
            System.out.println(testMap.get("Rahil"));
        }

        // System.out.println(testMap.get("Rahil"));
    }
}