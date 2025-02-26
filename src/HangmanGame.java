import java.util.Scanner;

public class HangmanGame {
    private GameMenu gameMenu;
    private HangmanDrawer hangmanDrawer;

    public HangmanGame(GameMenu gameMenu) {
        this.gameMenu = gameMenu;
        this.hangmanDrawer = new HangmanDrawer();
    }

    public void execute() {

        Scanner scanner = new Scanner(System.in);

        String filePath = "words.txt";
        WordGeneration wordGeneration = new WordGeneration(filePath);
        String randomWord = wordGeneration.generateRandomWord();

        String hiddenWord = "_".repeat(randomWord.length());
        int attempts = 6;
        StringBuilder guessedLetters = new StringBuilder();


        System.out.println("Игра запущена!");
        System.out.println("Загаданное слово: " + hiddenWord);

        while (attempts > 0 && hiddenWord.contains("_")) {
            System.out.println("У вас " + attempts + " попыток!");
            hangmanDrawer.draw(attempts);
            System.out.println("Введите букву: ");
            char letter = scanner.next().toLowerCase().charAt(0);

            if (guessedLetters.toString().contains(String.valueOf(letter))) {
                System.out.println("Вы уже вводили эту букву. Попробуйте другую!");
                continue;
            }

            guessedLetters.append(letter);

            if (randomWord.contains(String.valueOf(letter))) {
                StringBuilder newHiddenWord = new StringBuilder(hiddenWord);
                for (int i = 0; i < randomWord.length(); i++) {
                    if (randomWord.charAt(i) == letter) {
                        newHiddenWord.setCharAt(i, letter);
                    }
                }
                hiddenWord = newHiddenWord.toString();
                System.out.println("Буква есть в слове: " + hiddenWord);
            } else {
                attempts--;
                System.out.println("Такой буквы нет.");
            }
        }


        GameResult resultChecker = new GameResult();
        resultChecker.printGameResult(hiddenWord, randomWord, attempts);


        System.out.println("Нажмите Enter, чтобы вернутся в меню.");
        scanner.nextLine();
        scanner.nextLine();
        gameMenu.showMenu();

    }
}
