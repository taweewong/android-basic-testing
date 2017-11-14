package cc.somkiat.basicunittesting;

import org.junit.Test;

import cc.somkiat.basicunittesting.validator.NameValidator;

import static junit.framework.Assert.assertTrue;

public class ValidateNameFailTest {

    @Test
    public void nameIsEmpty() {
        NameValidator validator = new NameValidator();
        boolean result = validator.isNameEmpty("");
        assertTrue("Name is not empty", result);
    }
}
