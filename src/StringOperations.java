import java.util.Arrays;
import java.util.Scanner;

public interface StringOperations {

    static Scanner getUserInput(String messageToUser) {
        System.out.println(messageToUser);
        return new Scanner(System.in);
    }

    static void sortArrayByLength(String[] arrayOfStrings) {
        String temp;
        for (int outer = 0; outer < arrayOfStrings.length - 1; outer++) {
            for (int inner = 0; inner < arrayOfStrings.length - outer - 1; inner++) {
                if (arrayOfStrings[inner].length() > arrayOfStrings[inner + 1].length()) {
                    temp = arrayOfStrings[inner];
                    arrayOfStrings[inner] = arrayOfStrings[inner + 1];
                    arrayOfStrings[inner + 1] = temp;
                }
            }
        }
    }

    static void showArrayOfStrings(String[] arrayOfStrings) {
        for (String string : arrayOfStrings)
            System.out.println(string);
    }

    static void showString(String string) {
        System.out.println(string);
        System.out.println("It's length: " + string.length());
    }

    static void findShortest(String[] arrayOfStrings) {
        int index = 0, length = Integer.MAX_VALUE;
        for (int counter = 0; counter < arrayOfStrings.length; counter++) {
            if (arrayOfStrings[counter].length() < length) {
                index = counter;
                length = arrayOfStrings[counter].length();
            }
        }
        System.out.println("The shortest string is:");
        System.out.println(arrayOfStrings[index]);
        System.out.println("It's length: " + length);
    }

    static void findLongest(String[] arrayOfStrings) {
        int index = 0, length = 0;
        for (int counter = 0; counter < arrayOfStrings.length; counter++) {
            if (arrayOfStrings[counter].length() > length) {
                index = counter;
                length = arrayOfStrings[counter].length();
            }
        }
        System.out.println("The longest string is:");
        System.out.println(arrayOfStrings[index]);
        System.out.println("It's length: " + length);
    }

    static int countSpaces(String string) {
        int numberOfSpaces = 0;
        for (int counter = 0; counter < string.length(); counter++) {
            if (string.charAt(counter) == ' ') {
                numberOfSpaces++;
            }
        }
        return numberOfSpaces;
    }

    static void lookForUniqueWords(String[] arrayOfStrings) {
        int uniqueWordsCounter = 0;
        boolean isUniqueWord = true;
        String firstUniqueWord = "";
        for (String string : arrayOfStrings) {                                      // checking each string
            String[] arrayOfWords = string.split(String.valueOf(' '));           // splitting string to words
            for (String word : arrayOfWords) {                                      // checking each word separately
                isUniqueWord = true;                                                // assuming the word is unique
                for (int outer = 0; outer < word.length() - 1; outer++) {           // comparing each letter with the following
                    for (int inner = outer + 1; inner < word.length(); inner++) {   // no need to double-check previous letters
                        if (word.charAt(outer) == word.charAt(inner)) {              // if letters are equal - no need to check the rest
                            isUniqueWord = false;
                            break;
                        }
                    }
                }
                if (isUniqueWord) {
                    uniqueWordsCounter++;
                    if (firstUniqueWord.isEmpty())
                        firstUniqueWord = word;
                }
            }
        }
        System.out.println((isUniqueWord) ? "There is " + uniqueWordsCounter +
                " unique words in your string.\n\"" + firstUniqueWord + "\" is the first of them." :
                "There is no unique words...");
    }

    static void duplicateLetters(String string) {
        char[] array = new char[string.length() * 2 - StringOperations.countSpaces(string)];
        for (int arrayCounter = 0, stringCounter = 0; arrayCounter < array.length; arrayCounter += 2) {
            if (string.charAt(stringCounter) != ' ') {
                array[arrayCounter] = string.charAt(stringCounter);
                array[arrayCounter + 1] = string.charAt(stringCounter);
            } else {
                array[arrayCounter] = string.charAt(stringCounter);
                arrayCounter--;
            }
            stringCounter++;
        }
        System.out.println(array);
    }

    static String getParticularWord(String string, int index) {
        String[] arrayOfWords = string.split(String.valueOf(' '));
        return arrayOfWords[index];
    }

    static boolean checkIfPalindrome(String word) {
        for (int counter = 0; counter < word.length() / 2; counter++) {
            if (word.charAt(counter) != word.charAt(word.length() - 1 - counter))
                return false;
        }
        return true;
    }
}
