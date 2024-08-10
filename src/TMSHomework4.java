import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class TMSHomework4 {
    public static void main(String[] args) {
        int[] array = createArray();
        solveTask1(array);
        solveTask2(array);
        solveTask3(array);
        solveTask4(array);
        solveTask5(array);
        solveTask6(array);
        solveTask7(array);
    }

    public static void solveTask1(int[] arrayToShow) {  // вывести все элементы в прямом и в обратном порядке
        System.out.println("Your array from start to end:");
        for (int arrayElement : arrayToShow) {
            System.out.print(arrayElement + " ");
        }
        System.out.println("\nYour array backwards:");
        for (int counter = arrayToShow.length; counter > 0; counter--) {
            System.out.print(arrayToShow[counter - 1] + " ");
        }
        System.out.println();
    }

    public static void solveTask2(int[] array) {
        int minValue = Integer.MAX_VALUE, maxValue = Integer.MIN_VALUE;
        for (int arrayElement : array) {
            if (arrayElement > maxValue)
                maxValue = arrayElement;
            if (arrayElement < minValue)
                minValue = arrayElement;
        }
        System.out.println("Maximal value in array is: " + maxValue + "\nMinimal value in array is: " + minValue);
    }

    public static void solveTask3(int[] array) {
        int minValue = Integer.MAX_VALUE, maxValue = Integer.MIN_VALUE, indexOfMinValue = 0, indexOfMaxValue = 0;
        for (int counter = 0; counter < array.length; counter++) {
            if (array[counter] > maxValue) {
                maxValue = array[counter];
                indexOfMaxValue = counter;
            }
            if (array[counter] < minValue) {
                minValue = array[counter];
                indexOfMinValue = counter;
            }
        }
        System.out.println("Minimal element [" + indexOfMinValue + "] " + minValue +
                "\nMaximal element [" + indexOfMaxValue + "] " + maxValue);
    }

    public static void solveTask4(int[] array) {
        int zeroCounter = 0;
        for (int arrayElement : array)
            if (arrayElement == 0)
                zeroCounter++;
        System.out.println(zeroCounter == 0 ? "There is no zeroes in your array... " : "There is "
                + zeroCounter + " zeroes in your array...");
    }

    public static void solveTask5(int[] array) {
        for (int counter = 0, middleIndex = array.length / 2; counter < middleIndex; counter++) {
            array[counter] = array[counter] + array[array.length - counter - 1];
            array[array.length - counter - 1] = array[counter] - array[array.length - counter - 1];
            array[counter] = array[counter] - array[array.length - counter - 1];
        }
        for (int arrayElement : array) {
            System.out.print(arrayElement + " ");
        }
    }

    public static void solveTask6(int[] array) {
        boolean isAscending = true;
        for (int counter = 0; counter < array.length - 1; counter++) {
            if (array[counter] > array[counter + 1] || array[counter] == array[counter + 1]) {
                isAscending = false;
                break;
            }
        }
        System.out.println(isAscending ? "\nYour array is ascending sequence..." : "\nYour array is not ascending sequence...");
    }

    public static void solveTask7(int[] array) {
        String stringFromArray = Arrays.toString(array);
        stringFromArray = stringFromArray.replaceAll("\\[", "").replaceAll("]", "").
                replaceAll(",", "").replaceAll(" ", "");
        int intFromArray = Integer.parseInt(stringFromArray);
        System.out.println("Your number is: " + (intFromArray++));
        System.out.println("New number is: " + intFromArray);
        int arrayLength = Integer.toString(intFromArray).length();
        int[] newArray = new int[Integer.toString(intFromArray).length()];
        for(int counter = 0; intFromArray != 0; counter++){
            newArray[arrayLength-1-counter] = intFromArray % 10;
            intFromArray /= 10;
       }
        System.out.println("New array is:");
        for (int arrayElement : newArray) {
            System.out.print(arrayElement + " ");
        }
    }

    public static int getUserInput(String messageToUser) {
        System.out.println(messageToUser);
        return new Scanner(System.in).nextInt();
    }

    public static int[] createArray() {
        int userChoice = getUserInput("Choose how do you want to fill your array: " +
                "1 - fill it manually, 2 - fill it with the random numbers.");
        if (userChoice != 1 && userChoice != 2) {
            return new int[]{5, 7, 2, 0, 3};
        }
        int arraySize = getUserInput("Input array size:");
        int[] arrayOfNumbers = new int[arraySize];
        switch (userChoice) {
            case 1: //manually
                for (int counter = 0; counter < arraySize; counter++) {
                    arrayOfNumbers[counter] = getUserInput("Input value for the array:");
                }
                break;
            case 2: //random
                for (int counter = 0; counter < arraySize; counter++) {
                    arrayOfNumbers[counter] = new Random().nextInt(0, 11);
                }
                break;
        }
        return arrayOfNumbers;
    }


}

