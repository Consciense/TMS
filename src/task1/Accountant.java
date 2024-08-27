package task1;

public class Accountant extends Person{


     public Accountant(String name) {
        super(name, "Accountant");
    }

    @Override
    public void doSomeWork() {
        System.out.println("The accountant is in charge of the employees' payroll.");
    }
}
