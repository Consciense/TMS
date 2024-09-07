/**
 * Задача 1:
 * <p>
 * 1. Ввести 3 строки с консоли, найти самую короткую и самую длинную строки. Вывести
 * найденные строки и их длину.
 * <p>
 * 2. Ввести 3 строки с консоли. Упорядочить и вывести строки в порядке возрастания
 * значений их длины.
 * <p>
 * 3. Ввести 3 строки с консоли. Вывести на консоль те строки, длина которых меньше
 * средней, а также их длину.
 * <p>
 * 4. Ввести 3 строки с консоли. Найти слово, состоящее только из различных символов.
 * Если таких слов несколько, найти первое из них.
 * <p>
 * 5. Вывести на консоль новую строку, которой задублирована каждая буква из
 * начальной строки. Например, "Hello" -> "HHeelllloo".
 * <p>
 * Задача *:
 * Дана строка произвольной длины с произвольными словами. Написать программу для
 * проверки является ли любое выбранное слово в строке палиндромом.
 * <p>
 * Например, есть строка, вводится число 3, значит необходимо проверить является ли 3-е
 * слово в этой строке палиндромом.
 * Предусмотреть предупреждающие сообщения на случаи ошибочных ситуаций: например,
 * в строке 5 слов, а на вход программе передали число 500.
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("First of all you gotta input 3 strings for tasks 1 - 4, " +
                "since we are to lazy to input it 4 times ");
        String[] arrayOfStrings = new String[]{
                StringOperations.getUserInput("Input your 1'st string: ").nextLine(),
                StringOperations.getUserInput("Input your 2'nd string: ").nextLine(),
                StringOperations.getUserInput("Input your 3'rd string: ").nextLine()
        };
        // or we can skip inputting them =)
//        String[] arrayOfStrings = new String[]{
//                "Your 1'st string (short)",
//                "Your 2'nd string (long one)",
//                "Your 3'rd string (middle)",
//        };
        System.out.println("Your strings are:");
        StringOperations.showArrayOfStrings(arrayOfStrings);
        System.out.println("------------------------------------------------");
        System.out.println("Starting task 1:");
        solveTask1(arrayOfStrings);
        System.out.println("------------------------------------------------");
        System.out.println("Starting task 2:");
        solveTask2(arrayOfStrings);
        System.out.println("------------------------------------------------");
        System.out.println("Starting task 3:");
        solveTask3(arrayOfStrings);
        System.out.println("------------------------------------------------");
        System.out.println("Starting task 4:");
        solveTask4(arrayOfStrings);
        System.out.println("------------------------------------------------");
        System.out.println("Starting task 5:");
        solveTask5();
        System.out.println("------------------------------------------------");
        System.out.println("Starting task 6:");
        solveTask6();
    }

    /**
     * Also task1 could be done like that:
     * {@snippet lang = java:
     *      *StringOperations.sortArrayByLength(arrayOfStrings);
     *      *System.out.println("The shortest string is:");
     *      *System.out.println(arrayOfStrings[0]);
     *      *System.out.println("The longest string is:");
     *      *System.out.println(arrayOfStrings[2]);
     * *     }
     */
    public static void solveTask1(String[] arrayOfStrings) {
        StringOperations.findShortest(arrayOfStrings);
        StringOperations.findLongest(arrayOfStrings);
    }

    public static void solveTask2(String[] arrayOfStrings) {
        StringOperations.sortArrayByLength(arrayOfStrings);
        StringOperations.showArrayOfStrings(arrayOfStrings);
    }

    public static void solveTask3(String[] arrayOfStrings) {
        if (arrayOfStrings[0].length() < arrayOfStrings[1].length())
            StringOperations.showString(arrayOfStrings[0]);
        else
            System.out.println("There is no strings shorter then the middle one...");
    }

    public static void solveTask4(String[] arrayOfStrings) {
        StringOperations.lookForUniqueWords(arrayOfStrings);
    }

    public static void solveTask5() {
        String stringToDuplicateLetters = StringOperations.getUserInput("Input string to duplicate letters: ").nextLine();
        StringOperations.duplicateLetters(stringToDuplicateLetters);
    }

    public static void solveTask6() {
        String stringToGetWord = StringOperations.getUserInput("Input string to check for palindrome: ").nextLine();
        int selectedWord;
        String wordToCheck;
        do {
            selectedWord = StringOperations.getUserInput("Input number of the word in the sentence: ").nextInt() - 1;
            if (selectedWord > StringOperations.countSpaces(stringToGetWord)) {
                System.out.println("There aren't that many words in the sentence... ");
            } else if (selectedWord < 0) {
                System.out.println("Wrong input... ");
            } else
                break;
        } while (true);
        wordToCheck = StringOperations.getParticularWord(stringToGetWord, selectedWord);
        System.out.println("Your word is \"" + wordToCheck + "\".");
        System.out.println((StringOperations.checkIfPalindrome(wordToCheck)) ? "Your word is palindrome." :
                                                                            "Your word is not a palindrome");
    }

}