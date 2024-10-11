import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Brackets {
    public static void solveTask() {
        String sequence;
        do {
            sequence = getUserInput().nextLine();
            if (hasOtherSymbols(sequence)) {
                System.err.println("Incorrect input...");
            }
        } while (hasOtherSymbols(sequence));
        System.out.println(isBalanced(sequence) ? "Is balanced" : "Is unbalanced");
    }

    private static boolean isBalanced(String string) {
        if (string.length() % 2 != 0) {
            return false;
        }
        char[] array = string.toCharArray();
        ArrayList<Character> arrayList = new ArrayList<>();
        for (char bracket : array) {
            arrayList.add(bracket);
        }
        ArrayList<Character> openingBrackets = new ArrayList<>();
        for (char bracket : arrayList) {
            if (bracket == '(' || bracket == '[' || bracket == '{') {
                openingBrackets.add(bracket);
            } else {
                if (openingBrackets.isEmpty()) {
                    return false;
                }
                switch (bracket) {
                    case ')':
                        if (openingBrackets.getLast() == '(') {
                            openingBrackets.removeLast();
                            break;
                        }
                        return false;
                    case '}':
                        if (openingBrackets.getLast() == '{') {
                            openingBrackets.removeLast();
                            break;
                        }
                        return false;
                    case ']':
                        if (openingBrackets.getLast() == '[') {
                            openingBrackets.removeLast();
                            break;
                        }
                        return false;
                }
            }
        }


        return true;
    }

    private static boolean hasOtherSymbols(String string) {
        Pattern brackets = Pattern.compile("[^\\[\\](){}]");
        Matcher matcher = brackets.matcher(string);
        return matcher.find();
    }

    private static Scanner getUserInput() {
        System.out.println("Input brackets sequence: ");
        return new Scanner(System.in);
    }
}
