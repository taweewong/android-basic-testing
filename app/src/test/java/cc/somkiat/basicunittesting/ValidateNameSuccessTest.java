package cc.somkiat.basicunittesting;

import org.junit.Test;

import cc.somkiat.basicunittesting.validator.NameValidator;

import static junit.framework.Assert.assertFalse;

public class ValidateNameSuccessTest {

    @Test
    public void nameIsNotEmpty() {
        NameValidator validator = new NameValidator();
        boolean result = validator.isNameEmpty("Taweewong");
        assertFalse("Name is empty", result);
    }
}
