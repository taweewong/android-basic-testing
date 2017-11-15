package cc.somkiat.basicunittesting;

import org.junit.Test;

import cc.somkiat.basicunittesting.validator.NameValidator;
import cc.somkiat.basicunittesting.validator.ValidateResult;

import static junit.framework.Assert.assertTrue;

public class ValidateNameSuccessTest {

    @Test
    public void nameIsNotEmpty() {
        NameValidator validator = new NameValidator();
        ValidateResult result = validator.validate("Taweewong Tocharoen");
        assertTrue(result.getMessage(), result.isValid());
    }

    @Test
    public void namePatternIsCorrect() {
        NameValidator validator = new NameValidator();
        ValidateResult result = validator.validate("Taweewong Tocharoen");
        assertTrue(result.getMessage(), result.isValid());
    }

    @Test
    public void nameLengthIsBetweenTwoAndThirty() {
        NameValidator validator = new NameValidator();
        ValidateResult result = validator.validate("Taweewong Tocharoen");
        assertTrue(result.getMessage(), result.isValid());
    }
}
