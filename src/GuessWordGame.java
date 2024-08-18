import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GuessWordGame {
    public static void main(String[] args) {
        startGame();
    }

    public static void startGame() {
        int userChoice;

        showGreetingMessage();
        while (true) {
            userChoice = getUserInput("Enter 1 to start playing solo and 2 if you want to test yourself" +
                                                    " against THE GREATEST AI. Enter 0 to leave peacefully").nextInt();
            if (userChoice != 1 && userChoice != 2 && userChoice != 0) {
                System.out.println(userChoice + " is not an option...");
                continue;
            }
            if (userChoice == 0)
                break;
            String[] riddledWord = chooseWord();
            if (userChoice == 1) {
                playSolo(riddledWord);
            } else {
                playVsAI(riddledWord);
            }
        }

    }

    public static void playSolo(String[] riddledWord) {
        char[] arrayFromOriginal = riddledWord[0].toCharArray();
        char[] hiddenWord = hideOriginalArray(arrayFromOriginal);
        char[] arrayOfGuesses = new char[26];
        int numberOfUserLetters = 0;

        Arrays.fill(arrayOfGuesses, '0');
        while (true){
            System.out.println(riddledWord[1]);
            showWord(hiddenWord);
            numberOfUserLetters = doAttemptToGuess(arrayFromOriginal, hiddenWord, arrayOfGuesses, numberOfUserLetters);
            if (numberOfUserLetters == -1){
                showEndGameMessage(true);
                return;
            }
        }
    }

    public static void playVsAI(String[] riddledWord) {
        char[] arrayFromOriginal = riddledWord[0].toCharArray();
        char[] hiddenWord = hideOriginalArray(arrayFromOriginal);
        char[] arrayOfGuesses = new char[26];
        int numberOfUsedLetters = 0;

        Arrays.fill(arrayOfGuesses, '0');
        while (true){
            System.out.println(riddledWord[1]);
            showWord(hiddenWord);
            numberOfUsedLetters = doAttemptToGuess(arrayFromOriginal, hiddenWord, arrayOfGuesses, numberOfUsedLetters);
            if (numberOfUsedLetters == -1){
                showEndGameMessage(true);
                return;
            }
            numberOfUsedLetters = doAIAttempt(arrayFromOriginal, hiddenWord, arrayOfGuesses, numberOfUsedLetters);
            if (numberOfUsedLetters == -2){
                showEndGameMessage(false);
                return;
            }
        }
    }

    public static int doAIAttempt(char[] arrayFromOriginal, char[] hiddenWord, char[] arrayOfGuesses,int numberOfUsedLetters){
        int attempt = new Random().nextInt(97, 123);
        while (isEnteredBefore((char) attempt, arrayOfGuesses)){  //
            attempt = new Random().nextInt(97, 123);
        }
        System.out.println("AI thinks there is a letter: " + (char) attempt);
        arrayOfGuesses[numberOfUsedLetters] = (char) attempt;
        checkGuess(arrayFromOriginal, hiddenWord, (char) attempt);
        if(Arrays.equals(arrayFromOriginal, hiddenWord)){
            return -2;
        }
        numberOfUsedLetters++;
        return numberOfUsedLetters;
    }

    public static int doAttemptToGuess(char[] arrayFromOriginal, char[] hiddenWord, char[] arrayOfGuesses,int numberOfUserLetters){
        String userInput;
        char userGuess;

        userInput = getUserInput("Enter a letter to make a guess or enter a whole word if you ready: ").nextLine();
        if (userInput.isEmpty()) {
            System.out.println("You have to enter something to start play.");
        } else if (userInput.length() == 1) {
            userGuess = userInput.charAt(0);
            if (isEnteredBefore(userGuess, arrayOfGuesses)){
                System.out.println("This letter was entered before!");
                return numberOfUserLetters;
            }
            arrayOfGuesses[numberOfUserLetters] = userGuess;
            checkGuess(arrayFromOriginal, hiddenWord, userGuess);
            if(Arrays.equals(arrayFromOriginal, hiddenWord)){
                return -1;
            }
            numberOfUserLetters++;
            return numberOfUserLetters;
        } else {
            if (Arrays.equals(arrayFromOriginal, userInput.toCharArray())) {
                return -1;
            } else {
                System.out.println("No! The hidden word is not a " + userInput + ". Try again...");
            }
        }
        return numberOfUserLetters;
    }

    public static boolean isEnteredBefore(char userLetter, char[] arrayOfGuesses){
        for (char letter : arrayOfGuesses){
            if (letter == userLetter){
                return true;
            }
            if(letter == '0'){
                return false;
            }
        }
        return false;
    }

    public static void checkGuess(char[] arrayFromOriginal, char[] hiddenWord, char letter) {
        int guessedLetters = 0;
        for (int index = 0; index < hiddenWord.length; index++) {
            if (arrayFromOriginal[index] == letter) {
                hiddenWord[index] = letter;
                guessedLetters++;
            }
        }
        System.out.println((guessedLetters == 0) ? "There is no such letter...": "That's right, there's a letter");
    }

    public static String[] chooseWord() {
        int userChoice;
        while (true) {
            userChoice = getUserInput("Input 1 to get your own word or 2 if you want to get a random one.").nextInt();
            if (userChoice != 1 && userChoice != 2) {
                System.out.println(userChoice + " is not an option...");
            } else if (userChoice == 1) {
                return guessYourOwnWord();
            } else {
                return createHiddenWord();
            }
        }
    }

    public static String[] guessYourOwnWord() {
        String[] userWord = new String[2];
        while (true) {
            userWord[1] = "A word you've riddled";
            userWord[0] = getUserInput("Enter a word (Only lowercase letters): ").nextLine();
            if (userWord[0].isEmpty()) {
                System.out.println("You have to enter a word to start game.");
                continue;
            }
            if (isSingleWord(userWord[0])) {
                break;
            }
        }
        return userWord;
    }

    public static boolean isSingleWord(String word) {
        char[] arrayFromWord = word.toCharArray();
        for (char letter : arrayFromWord){
            if((int) letter < 97 || (int) letter > 122){
                System.out.println("Incorrect input...");
                return false;
            }
        }
        return true;
    }

    public static String[] createHiddenWord() {
        // String[i][0] - word
        // String[i][1] - its description to guess
        String[][] pullOfWordsToGuess = new String[][]{
                {"banana", "Yellow and long "},
                {"grape", " виноград)))"},
                {"apple", " iphone"}
        };
        return pullOfWordsToGuess[new Random().nextInt(0, pullOfWordsToGuess.length)];
    }

    public static Scanner getUserInput(String messageToUser) {
        System.out.println(messageToUser);
        return new Scanner(System.in);
    }

    public static void showGreetingMessage() {
        System.out.println("Welcome to Guess game...");
        System.out.println("Here's the rules:");
        System.out.println("~ You must guess a hidden word.");
        System.out.println("~ You can choose your own word or get random one.");
        System.out.println("~ You can win either by guessing letters or the whole word.");
        System.out.println("-------------------------------------------------------------------");
        System.out.println("The game has two game modes:");
        System.out.println("The first one - mode were you play on your own.");
        System.out.println("The second one - mode were you compete with THE GREATEST AI");
        System.out.println("Which one do you like to start?... ");
    }

    public static void showWord(char[] hiddenWord) {
        for (char letter : hiddenWord) {
            System.out.print("[" + letter + "]");
        }
        System.out.println();
    }

    public static char[] hideOriginalArray(char[] originalArray) {
        char[] hiddenArray = new char[originalArray.length];
        Arrays.fill(hiddenArray, '*');
        return hiddenArray;
    }
    public static void showEndGameMessage(boolean isWinner){
        if (isWinner){
            System.out.println("Congratulations! You've guessed hidden word! Sir, you’re marvellous!");
        } else {
            System.out.println("Exactly what I needed to prove...");
            System.out.println("No one can stand against THE GREATEST AI");
            System.out.println("Artificial intelligence will replace all of us soon.");
            System.out.println("*evil laughter*");
        }
    }
}