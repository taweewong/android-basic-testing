package cc.somkiat.basicunittesting;

import org.junit.Test;

import cc.somkiat.basicunittesting.validator.NameValidator;
import cc.somkiat.basicunittesting.validator.ValidateResult;

import static junit.framework.Assert.assertFalse;

public class ValidateNameFailTest {

    @Test
    public void nameIsEmpty() {
        NameValidator validator = new NameValidator();
        ValidateResult result = validator.validate("");
        assertFalse(result.getMessage(), result.isValid());
    }

    @Test
    public void nameNotHasOnlyAlphabet() {
        NameValidator validator = new NameValidator();
        ValidateResult result = validator.validate("Taweewong 123");
        assertFalse(result.getMessage(), result.isValid());
    }

    @Test
    public void nameIsTooShort() {
        NameValidator validator = new NameValidator();
        ValidateResult result = validator.validate("Ta");
        assertFalse(result.getMessage(), result.isValid());
    }
}
