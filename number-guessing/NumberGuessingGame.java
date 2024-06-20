import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    public static void main(String[] args){
        generateRandom();
    }//end main method

    public static void generateRandom(){
        //creating object
        Random random = new Random();

        //generating a random number between 0-10
        int randomNumber = random.nextInt(11);

        //calling guess method
        guess(randomNumber);

    }//end generateRandom method

    public static void guess(int randomNumber){
        //creating an object of scanner class
        Scanner in = new Scanner(System.in);

        //welcome message
        System.out.println("");
        System.out.println("Number Guessing Game");
        System.out.println("Guess a number between 0-10");
        int guess = in.nextInt();
        System.out.println("");

        //input validation
        while (guess < 0 || guess > 10) {
            System.out.print("Guess a number between 0-10: ");
            guess = in.nextInt();
            System.out.println("");
        }

        //try again until you guess the correct number
        int tries = 0;
        while (guess != randomNumber){
            tries++;
            System.out.println("Wrong guess!");
            System.out.println("Guess Again:");
            guess = in.nextInt();
            System.out.println();
        }

        //Game won
        System.out.println("Correct guess!");
        System.out.println("Number of wrong tries: " + tries);
        System.out.println("");

        //play again or terminate
        System.out.println("Press 1 to play again.");
        System.out.println("Press 0 to exit.");
        //random method will be called again
        // get user's choice
        int choice = in.nextInt();

        // random method will be called again
        if (choice == 1)
            generateRandom();
        else
            return;
    }//end guess method
}//end class
