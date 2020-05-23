public class BaseGuessTheNumber {

    private int number2Guess;
    private int[] range;
    public static final int MIN = 0;
    public static final int MAX = 1;


    /**
     * Constructor to define minimum and maximum range of numbers for user to guess.
     * @param min lower bound of range
     * @param max upper bound of range
     */
    public BaseGuessTheNumber(int min, int max) {
        setRange(min, max);
        newNumber2Guess();
    }

    /**
     * Get the value of current number to guess
     * @return int number to guess by user
     */
    public int getNumber2Guess() {
        return number2Guess;
    }

    /**
     * set the range of number to guess
     * @param min lower bound of range
     * @param max upper bound of range
     */
    public void setRange(int min, int max) {
        range = new int[] { min, max };
    }

    /**
     * return range value
     * @return int[] of range value
     */
    public int[] getRange() {
        return range;
    }
    /**
     * Generate new number to guess from given range of numbers.
     * @return int number to guess
     */
    public int newNumber2Guess() {
        number2Guess = range[MIN] + (int)(Math.random() * ((range[MAX] - range[MIN])+1));
        return number2Guess;
    }

    /**
     * Check to see if user guess matches number to guess.
     * @param userGuess int value of user's guess
     * @return boolean true or false if user guess matches the number to guess.
     */
    public boolean isMatch(int userGuess) {
        return (userGuess == number2Guess) ? true : false;
    }
}