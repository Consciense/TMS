package task3;

public class Plant { // not implementing Cloneable
    int age;
    String type;
    public Plant(String type, int age){
        this.type = type;
        this.age = age;
    }

    @Override
    public String toString(){
        return "This is a " + this.type + ". " +
                "\nIt is " + this.age + " years old.\n";
    }

    @Override
    public Plant clone() {  // wanted create simple return super.clone; but compiler build this and im ok with it...
        try {
            return (Plant) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
