public class Probability {

    int[] range;

    public Probability(int min, int max) {
        setRange(min, max);
    }

    public void setRange(int min, int max) {
        range = new int[] { min, max };
    }

    public double probability() {
        return Double.parseDouble(String.format("%.3f", (1.0 / ((double)range[1] - (double)range[0] + 1.0) * 100)));
    }
    
}