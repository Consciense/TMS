// Создать свой класс, симулирующий работу класса динамической коллекции - т.е. создать свою кастомную коллекцию.
// В основе коллекции будет массив. Кастомная коллекция должна хранить элементы разных классов(т.е. это generic).

//Предусмотреть операции(методы):
//  1. добавления элемента
//  2. удаления элемента
//  3. получение элемента по индексу
//  4. проверка есть ли элемент в коллекции
//  5. очистка всей коллекции

//Предусмотреть конструктор без параметров - создает массив размером по умолчанию.
// Предусмотреть конструктор с задаваемым размером внутреннего массива.
// Предусмотреть возможность автоматического расширения коллекции при добавлении элемента в том случае, когда коллекция уже заполнена.

public class ShowMyArrayList {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>(); // creating an array without a specific size
        MyArrayList<String> sList = new MyArrayList<>(2); //creating an array with a specific size
        sList.add("string one");
        sList.add("string two");
        sList.showList();
        System.out.println("current size = " + sList.getSize());
        System.out.println("Is string one is in collection?");
        System.out.println(sList.isInCollection("string one"));
        sList.remove("string one");
        System.out.println("Is string one is in collection?");
        System.out.println(sList.isInCollection("string one"));
        System.out.println("-------------------");
        sList.showList();
        System.out.println("current size = " + sList.getSize());

        for (int i = 0; i < 12; i++) { // adding elements beyond the standard capacity (standard capacity is 10)
            list.add(i * 100);
        }
        list.showList();
        System.out.println("current size = " + list.getSize());
        System.out.println("-------------------");
        System.out.println("element with index 10 equals " + list.getElement(10));
        System.out.println("index of 1000 is: " + list.getIndex(1000));
        System.out.println("-------------------");
        list.clearList();
        System.out.println("List after clearing:");
        list.showList();
        System.out.println("-------------------");

    }

    public static void solveTask() {

    }
}
