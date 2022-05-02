package cinema.security;

import cinema.domain.exceptions.WrongPasswordException;

public class StatisticsPasswordValidator {

    public static void validatePassword(String password) {
        if (password != null && password.equals("super_secret")) {
        } else {
            throw new WrongPasswordException("Wrong password");
        }
    }
}
