public class GuessTheNumber {
    private int CorrectNumber;

    //public GuessTheNumber() {}

    public GuessTheNumber(int range) {
        generateRandomNumber(range);
    }
public int getCorrectNumber(){
    return CorrectNumber;
}
public int generateRandomNumber(int range){
    CorrectNumber= (int) (Math.random() * range);
return CorrectNumber;

}
 public boolean checkNumber(int value){
return  (CorrectNumber== value)? true: false;
 }
 public String higherOrLower(int value){
    return  (CorrectNumber>value)? "Lower": "Higher";
 }

 
}