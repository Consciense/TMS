import java.util.function.Consumer;
import java.util.function.Function;

public class Converter {
    private static final double BYN_FOR_USD = 3.3011;

    public static void convertVIAFunction() {
        String sum = Main.getUserInput("Input sum in BYN(*sum* BYN):").nextLine();
        Function<String, Double> parse = string -> Double.parseDouble(string.split(" ")[0]) / BYN_FOR_USD;
        System.out.println("It is equivalent to $" + parse.apply(sum) + " USD");
    }

    public static void convertVIAConsumer(){
        String sum = Main.getUserInput("Input sum in BYN(*sum* BYN):").nextLine();
        Consumer<String> convert = string -> System.out.println("It is equivalent to " +
                Double.parseDouble(string.split(" ")[0]) / BYN_FOR_USD  + " USD");
        convert.accept(sum);
    }
}
