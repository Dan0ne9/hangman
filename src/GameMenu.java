import java.util.Scanner;

public class GameMenu {

    public void showMenu() {

        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("Добро пожаловать в игру 'Виселица'.");
        System.out.println("Меню игры виселица.");
        System.out.println("1. Запуск игры.");
        System.out.println("2. Выход из игры.");
        System.out.print("Выберите опцию: ");
        choice = sc.nextInt();

        switch (choice) {
            case 1:
                HangmanGame hangmanGame = new HangmanGame(this);
                hangmanGame.execute();
                break;
            case 2:
                System.out.println("Выход из игры");
                return;
            default:
                System.out.println("Неверный выбор. Попробуйте снова.");
            }

    }
}