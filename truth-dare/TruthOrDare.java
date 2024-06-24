import java.util.Random;
import java.util.Scanner;

public class TruthOrDare {
	private String[] truthForBoy = {
		"Who is your crush?",
		"What is your most embrarrasing memory?",
		"Have you ever peed on school?",
		"What's the most embarrassing thing your parents have caught you doing?"
	};

	private String [] truthForGirl = {
		"What is your worst habit?",
		"If you were a boy for a day, what's the first thing you would do?",
		"What's the funniest lie you've ever told that someone believed?",
		"What's the most embarrassing nickname you've ever had?"
	};

	private String [] dareForBoy = {
		"Dance without music.",
		"Jump like a monkey for 1 minute.",
		"Call your mom and say i am drunk.",
		"cry like a newborn baby"
	};

	private String[] dareForGirl = {
		"Sing a song",
		"Walk like a boy",
		"Put on lipstick without using a mirror",
		"Let someone style your hair however they want"
	};


public void game(String gender) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.print("What do you choose? Truth or Dare? ");
        String choice = scanner.nextLine().toLowerCase();

        if (choice.equals("truth")) {
            int index = random.nextInt(gender.equalsIgnoreCase("boy") ? truthForBoy.length : truthForGirl.length);
            System.out.println("Truth: " + (gender.equalsIgnoreCase("boy") ? truthForBoy[index] : truthForGirl[index]));
        } else if (choice.equals("dare")) {
            int index = random.nextInt(gender.equalsIgnoreCase("boy") ? dareForBoy.length : dareForGirl.length);
            System.out.println("Dare: " + (gender.equalsIgnoreCase("boy") ? dareForBoy[index] : dareForGirl[index]));
        } else {
            System.out.println("Invalid choice. Please enter 'truth' or 'dare'.");
        }

        scanner.close();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Are you a boy or a girl? ");
        String gender = scanner.nextLine().toLowerCase();

        TruthOrDare game = new TruthOrDare();
        game.game(gender);

        scanner.close();
    }
}
