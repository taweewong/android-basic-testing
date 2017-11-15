package cc.somkiat.basicunittesting.validator;

public class ValidateResult {
    private boolean isValid;
    private String message;

    public ValidateResult(boolean isValid, String message) {
        this.isValid = isValid;
        this.message = message;
    }

    public boolean isValid() {
        return isValid;
    }

    public String getMessage() {
        return message;
    }
}
