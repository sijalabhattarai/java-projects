import java.util.Scanner;

public class Capitalizer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write a sentence:");
        String inputText = scanner.nextLine();

        String capitalizedText = capitalizeSentences(inputText);

        System.out.println("Capitalized Text:");
        System.out.println(capitalizedText);

        scanner.close();
    }

    public static String capitalizeSentences(String text) {
        StringBuilder result = new StringBuilder(text.length());

        String[] sentences = text.split("(?<=[.!?])\\s*");

        for (String sentence : sentences) {
            if (!sentence.trim().isEmpty()) {
                char firstChar = Character.toUpperCase(sentence.charAt(0));
                String capitalizedSentence = firstChar + sentence.substring(1);

                result.append(capitalizedSentence);
                result.append(" ");
            }
        }
        return result.toString().trim();
    }
}
