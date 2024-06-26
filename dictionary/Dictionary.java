import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Dictionary {
	public static final String DICTIONARY_FILE = "C:\\code\\java-projects\\dictionary\\dictionary.txt";
    private static Map <String, String> dictionary = new HashMap<>();

    public static void main (String [] args) {
    	loadDictionary();
    	Scanner scanner = new Scanner (System.in);

    	while (true) {
    		System.out.println("Enter a word to search:");
    		String word = scanner.nextLine().trim();

    		if(word.equalsIgnoreCase("exit")) {
    			System.out.println ("Exiting....");
    			break;
    		}

    		String definition = dictionary.get(word.toLowerCase());

    		if (definition != null) {
    			System.out.println("Definition:" + definition);
    		} else{
    			System.out.println("Word not found.");
    		}
    	}
    	scanner.close();
    }
    private static void loadDictionary() {
    	try (BufferedReader reader = new BufferedReader (new FileReader(DICTIONARY_FILE))) {
    		String line;
    		while ((line = reader.readLine()) != null){
    			String [] parts = line.split (":", 2);
                if (parts.length >= 2) {
                	String word = parts[0].trim().toLowerCase();
                	String definition = parts[1].trim();
                	dictionary.put(word, definition);
                }
    		}
    		}catch(IOException e) {
    			System.out.print("error dictionary" + e.getMessage());
    	}
    }
}