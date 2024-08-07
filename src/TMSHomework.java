public class TMSHomework {
    public static void main(String[] args) {
        double Task1Result = Task1.getTaskResult(70, 23);
        int Task2Result = Task2.getTaskResult(99);
        int Task3Result = Task3.getTaskResult(234);
        long Task4Result = Task4.getTaskResult(34.4);
        String Task5Result = Task5.getTaskResult(21, 8);
        System.out.println("Task1 result is: " + Task1Result);
        System.out.println("Task2 result is: " + Task2Result);
        System.out.println("Task3 result is: " + Task3Result);
        System.out.println("Task4 result is: " + Task4Result);
        System.out.println("Task5 result is: " + Task5Result);
        System.out.println("Task6 result is: ");
        Task6.getTaskResult(11, 22);
    }
}