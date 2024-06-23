import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class WordCreation {
	public static void main (String[] args) throws FileNotFoundException, IOException {
		BufferedReader reader = new BufferedReader(new FileReader("C:\\code\\java-projects\\words-creation\\dictionary.txt"));

		for (String currentWord = reader.readLine(); currentWord != null; currentWord = reader.readLine()){
            System.out.println(currentWord);
		}
	}
}