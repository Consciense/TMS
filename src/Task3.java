public class Task3 {
     static int getTaskResult (int n){
        return n / 100 + Task2.getTaskResult(n % 100);
    }
}