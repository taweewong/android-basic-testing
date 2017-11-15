package cc.somkiat.basicunittesting;

import org.junit.Test;

import cc.somkiat.basicunittesting.exception.ValidateException;
import cc.somkiat.basicunittesting.validator.EmailValidator;
import cc.somkiat.basicunittesting.validator.ValidateResult;

import static junit.framework.Assert.assertTrue;

public class ValidateEmailSuccessTest {

    @Test
    public void emailIsNotEmpty() throws ValidateException {
        EmailValidator validator = new EmailValidator();
        ValidateResult result = validator.validate("taweewong@gmail.com");
        assertTrue(result.getMessage(), result.isValid());
    }

    @Test
    public void emailPatternIsCorrect() {
        EmailValidator validator = new EmailValidator();
        ValidateResult result = validator.validate("taweewong.t@gmail.com");
        assertTrue(result.getMessage(), result.isValid());
    }
}
