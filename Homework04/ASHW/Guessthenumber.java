public class Guessthenumber {
    private int correctnumber;

    public Guessthenumber() {
    }

    public Guessthenumber(int range) {
        generateRandomNumber(range);

    }

    public int getthecorrectnumber() {
        return correctnumber;
    }

    public int generateRandomNumber(int range) {
        correctnumber = (int) (Math.random() * range);
        return correctnumber;
    }

    public boolean checknumber(int value) {
        return (correctnumber == value) ? true : false;
    }

    public Object booleancheckNumber(int value) {
        return (correctnumber > value)
                ? "The number you chose is lower"
                : "The number you chose is higher";

    }
}