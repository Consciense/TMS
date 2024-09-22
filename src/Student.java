//Создать класс Student, содержащий следующие характеристики – имя, группа, курс,
//оценки по предметам. Создать коллекцию, содержащую объекты класса Student.

import java.util.HashMap;

public class Student {
    private final String name;
    private final String group;
    private int course;
    private final HashMap<String, Integer> grades;

    Student(String name, String group, int course, int mathGrade, int physicsGrade, int englishGrade) {
        grades = new HashMap<>();
        this.name = name;
        this.group = group;
        this.course = course;
        grades.put("Math", mathGrade);
        grades.put("Physics", physicsGrade);
        grades.put("English", englishGrade);
    }

    @Override
    public String toString() {
        return "Student info\n" +
                "Name: " + getName() + "\n"+
                "Group: " + getGroup() + "\n"+
                "Course: " + getCourse() + "\n"+
                "Grades " + "\n"+
                "Math: " + grades.get("Math") + "\n"+
                "Physics: " + grades.get("Physics") + "\n"+
                "English: " + grades.get("English")+ "\n";
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public HashMap<String, Integer> getGrades() {
        return grades;
    }
}
