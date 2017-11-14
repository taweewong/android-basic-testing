package cc.somkiat.basicunittesting;

import org.junit.Test;

import cc.somkiat.basicunittesting.validator.EmailValidator;

import static junit.framework.Assert.assertFalse;

public class ValidateEmailSuccessTest {

    @Test
    public void emailIsNotEmpty() {
        EmailValidator validator = new EmailValidator();
        boolean result = validator.isEmailEmpty("taweewong@gmail.com");
        assertFalse("Email is empty", result);
    }
}
