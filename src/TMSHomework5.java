import java.util.Scanner;
import java.util.Random;

public class TMSHomework5 {
    public static void main(String[] args) {
        solveTask1();
        solveTask2();
        solveTask3();
    }

    public static void solveTask1() {
        int[][] matrix = createMatrix();
        fillWithRandom(matrix, 0, 101);
        showMatrix(matrix);
        increaseArrayElements(matrix);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
        showMatrix(matrix);
        System.out.println("Sum of all elements equals: " + summarizeMatrixElements(matrix));
    }

    public static void increaseArrayElements(int[][] arrayToIncrease) {
        for (int outer = 0; outer < arrayToIncrease.length; outer++) {
            for (int inner = 0; inner < arrayToIncrease[outer].length; inner++) {
                arrayToIncrease[outer][inner]++;
            }
        }
    }

    public static int summarizeMatrixElements(int[][] matrixToSummarize) {
        int sumOfElements = 0;
        for (int[] column : matrixToSummarize) {
            for (int element : column) {
                sumOfElements += element;
            }
        }
        return sumOfElements;
    }

    public static void solveTask2() {
        String[][] field = new String[8][8];
        for (int outer = 0; outer < 8; outer++) {
            for (int inner = 0; inner < 8; inner++) {
                field[outer][inner] = ((inner + outer) % 2) == 0 ? "W" : "B";
                System.out.print(field[outer][inner] + " ");
            }
            System.out.println();
        }
    }

    public static void solveTask3() {
        int[][] sneakMatrix = createMatrix();
        for (int outer = 0, currentValue = 0; outer < sneakMatrix.length; outer++) {
            if (outer % 2 == 0) {
                for (int inner = 0; inner < sneakMatrix[outer].length; inner++) {
                    sneakMatrix[outer][inner] = currentValue++;
                }
            } else {
                for (int inner = sneakMatrix[outer].length - 1; inner >= 0; inner--) {
                    sneakMatrix[outer][inner] = currentValue++;
                }
            }
        }
        showMatrix(sneakMatrix);
    }

    public static int[][] createMatrix() {
        System.out.println("Input your array size");
        return new int[getUserInput("Input number of rows")]
                [getUserInput("Input number of columns")];
    }

    public static void showMatrix(int[][] matrix) {
        for (int[] column : matrix) {
            for (int element : column) {
                if (element < 10) {
                    System.out.print("  " + element);
                } else
                    System.out.print(" " + element);
            }
            System.out.println();
        }
    }

    public static int getUserInput(String messageToUser) {
        System.out.println(messageToUser);
        return new Scanner(System.in).nextInt();
    }

    public static void fillWithRandom(int[][] matrix, int origin, int bound) {
        for (int outer = 0; outer < matrix.length; outer++) {
            for (int inner = 0; inner < matrix[outer].length; inner++) {
                matrix[outer][inner] = new Random().nextInt(origin, bound);
            }
        }
    }
}