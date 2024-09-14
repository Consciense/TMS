import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Verification {
    // not allowing less than 5 symbols since it is strange to use such short word for login or password

    public static boolean isCorrectLogin(String password) {
        Pattern passwordPattern = Pattern.compile("^\\S{5,20}$");
        Matcher matcher = passwordPattern.matcher(password);
        return matcher.find();
    }

    public static boolean isCorrectPassword (String login) {
        Pattern loginPattern = Pattern.compile("^(?=.*\\d)(\\S{5,20})$");
        Matcher matcher = loginPattern.matcher(login);
        return matcher.find();
    }
}
