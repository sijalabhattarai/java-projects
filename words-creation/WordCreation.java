import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCreation {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter a word with random letters:");
        String letters = scanner.nextLine().toUpperCase();

        Map<Character, Integer> lettersCountMap = getCharacterCountMap(letters);

        BufferedReader reader = new BufferedReader(new FileReader("C:\\code\\java-projects\\words-creation\\dictionary.txt"));

        for (String currentWord = reader.readLine(); currentWord != null; currentWord = reader.readLine()) {
            Map<Character, Integer> currentWordMap = getCharacterCountMap(currentWord);

            boolean canMakeCurrentWord = true;
            for (Character character : currentWordMap.keySet()) {
                int currentWordCharCount = currentWordMap.get(character);
                int lettersCharCount = lettersCountMap.containsKey(character) ? lettersCountMap.get(character) : 0;

                if (currentWordCharCount > lettersCharCount) {
                    canMakeCurrentWord = false;
                    break;
                }
            }
            if (canMakeCurrentWord) {
                System.out.println(currentWord);
            }
        }
    }

    private static Map<Character, Integer> getCharacterCountMap(String letters) {
        Map<Character, Integer> letterCountMap = new HashMap<>();
        for (int i = 0; i < letters.length(); i++) {
            char currentChar = letters.charAt(i);

            int count = letterCountMap.containsKey(currentChar) ? letterCountMap.get(currentChar) : 0;

            letterCountMap.put(currentChar, count + 1);
        }
        return letterCountMap;
    }
}

