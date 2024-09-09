//        Задача *:
//Программа на вход получает произвольный текст. В этом тексте может быть:
// номер документа(один или несколько),
// адрес почты
// номер телефона.
//
// Номер документа в формате:
// xxxx-xxxx-xx, где x - это любая цифра;
// номер телефона в формате: +|375|(xx)xxxxxxx.
// Документ (текст?) может содержать не всю информацию, т.е. например, может не содержать номер
// телефона, или другое.
// Необходимо найти эту информацию и вывести в консоль в
//формате:
//email: teachmeskills@gmail.com
//document number: 1423-1512-51
//и т.д

import java.util.Scanner;
import  java.util.regex.Pattern;
import  java.util.regex.Matcher;

public class Main {
    public static void main(String[] args) {
        getAbbreviations();
        getTaskFromArchil();
        getInfo();
    }

    public static void getAbbreviations() {
        //              AS ASd ASD ASDa ASDA ASDAs ASDAS ASDASd ASDASD ASDASDA ASDASDa          string to test all matches
        String userText = getUserInput().nextLine();
        Pattern abbreviationPattern = Pattern.compile("\\b[A-ZА-Я]{2,6}\\b");
        Matcher matcher = abbreviationPattern.matcher(userText);
        while (matcher.find()) {
            System.out.println(userText.substring(matcher.start(), matcher.end()));
        }
    }

    public static void getTaskFromArchil() {
        String userText = getUserInput().nextLine();
        Pattern abbreviationPattern = Pattern.compile("\\b[a-zа-я]{3,6}\\b");
        Matcher matcher = abbreviationPattern.matcher(userText);
        while (matcher.find()) {
            System.out.println(userText.substring(matcher.start(), matcher.end()));
        }
    }
    public static void getInfo () {
        String userText = getUserInput().nextLine();
        Pattern[] infoPattern = new Pattern[]{
                Pattern.compile("\\b\\d{4}-\\d{4}-\\d{2}\\b"),
                Pattern.compile("\\+\\([0-9]{2}\\)[0-9]{7}\\b"),
                Pattern.compile("\\b[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+\\b")
        };
        String[] prefix = new String[]{
                "Document number from text: ",
                "Phone number from text: ",
                "Email address from text: "
        };
        for(int counter = 0; counter < infoPattern.length; counter++){
            Matcher matcher = infoPattern[counter].matcher(userText);
            while (matcher.find()) {
                System.out.println(prefix[counter] + userText.substring(matcher.start(), matcher.end()));
            }
        }

    }

    static Scanner getUserInput() {
        System.out.println("Input your text:");
        return new Scanner(System.in);
    }
}
