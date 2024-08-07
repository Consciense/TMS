// Using only two variables
public class Task6 {
    static void getTaskResult (int a, int b){
        System.out.println("Before swapping, a = " + a + " and b = " + b);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("After swapping, a = " + a + " and b = " + b);
    }
// noBrain Swap
    static void getBasicTask6Result (int a, int b){
        System.out.println("Before swapping, a = " + a + " and b = " + b);
        int temp;
        temp = a;
        a = b;
        b = temp;
        System.out.println("After swapping, a = " + a + " and b = " + b);
    }
}