public class Test {
    
    public static void main(String[] args) {

        int min = 5;
        int max = 10;
        Probability test = new Probability(min, max); 
        test.setRange(min--, max--);
        System.out.println("Probability: "+test.probability());
        test.setRange(min--, max--);
        System.out.println("Probability: "+test.probability());
        test.setRange(min--, max--);
        System.out.println("Probability: "+test.probability());
    }

}