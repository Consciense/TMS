import java.util.Scanner;

/**
 * Задача 1:
 * <p>
 * Создать класс для описания пользователя системы. Переопределить в классе методы
 * {@code toString}, {@code hashcode} и {@code equals}. Создать несколько экземпляров класса с одним и тем же
 * значением полей и сравнить с помощью метода {@code equals}.
 * <p>
 * Задача *:
 * <p>
 * Создать программу для реализации поверхностного и глубокого клонирования объекта класса {@code User}.
 * Пусть на вход программе будет передаваться тип операции клонирования (поверхностное клонирование или глубокое),
 * а также id юзера для клонирования.
 */

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        solveTask1();
        specialTask();
    }

    public static void solveTask1() throws CloneNotSupportedException {
        int userInput;
        User[] users = new User[]{
                new User("HolAn", "Anton", "Holub", 25),
                new User("HolAn", "Anton", "Holub", 25),
                new User("AnHol", "Anton", "Holub", 40)
        };
        User copiedUser;
        System.out.println(users[0]);
        System.out.println(users[1]);
        System.out.println(users[2]);
        compareUsers(users[0], users[1]);
        compareUsers(users[1], users[2]);
        while (true) {
            userInput = getUserInput("Choose user to copy, bu inputting user's ID: ").nextInt();
            if (userInput < 1 || userInput > users.length) {
                System.out.println("No such user ID...");
                break;
            } else {
                int index = findUserIndexByID(users, userInput);
                userInput = getUserInput("Input 1 to create deep copy, " +
                        "or any other value to create shallow copy.").nextInt();
                if (userInput == 1) {
                    System.out.println("Creating deep copy...");
                    copiedUser = users[index].createDeepCopy();
                } else {
                    System.out.println("Creating shallow copy...");
                    copiedUser = users[index].createShallowCopy();
                }
                System.out.println("Copied user info:");
                System.out.println(copiedUser);
            }
            userInput = getUserInput("Input 0 to exit program or other value to restart... ").nextInt();
            if (userInput == 0) {
                System.out.println("Exiting program...");
                return;
            }
        }
    }

    public static void specialTask() throws CloneNotSupportedException {
        User user1 = new User("HolAn", "Anton", "Holub", 25);
        System.out.println(user1);
        User user2 = new User(user1);
        System.out.println(user2);
        user1.changeFields("Test", "Test", "Test", 0);
        System.out.println(user1);
        System.out.println(user2);
    }

    public static int findUserIndexByID(User[] arrayOdUsers, int id) {
        for (int counter = 0; counter < arrayOdUsers.length; counter++) {
            if (arrayOdUsers[counter].getUserID() == id)
                return counter;
        }
        return -1;
    }

    public static void compareUsers(User user1, User user2) {
        System.out.println("Compare users with ID " + user1.getUserID() + " and ID " + user2.getUserID());
        System.out.println(user1.equals(user2) ? "Users are equal..." : "Users are not equal...");
    }

    public static Scanner getUserInput(String messageToUser) {
        System.out.println(messageToUser);
        return new Scanner(System.in);
    }
}