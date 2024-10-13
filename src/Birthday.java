import java.time.LocalDate;

public class Birthday {
    public static void getAnniversary() {
        String date = Main.getUserInput("Input date of birth (YY-MM-DD)").nextLine();
        LocalDate localDate = LocalDate.parse(date);
        LocalDate anniversary = localDate.plusYears(100);
        System.out.println("You will be 100 years on: " + anniversary);
    }
}
