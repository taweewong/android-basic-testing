package cc.somkiat.basicunittesting.validator;

import java.util.regex.Pattern;

public class EmailValidator {

    public boolean isEmailEmpty(String email) {
        return email.isEmpty();
    }

    public boolean isEmailPatternCorrect(String email) {
        return Pattern.matches("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}", email);
    }
}
