import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

public class PositiveNumbers {
    private static final int[] ARRAY = new int[]{
            0, -1, 2, -3, 4, -5, 6, -7, 8, -9, 10
    };

    public static void showPositive() {
        ArrayList<Integer> positiveValues = new ArrayList<>();
        System.out.println("Current array: " + Arrays.toString(ARRAY));
        Predicate<Integer> isPositive = x -> x > 0;
        for (int number : ARRAY) {
            if (isPositive.test(number))
                positiveValues.add(number);
        }
        System.out.println("Only positive numbers: " + positiveValues);
    }
}
