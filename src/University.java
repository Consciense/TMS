import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class University {
    private static final List<Student> studentsList = new ArrayList<>();

    public static void solveTask() {
        addStudents();
        showAllStudents();
        transferStudents();
        showAllStudents();
        int course = getUserInput("Input course:").nextInt();
        printStudents(course);
    }

    private static void printStudents(int course) {
        boolean wasPrinted = false;
        for (Student student : University.studentsList) {
            if (student.getCourse() == course) {
                wasPrinted = true;
                System.out.println(student.getName());
            }
        }
        if (!wasPrinted)
            System.out.println("There is no students on this course...");
    }

    private static void transferStudents() {
        for (int counter = 0; counter < studentsList.size(); counter++) {
            int averageGrade = (studentsList.get(counter).getGrades().get("Math") +
                    studentsList.get(counter).getGrades().get("Physics") +
                    studentsList.get(counter).getGrades().get("English")) / 3;
            if (averageGrade < 3) {
                System.out.println("\u001B[31m" + studentsList.get(counter).getName() + " is expelled...\u001B[0m");
                studentsList.remove(counter);
                continue;
            }
            studentsList.get(counter).setCourse((studentsList.get(counter).getCourse()+1));

        }
    }

    private static void showAllStudents() {
        for (Student student : University.studentsList) {
            System.out.println(student);
        }
        System.out.println("----------------------------------------------");
    }

    private static void addStudents() {
        studentsList.add(new Student("Brut", "711101", 1, 0, 0, 0));
        studentsList.add(new Student("Octavian August", "711103", 3, 7, 4, 0));
        studentsList.add(new Student("Caesar", "710101", 2, 10, 10, 10));
        studentsList.add(new Student("Mark Antony", "811101", 1, 7, 7, 7));
        studentsList.add(new Student("Marcus Licinius Crassus", "911101", 2, 9, 7, 6));
        studentsList.add(new Student("Marcus Tullius Cicero", "912101", 4, 7, 7, 6));
    }

    private static Scanner getUserInput(String message) {
        System.out.println(message);
        return new Scanner(System.in);
    }
}
