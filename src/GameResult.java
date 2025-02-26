public class GameResult {
    public boolean PlayerWin(String hiddenWord){
        return !hiddenWord.contains("_");
    }

    public boolean PlayerLose(int attempts){
        return attempts <= 0;
    }

    public void printGameResult(String hiddenWord,  String randomWord, int attempts){
        if(PlayerWin(hiddenWord)){
            System.out.println("Поздравляем,вы угадали слово " + randomWord);
        } else if(PlayerLose(attempts)){
            System.out.println("Вы проиграли. Загаданное слово было: " + randomWord);
        } else {
            System.out.println("Игра продолжается...");
        }
    }
}
