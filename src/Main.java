
//Задача 2:
//Написать иерархию классов Фигура, Треугольник, Прямоугольник, Круг. Реализовать
//функцию подсчета площади для каждого типа фигуры и подсчет периметра(используя абстрактный класс/методы).
// Создать массив из 5 разных фигур. Вывести на экран сумму периметра всех фигур в массиве.

//Задача *:
//Самостоятельно изучить и показать пример работы интерфейса-маркера Cloneable.

import task1.*;
import task2.*;

public class Main {
    public static void main(String[] args) {
        showInterfaceExample();
        showFiguresExample();
    }

    public static void showInterfaceExample() {
        Person[] people = new Person[]{
                new Director("Archil"),
                new Accountant("Elena"),
                new Worker("Alexander")
        };
        for (Person person : people) {
            person.showRole();
            person.doSomeWork();
            System.out.println("--------------------------------------------------------");
        }
    }

    public static void showFiguresExample (){
        double sumOfPerimeters = 0;

        Figure[] figures = new Figure[]{
               new Triangle(3,4,5),
                new Circle(35),
                new Rectangle(25,15),
                new Circle(7),
                new Triangle(12,12,12),
        };
        for (Figure figure : figures){
            System.out.println(figure);
            sumOfPerimeters += figure.getPerimeter();
            System.out.println("---------------------------------------------------------");
        }
        System.out.println("Total perimeter of shapes equals: " + sumOfPerimeters);
    }
}
