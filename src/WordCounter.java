
import java.util.HashMap;

public class WordCounter {
    private static final String[] ARRAY = new String[]{
            "string1", "string1", "string1", "string1",
            "string2",
            "string3", "string3"};

    public static void solveTask1() {
        HashMap<String, Boolean> wordCounter = calculateWords();
        System.out.println(wordCounter);
    }

    private static HashMap<String, Boolean> calculateWords() {
        HashMap<String, Boolean> wordCounter = new HashMap<>();
        for (String word : WordCounter.ARRAY) {
            if (wordCounter.containsKey(word)) {
                if (wordCounter.get(word)) {
                    continue;
                }
                wordCounter.put(word, true);
            } else {
                wordCounter.put(word, false);
            }
        }
        return wordCounter;
    }
}
