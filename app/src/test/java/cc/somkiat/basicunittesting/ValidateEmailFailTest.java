package cc.somkiat.basicunittesting;

import org.junit.Test;

import cc.somkiat.basicunittesting.validator.EmailValidator;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class ValidateEmailFailTest {

    @Test
    public void emailIsEmpty() {
        EmailValidator validator = new EmailValidator();
        boolean result = validator.isEmailEmpty("");
        assertTrue("Email is not empty", result);
    }

    @Test
    public void emailPatternIsNotContainUsername() {
        EmailValidator validator = new EmailValidator();
        boolean result = validator.isEmailPatternCorrect("@tgmail.com");
        assertFalse("Email's pattern require empty username", result);
    }

    @Test
    public void emailPatternIsNotContainAtSign() {
        EmailValidator validator = new EmailValidator();
        boolean result = validator.isEmailPatternCorrect("taweewong.tgmail.com");
        assertFalse("Email's pattern require non at sign", result);
    }
}
