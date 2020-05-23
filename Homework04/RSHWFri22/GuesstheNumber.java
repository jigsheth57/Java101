public class GuesstheNumber {
    private int RightNumber;

    public GuesstheNumber() {
    }

    public GuesstheNumber(int range) {
        generateRandomNumber(range);
    }

    public int getCorrectNumber() {
        return RightNumber;
    }

    public int generateRandomNumber(int range) {
        RightNumber = (int) (Math.random() * range);
        return RightNumber;

    }

    public boolean checkNumber(int value) {
        return (RightNumber == value) ? true : false;
    }

    public String higherOrLower(int value) {
        return (RightNumber > value) ? "You Guessed too Low" : "You Guessed too High";
    }

}