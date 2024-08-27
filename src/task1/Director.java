package task1;

public class Director extends Person{


    public Director(String name) {
        super(name, "Director");
    }

    @Override
    public void doSomeWork() {
        System.out.println("The director is in charge of everything.");
    }
}
