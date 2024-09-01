public final class Person implements Cloneable{
    private final String name;
    private final String surname;
    private final int age;

    Person (String name, String surname, int age){
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    @Override
    public Person clone() throws CloneNotSupportedException {
        return (Person) super.clone();

    }
}
