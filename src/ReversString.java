import java.util.function.Supplier;

public class ReversString {
    public static void getResult(){
        Supplier<StringBuilder> supplier = () -> {
            StringBuilder string = new StringBuilder(Main.getUserInput("Input your string:").nextLine());
            return string.reverse();
        };
        System.out.println(supplier.get());
    }


}
