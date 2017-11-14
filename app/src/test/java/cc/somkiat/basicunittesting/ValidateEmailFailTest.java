package cc.somkiat.basicunittesting;

import org.junit.Test;

import cc.somkiat.basicunittesting.validator.EmailValidator;

import static junit.framework.Assert.assertTrue;

public class ValidateEmailFailTest {

    @Test
    public void emailIsEmpty() {
        EmailValidator validator = new EmailValidator();
        boolean result = validator.isEmailEmpty("");
        assertTrue("Email is not empty", result);
    }
}
