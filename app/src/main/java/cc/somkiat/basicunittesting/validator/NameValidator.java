package cc.somkiat.basicunittesting.validator;

import java.util.regex.Pattern;

import cc.somkiat.basicunittesting.exception.ValidateException;

public class NameValidator {

    public ValidateResult validate(String name) {
        try {
            isNameEmpty(name);
            isNameHasOnlyAlphabet(name);
        } catch (ValidateException e) {
            return new ValidateResult(false, e.getMessage());
        }

        return new ValidateResult(true, "Name is valid");
    }

    private void isNameEmpty(String name) throws ValidateException {
        if (name.isEmpty()) {
            throw new ValidateException("Name is empty");
        }
    }

    private void isNameHasOnlyAlphabet(String name) throws ValidateException {
        String namePattern = "[a-zA-Z]+ ?[a-zA-Z]+";

        if (!Pattern.matches(namePattern, name)) {
            throw new ValidateException("Name Pattern is incorrect");
        }
    }
}
