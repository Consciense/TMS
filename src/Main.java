import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Birthday.getAnniversary();
        PositiveNumbers.showPositive();
        Converter.convertVIAFunction();
        Converter.convertVIAConsumer();
        ReversString.getResult();
    }

    public static Scanner getUserInput(String message) {
        System.out.println(message);
        return new Scanner(System.in);
    }
}
