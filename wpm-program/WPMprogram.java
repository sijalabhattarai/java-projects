import java.util.Random;
import java.util.Scanner;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

public class WPMprogram {
	//generate random elements from string array
	static String[] words ={"envelope", "fantastic", "wrong", "polymorphism", "okay", "top", "incredible", "sijala", "kotlin","biscuit", "interrupt"};

	public static void main(String[] agrs) throws InterruptedException {
	   System.out.println("3");
	   TimeUnit.SECONDS.sleep(1); //countdown

	   System.out.println("2");
	   TimeUnit.SECONDS.sleep(1);

	   System.out.println("1");
	   TimeUnit.SECONDS.sleep(1);

	   //random number generate
	   Random rand = new Random();
	   for(int i=0; i<10; i++){
           System.out.print(words[rand.nextInt(10)] + " ");//getting random elements from words array
	   }
	   System.out.println();

	   double start = LocalTime.now().toNanoOfDay();

	   Scanner scan = new Scanner(System.in);
	   String typedWords = scan.nextLine(); //print user's typed words in next line

	   double end = LocalTime.now().toNanoOfDay();
	   double elapsedTime= end - start;
	   double seconds = elapsedTime / 1000000000.0; //to get exact seconds
	   int numChars = typedWords.length();//num of character of user
	   //words for minute formula- (x characters/5) / 1min =y WPM
	   int wpm = (int)((((double) numChars / 5) / seconds) *60);

	   System.out.println("Your WPM is " + wpm + "!");
	}
}