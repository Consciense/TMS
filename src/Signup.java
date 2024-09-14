// Создать класс, в котором будет статический метод. Этот метод принимает на вход три
// параметра: login, password, confirmPassword.

// Все поля имеют тип данных String.
// Длина login должна быть меньше 20 символов и не должен содержать пробелы.       NO: " "; < 20 symbols
// Если login не соответствует этим требованиям, необходимо выбросить WrongLoginException.

// Длина password должна быть меньше 20 символов, не должен содержать пробелов и должен
// содержать хотя бы одну цифру.
// Также password и confirmPassword должны быть равны.
// Если password не соответствует этим требованиям, необходимо выбросить WrongPasswordException.

// WrongPasswordException и WrongLoginException - пользовательские классы исключения с двумя конструкторами
// – один по умолчанию, второй принимает сообщение исключения и передает его в конструктор класса Exception.
// Метод возвращает true, если значения верны, false в противном случае.

public class Signup {

    public static boolean isCorrect(String login, String password, String confirmPassword) {
        try {
            if (!Verification.isCorrectLogin(login))
                throw new WrongLoginException("Invalid login...");
            if (!Verification.isCorrectPassword(password))
                throw new WrongPasswordException("Invalid password...");
            if (!password.equals(confirmPassword))
                throw new WrongPasswordException("Password confirmation does not match the password ...");
        } catch (WrongLoginException | WrongPasswordException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
}
