package cc.somkiat.basicunittesting.validator;

import java.util.regex.Pattern;

import cc.somkiat.basicunittesting.exception.ValidateException;

public class EmailValidator {

    public ValidateResult validate(String email) {
        try {
            isNotEmailEmpty(email);
            isEmailPatternCorrect(email);
        } catch (ValidateException e) {
            return new ValidateResult(false, e.getMessage());
        }

        return new ValidateResult(true, "Email is valid");
    }

    private void isNotEmailEmpty(String email) throws ValidateException {
        if (email.isEmpty()) {
            throw new ValidateException("Email is empty");
        }
    }

    private void isEmailPatternCorrect(String email) throws ValidateException {
        String emailPattern = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}";

        if (!Pattern.matches(emailPattern, email)) {
            throw new ValidateException("Email Pattern is incorrect");
        }
    }
}
