package task1;

public class Worker extends Person{


    public Worker(String name) {
        super(name, "Worker");
    }

    @Override
    public void doSomeWork() {
        System.out.println("The worker is in charge of different activities.");
    }
}
