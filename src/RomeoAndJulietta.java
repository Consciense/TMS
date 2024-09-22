import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomeoAndJulietta implements FileOperations{

    public static void solveTask() {
        StringBuilder text = null;
        try {
            text = FileOperations.readTextFromFile("C:\\Users\\mrjj9\\IdeaProjects\\TMS\\src\\Romeo and Julietta");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        ArrayList<String> array = splitInWords(text);
        String word = findLongestWord(array);
        FileOperations.addTextToFile(word, "longestWord.txt");
        System.out.printf("The longest word is \"%s\"\n", word);
    }

    public static ArrayList<String> splitInWords(StringBuilder text) {
        ArrayList<String> arrayOfWords = new ArrayList<String>();

        Pattern wordPattern = Pattern.compile("[a-zA-Z]+");
        Matcher matcher = wordPattern.matcher(text);
        while (matcher.find()) {
            arrayOfWords.add(text.substring(matcher.start(), matcher.end()));
        }
        return arrayOfWords;
    }

    public static String findLongestWord(ArrayList<String> arrayOfWords) {
        String longestWord = arrayOfWords.get(1);

        for (String word : arrayOfWords) {
            if (word.length() > longestWord.length())
                longestWord = word;
        }
        return longestWord;
    }
}
