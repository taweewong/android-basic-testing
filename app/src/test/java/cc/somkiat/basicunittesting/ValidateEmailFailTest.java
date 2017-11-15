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
    public void emailIsNotContainUsername() {
        EmailValidator validator = new EmailValidator();
        boolean result = validator.isEmailPatternCorrect("@tgmail.com");
        assertFalse("Email's pattern require empty username", result);
    }

    @Test
    public void emailIsNotContainAtSign() {
        EmailValidator validator = new EmailValidator();
        boolean result = validator.isEmailPatternCorrect("taweewong.tgmail.com");
        assertFalse("Email's pattern require non at sign", result);
    }

    @Test
    public void emailHasWrongDomainPattern() {
        EmailValidator validator = new EmailValidator();
        boolean result = validator.isEmailPatternCorrect("taweewong.t@gmailcom");
        assertFalse("Email's pattern require wrong domain pattern", result);
    }
}
