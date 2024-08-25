import java.util.Scanner;

public class AnimalTestDrive {
    public static void main(String[] args) {
        int userChoice;
        String userFood;
        while (true) {
            System.out.println("-------------------------------------------------------------");
            userChoice = getUserInput("""
                    Enter 1 to feed Dog
                    Enter 2 to feed Rabbit
                    Enter 3 to feed Tiger
                    Enter 4 to check 2nd task
                    Enter something else to leave""").nextInt();
            if (userChoice > 4 || userChoice < 0)
                return;
            userFood = getUserInput("Input your food: ").nextLine();
            switch (userChoice){
                case 1:
                    Animal dogPolina= new Dog("Dog");
                    dogPolina.eat(userFood);
                    break;
                case 2:
                    Animal rabbitAlexey= new Rabbit("Rabbit");
                    rabbitAlexey.eat(userFood);
                    break;
                case 3:
                    Animal tigerAndrew = new Tiger("Tiger");
                    tigerAndrew.eat(userFood);
                    break;
                case 4:
                    //Animal dogHidden1 = new HiddenDog(); - ERROR
                    Animal dogHidden = HiddenDog.getHiddenDog();
                    dogHidden.eat(userFood);
                    break;
            }
        }
    }
    public static Scanner getUserInput(String messageToUser) {
        System.out.println(messageToUser);
        return new Scanner(System.in);
    }
}
