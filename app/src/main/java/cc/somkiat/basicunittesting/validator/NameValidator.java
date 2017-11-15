package cc.somkiat.basicunittesting.validator;

import java.util.regex.Pattern;

import cc.somkiat.basicunittesting.exception.ValidateException;

public class NameValidator {

    public ValidateResult validate(String name) {
        try {
            isNameNotEmpty(name);
            isNameHasOnlyAlphabet(name);
            isNameLengthIsBetweenTwoAndThirty(name);
        } catch (ValidateException e) {
            return new ValidateResult(false, e.getMessage());
        }

        return new ValidateResult(true, "Name is valid");
    }

    private void isNameNotEmpty(String name) throws ValidateException {
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

    private void isNameLengthIsBetweenTwoAndThirty(String name) throws ValidateException {
        if (name.length() > 2 && name.length() < 30) {
            throw new ValidateException("Name is too short or too long");
        }
    }
}
