package cc.somkiat.basicunittesting;

import org.junit.Test;

import cc.somkiat.basicunittesting.validator.EmailValidator;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class ValidateEmailSuccessTest {

    @Test
    public void emailIsNotEmpty() {
        EmailValidator validator = new EmailValidator();
        boolean result = validator.isEmailEmpty("taweewong@gmail.com");
        assertFalse("Email is empty", result);
    }

    @Test
    public void emailPatternIsCorrect() {
        EmailValidator validator = new EmailValidator();
        boolean result = validator.isEmailPatternCorrect("taweewong.t@gmail.com");
        assertTrue("Email's pattern is incorrect", result);
    }
}
