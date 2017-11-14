package cc.somkiat.basicunittesting.validator;

import java.util.regex.Pattern;

public class NameValidator {

    public boolean isNameEmpty(String name) {
        return name.isEmpty();
    }

    public boolean isNameHasOnlyAlphabet(String name) {
        return Pattern.matches("^[a-zA-Z]+$", name);
    }
}
