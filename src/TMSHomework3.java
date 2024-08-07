import java.util.Scanner;

public class TMSHomework3{
    public static void main(String[] args) {
        solveTask1();
        solveTask2();
        solveTask3();
        solveTask4();
    }

    public static void solveTask1() {
        System.out.println("Task 1: \n Input your number...");
        Scanner line = new Scanner(System.in);
        int i = line.nextInt();
        if (i % 2 == 0) {
            System.out.println("Your number is even...");
        } else {
            System.out.println("Your number is odd...");
        }
    }

    public static void solveTask2() {
        System.out.println("Task 2: \n Input outdoor temperature...");
        Scanner line = new Scanner(System.in);
        int outdoorTemperature = line.nextInt();
        if (outdoorTemperature > -5) {
            System.out.println("Warm...");
        } else if (outdoorTemperature > -20) {
            System.out.println("Normal...");
        } else {
            System.out.println("Cold...");
        }
    }

    public static void solveTask3() {
        System.out.println("Task 3:");
        for (int i = 10; i <= 20; i++) {
            System.out.print(i*i + " ");
        }
    }

    public static void solveTask4() {
        System.out.println("\n Task 4:");
        int outputNumber = 7;
        while(outputNumber < 99){
            System.out.print(outputNumber + " ");
            outputNumber +=7;
        }
    }
}
