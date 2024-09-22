import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class DeleteDuplicates {

    public static void solveTask() {
        Set<String> strings;
        System.out.println("Input your sequence:");
        String sequence = getText();
        String[] arrayOfNumbers = splitText(sequence);
        strings = getSetOfStrings(arrayOfNumbers);
        System.out.println(strings);
    }

    public static Set<String> getSetOfStrings(String[] array){
        return new LinkedHashSet<>(Arrays.asList(array));
    }

    public static String[] splitText(String string){
        return string.split(", ");
    }

    public static String getText (){
        return new Scanner(System.in).nextLine();
    }

}
