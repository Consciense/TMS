//На вход поступает массив непустых строк, создайте и верните Map<String,
//String> следующим образом: для каждой строки добавьте ее первый символ в
//качестве ключа с последним символом в качестве значения. Пример:
//pairs(["code", "bug"]) → {"b": "g", "c": "e"}
//pairs(["man", "moon", "main"]) → {"m": "n"}
//pairs(["man", "moon", "good", "night"]) → {"g": "d", "m": "n", "n": "t"}

import java.util.HashMap;
import java.util.Map;

public class FirstAndLastSymbols {
    private static final String[] ARRAY = new String[]{
            "man", "moon", "good", "night", "main", "code", "bug"};

    public static void solveTask2() {
        Map<String, String> map = new HashMap<>();
        String firstChar;
        String lastChar;
        for (String string : ARRAY) {
            firstChar = String.valueOf(string.charAt(0));
            lastChar = String.valueOf(string.charAt(string.length() - 1));
            map.put(firstChar, lastChar);
        }
        System.out.println(map);
    }
}
