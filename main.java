import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        HANGMAN start = new HANGMAN();
        Scanner scanner = new Scanner(System.in);
        boolean playagain = true;


        while (playagain) {
            System.out.println("Welcome to hangman! Guess the word by guessing letters at a time before your number of incorrect guesses runs left!");
            System.out.print("Choose your difficulty, 'Easy', 'Medium', or 'Hard': ");
            while (true) {
                String difficultyinput = scanner.next();
                if (difficultyinput.equalsIgnoreCase("easy")) {
                    start.hangmangame(HANGMAN.easyWords, 15, "Easy");
                    break;
                } else if (difficultyinput.equalsIgnoreCase("medium")) {
                    start.hangmangame(HANGMAN.mediumWords,15, "Medium");
                    break;
                } else if (difficultyinput.equalsIgnoreCase("hard")) {
                    start.hangmangame(HANGMAN.hardWords,14, "Hard");
                    break;
                } else System.out.print("Please only enter the difficulty: Easy, Medium, or Hard. ");
            }

            System.out.print("That was fun! Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next();
            playagain = playAgainResponse.equalsIgnoreCase("yes");
        }
        System.out.print("\nGOODBYE! See you next time :)\n");
    }
}
