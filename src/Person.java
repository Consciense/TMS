public final class Person implements Cloneable{
    private String name;
    private String surname;
    private int age;

    Person (String name, String surname, int age){
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setSurname(String surname) {
        this.surname = surname;
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
