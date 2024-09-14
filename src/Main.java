import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        signupUser();
        doNotUseFinally();
    }

    public static void signupUser() {
        String login;
        String password;
        String confirmPassword;

        login = getUserInput("Input your login").nextLine();
        password = getUserInput("Input your password").nextLine();
        confirmPassword = getUserInput("Confirm your password").nextLine();

        if (Signup.isCorrect(login, password, confirmPassword))
            System.out.println("Registration succeeded");
        else
            System.out.println("Signup was unsuccessful");
    }

    static Scanner getUserInput(String messageToUser) {
        System.out.println(messageToUser);
        return new Scanner(System.in);
    }

    public static void doNotUseFinally() {
        int number;
        do {
            number = getUserInput("1 to check first way\n2 to check the second way").nextInt();
        } while (number != 1 && number != 2);
        if (number == 1)
            doNotUseFinally1();
        else
            doNotUseFinally2();
    }

    public static void doNotUseFinally1() {
        try {
            System.out.println("going to the \"try\" block");
            System.exit(0);
            throw new Exception();
        } catch (Exception e) {
            System.err.println("Exception");
        } finally {
            System.out.println("inside finally");
        }
        System.out.println("after finally");
    }

    public static void doNotUseFinally2() {
        try {
            System.out.println("going to the \"try\" block");
            while (true) {
            }
        } catch (Exception e) {
            System.err.println("Exception");
        } finally {
            System.out.println("inside finally");
        }
        System.out.println("after finally");
    }
}
