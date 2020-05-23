public class Number2Guess {
    int min = 1;
    int max = 10;
    int correctNumber = (int) (Math.random() * (max - min + 1) + min);
    public int getCorrectNumber() {
        return correctNumber;
    }
	public boolean checkNumber(int userGuess) {
		return false;
	}
}