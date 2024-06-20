import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame{

	public static void main(String[] args){
		generateRandom();
	}//end main method



public static void generateRandom(){
	//creating object
	int randomNum=new Random();

	//generating a random number between 0-10
	int randomNum=rand.nextInt(11);

	//calling guess method
	guess(randomNum);

}//end generateRandom method

public static void guess(int randomNum){
    //creating an object of scanner class
    Scanner in = new Scanner(System.in);

    //welcome message
    System.out.println("");
    System.out.println("Number Guessing Game");
    System.out.println("Guess a number between 0-10")
}//end guess method
}