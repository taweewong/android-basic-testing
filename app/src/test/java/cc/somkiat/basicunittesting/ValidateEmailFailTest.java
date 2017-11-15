package cc.somkiat.basicunittesting;

import org.junit.Test;

import cc.somkiat.basicunittesting.validator.EmailValidator;
import cc.somkiat.basicunittesting.validator.ValidateResult;

import static junit.framework.Assert.assertFalse;

public class ValidateEmailFailTest {

    @Test
    public void emailIsEmpty() {
        EmailValidator validator = new EmailValidator();
        ValidateResult result = validator.validate("");
        assertFalse(result.getMessage(), result.isValid());
    }

    @Test
    public void emailIsNotContainUsername() {
        EmailValidator validator = new EmailValidator();
        ValidateResult result = validator.validate("@tgmail.com");
        assertFalse(result.getMessage(), result.isValid());
    }

    @Test
    public void emailHasWrongUserName() {
        EmailValidator validator = new EmailValidator();
        ValidateResult result = validator.validate("ta$w#e e-wo+ng*t@gmail.com");
        assertFalse(result.getMessage(), result.isValid());
    }

    @Test
    public void emailIsNotContainAtSign() {
        EmailValidator validator = new EmailValidator();
        ValidateResult result = validator.validate("taweewong.tgmail.com");
        assertFalse(result.getMessage(), result.isValid());
    }

    @Test
    public void emailHasWrongDomainPattern() {
        EmailValidator validator = new EmailValidator();
        ValidateResult result = validator.validate("taweewong.t@gmailcom");
        assertFalse(result.getMessage(), result.isValid());
    }

    @Test
    public void emailIsNotContainDomain() {
        EmailValidator validator = new EmailValidator();
        ValidateResult result = validator.validate("taweewong.t@");
        assertFalse(result.getMessage(), result.isValid());
    }
}
