
public final class User implements Cloneable {
    private static int userCounter;
    private Person person;
    private final String nickname;
    private final int userID;

    User(String nickname, String name, String surname, int age) {
        this.nickname = nickname;
        person = new Person(name, surname, age);
        this.userID = createID();
    }

    int getUserID() {
        return this.userID;
    }

    @Override
    public String toString() {
        return "Current user info:" +
                "\nName: " + person.getName() +
                "\nSurname: " + person.getSurname() +
                "\nAge: " + person.getAge() +
                "\nNickname: " + this.nickname +
                "\nID: " + this.userID +
                "\n-------------------------------------------------------";

    }

    @Override
    public boolean equals(Object obj) {
        User tempUser = (User) obj;
        return this.nickname.equals(tempUser.nickname) &&
                this.person.getName().equals(tempUser.person.getName()) &&
                this.person.getSurname().equals(tempUser.person.getSurname()) &&
                this.person.getAge() == tempUser.person.getAge();
    }

    @Override
    public int hashCode() { // no need to rewrite it
        return super.hashCode();
    }

    public static int createID() {
        userCounter++;
        return userCounter;
    }

    public User createDeepCopy() throws CloneNotSupportedException {
        this.person = person.clone();
        return (User) super.clone();
    }

    public User createShallowCopy() throws CloneNotSupportedException {
        return (User) super.clone();
    }
}
