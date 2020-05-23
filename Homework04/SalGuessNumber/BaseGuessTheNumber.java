public class BaseGuessTheNumber {

private int number2Guess;
private int[] range;

public BaseGuessTheNumber() {}

/**
 * Constructor to define minimum and maximum range of numbers for user to guess.
 * @param min lower bound of range
 * @param max upper bound of range
 */
public BaseGuessTheNumber(int min, int max) {
    range[0] = min;
    range[1] = max;
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
    range[0] = min;
    range[1] = max;
}

/**
 * Generate new number to guess from given range of numbers.
 * @return int number to guess
 */
public int newNumber2Guess() {
    number2Guess = (int) (range[0] + (Math.random() * (range[1] - range[0])));
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
