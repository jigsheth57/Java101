public class Probability {

    int[] range;

    public Probability(int min, int max) {
        setRange(min, max);
    }

    public void setRange(int min, int max) {
        range = new int[] { min, max };
    }

    public double probability() {
        double prob = Double.parseDouble(String.format("%.2f", (1 / (((double)range[1] - (double)range[0]) + 1) * 100)));
        return prob;
    }

}
