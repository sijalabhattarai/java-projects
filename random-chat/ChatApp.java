import java.util.Random;
import java.util.Scanner;

public class ChatApp {
    private static final String[] GREETINGS = {
        "Hello!",
        "Welcome!",
        "Hi!",
        "Namaskar!",
        "Darshan!"
    };
    private static final String[] RESPONSES = {
        "I'm sorry, I can't answer that.",
        "Yes.",
        "Maybe.",
        "I'm not sure."
    };
    private static final String[] CAREER_RESPONSES = {
        "Focus on your goals and success will follow.",
        "Your hard work will pay off soon.",
        "A new opportunity awaits you."
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Chatting App!");

        while (true) {
            System.out.print("You: ");
            String userMessage = scanner.nextLine().trim();

            if (userMessage.equalsIgnoreCase("exit")) {
                System.out.println("Speaker: Goodbye!");
                break;
            }

            String speakerResponse = getSpeakerResponse(userMessage);
            System.out.println("Speaker: " + speakerResponse);
        }
        scanner.close();
    }

   private static String getSpeakerResponse(String userMessage) {
    Random random = new Random();
    String lowerCaseMessage = userMessage.toLowerCase();

    if (lowerCaseMessage.contains("hi") || lowerCaseMessage.contains("hello") || lowerCaseMessage.contains("namaskar")) {
        return GREETINGS[random.nextInt(GREETINGS.length)];
    } else if (lowerCaseMessage.contains("career") || lowerCaseMessage.contains("do") || lowerCaseMessage.contains("will")) {
        return CAREER_RESPONSES[random.nextInt(CAREER_RESPONSES.length)];
    } else {
        return RESPONSES[random.nextInt(RESPONSES.length)];
    }
}

}

