package cc.somkiat.basicunittesting;

import org.junit.Test;

import cc.somkiat.basicunittesting.validator.NameValidator;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class ValidateNameSuccessTest {

    @Test
    public void nameIsNotEmpty() {
        NameValidator validator = new NameValidator();
        boolean result = validator.isNameEmpty("Taweewong");
        assertFalse("Name is empty", result);
    }

    @Test
    public void nameHasOnlyAlphabet() {
        NameValidator validator = new NameValidator();
        boolean result = validator.isNameHasOnlyAlphabet("Tocharoen");
        assertTrue("Name is not has only alphabet", result);
    }
}
