
//Задача 2:
//Пользователь вводит строку с клавиатуры. Для каждого слова подсчитать частоту его
//встречаемости. Слова, отличающиеся регистром букв считать разными. Использовать
//класс HashMap. После выполнения результат вывести в консоль.


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCounter {
    public static void task2() {
        ArrayList<String> arrayOfWords = splitInWords(getUserInput().nextLine());
        HashMap<String, Integer> wordCounter = calculateWords(arrayOfWords);
        System.out.println(wordCounter);
    }

    private static HashMap<String, Integer> calculateWords(ArrayList<String> arrayOfWords){
        int counter;
        HashMap<String, Integer> wordCounter = new HashMap<>();
        for (String word : arrayOfWords) {
            if (wordCounter.containsKey(word)) {
                counter = wordCounter.get(word);
                wordCounter.put(word, counter + 1);
            } else {
                wordCounter.put(word, 1);
            }
        }
        return wordCounter;
    }

    private static ArrayList<String> splitInWords(String text) {
        ArrayList<String> arrayOfWords = new ArrayList<String>();
        Pattern wordPattern = Pattern.compile("[a-zA-Z0-9]+");
        Matcher matcher = wordPattern.matcher(text);
        while (matcher.find()) {
            arrayOfWords.add(text.substring(matcher.start(), matcher.end()));
        }
        return arrayOfWords;
    }

    private static Scanner getUserInput() {
        System.out.println("Input your string: ");
        return new Scanner(System.in);
    }
}
