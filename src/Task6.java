/*          Задача 6:
Написать программу которая будет менять местами значение целочисленных
переменных. Пример:
int a = 1; int b = 2;
//код (ваше решение)
sout(a); //выведет 2
sout(b); //выведет 1
Усовершенствовать программу, использовать только 2 входные переменные (a,b);*/

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