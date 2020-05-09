public class LoopTest {
    public static void main(String[] args) {
        
        for(int x = 10; (x >= 1 && x <=10); x-- ) {
            System.out.println("x = "+x);
        }
        int x = 10;
        while((x >= 1 && x <=10)) {
            System.out.println("x = "+x);
            x--;
        }

        int y = 10;
        do {
            System.out.println("y = "+y);
            y--;
        } while(y >= 1 && y <= 10);
    }
}