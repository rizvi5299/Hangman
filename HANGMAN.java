import java.util.Scanner;
import java.util.Random;

public class HANGMAN {
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);
    public static final String[] hardWords = {"exquisite", "phenomenal", "zephyr", "quixotic",  "serendipity", "onomatopoeia", "sphygmomanometer", "flabbergasted", "perpendicular"};
    public static final String[] mediumWords = {"sphynx","mnemonic","computer", "elephant", "guitar", "jungle","piano", "library", "rocket", "adventure", "mexico"};
    public static final String[] easyWords = {"mountain","house", "chair", "tree","game", "table","food", "school", "tire", "fire", "canada", "america","ocean" };

    public void hangmangame(String[] words, int GuessesLeft, String difficutly){
        System.out.printf("Starting %s Game Mode! You have %d guesses to guess the word.\n", difficutly, GuessesLeft);
        int randomIndex = random.nextInt(words.length);  //get a random index of easywords
        String randomWord = words[randomIndex];  //retrieve the word of that random index of easywords
        String hidden = "";
        for (int i = 0; i < randomWord.length(); i++) {
            hidden += "-";
        }
        System.out.println("This is your hidden word: " + hidden + ". Guess letter by letter to uncover the word.");
        System.out.println("Guesses left: " + GuessesLeft + ". Guess a letter: ");

        // Variables to keep track of guessed letters and correct guesses
        StringBuilder guessedLetters = new StringBuilder();
        int correctGuesses = 0;

        while (GuessesLeft > 0) {
            String guess = scanner.nextLine().toLowerCase(); // Read user input and convert to lowercase

            // Check if the guess is a single letter
            if (guess.length() != 1 || !Character.isLetter(guess.charAt(0))) {
                System.out.print("Please enter a single letter. ");
                continue; // Restart the loop
            }

            char letter = guess.charAt(0); // Get the guessed letter

            // Check if the letter has already been guessed
            if (guessedLetters.toString().contains(String.valueOf(letter))) {
                System.out.print("You have already guessed that letter. Guess another one. ");
                continue; // Restart the loop
            }

            // Add the guessed letter to the list of guessed letters
            guessedLetters.append(letter);

            // Check if the guessed letter is in the random word
            boolean found = false;
            for (int i = 0; i < randomWord.length(); i++) {
                if (randomWord.charAt(i) == letter) {
                    hidden = hidden.substring(0, i) + letter + hidden.substring(i + 1);
                    found = true;
                    correctGuesses++;

                }
            }

            // Update and display the hidden word
            System.out.println("Current word: " + hidden);

            // Check if the user has guessed all letters
            if (correctGuesses == randomWord.length()) {
                System.out.println("Congratulations! You guessed the word '" + randomWord + "'.");
                break; // Exit the loop
            }

            // Decrement the number of guesses left if the letter was not found
            if (!found) {
                GuessesLeft--;
                System.out.print("Incorrect guess, try again. Guesses left: " + GuessesLeft + " ");
            }

            // Check if the user has run out of guesses
            if (GuessesLeft == 0) {
                System.out.println("You ran out of guesses. The word was '" + randomWord + "'.");
            } else {
                System.out.print(" Guess another letter: ");
            }
        }
    }



}
