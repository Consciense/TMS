import java.util.ArrayDeque;
import java.util.Scanner;

public class AnimalsQueue {
    private static final ArrayDeque<String> Animals = new ArrayDeque<>();

    public static void solveTask() {
        workWithAnimals();
    }

    private static void workWithAnimals() {
        int userChoice;
        do {
            showText();
            userChoice = getUserInput("Chose option:").nextInt();
            if (userChoice < 0 || userChoice > 4) {
                System.err.println(userChoice + "Is not an option...");
                continue;
            }
            switch (userChoice) {
                case 1:
                    addListOfAnimals();
                    break;
                case 2:
                    addAnimal();
                    System.out.println(Animals);
                    break;
                case 3:
                    deleteAnimal();
                    System.out.println(Animals);
                    break;
                case 4:
                    if (Animals.isEmpty()){
                        System.out.println("Your list is empty...");
                        continue;
                    }
                    System.out.println(Animals);
                    break;

            }
        } while (userChoice != 0);
    }

    private static void deleteAnimal (){
        if (Animals.isEmpty()){
            System.out.println("Your list is already empty...");
            return;
        }
        Animals.removeLast();
    }

    private static void addListOfAnimals() {
        Animals.addFirst("Ostrich");
        Animals.addFirst("Tiger");
        Animals.addFirst("Lion");
        Animals.addFirst("Giraffe");
    }
    private static void addAnimal(){
        Animals.addFirst(getUserInput("Input your animal type").nextLine());
    }

    private static Scanner getUserInput(String message) {
        System.out.println(message);
        return new Scanner(System.in);
    }

    private static void showText() {
        System.out.println("""
                To start work with Animals list chose an option:
                1 - add prepared animals to the list;
                2 - add your own animal;
                3 - delete animal;
                4 - check animals list.
                """);
    }
}
