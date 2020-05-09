import java.util.Scanner;

public class Kcalculator {


  public static void main(String[] args){

  Scanner no = new scanner(System.in);
  System.out.println("Input the first number: ");
 int A  = no.nextInt();
 System.out.println(" input the second number: ");
 int B = no.nextInt();
  int sum = A + B;
   int minus = A - B;
   int multiply = A * B;
   int divide =  A / B ;
   



   System.out.println( "result is " +sum);
   System.out.println( "result  is " +minus);
   System.out.println( "result  is " +multiply);
   System.out.println( "result  is  " +divide);



  }
}