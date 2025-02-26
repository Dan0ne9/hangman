import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WordGeneration {
    private List<String> words;

    public WordGeneration(String filePath) {
        this.words = readWordsFromFile(filePath);
        if (words.isEmpty()){
            throw new IllegalArgumentException("Файл пуст или не найден.");
        }
    }

    private List<String> readWordsFromFile(String filePath) {
        List<String> words = new ArrayList<>();

        try(Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String word = scanner.nextLine().trim();
                if (!word.isEmpty()) {
                    words.add(word);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        }
        return words;
    }

    public String generateRandomWord() {
        Random random = new Random();
        return words.get(random.nextInt(words.size()));
    }
}
