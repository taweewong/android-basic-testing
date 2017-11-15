package cc.somkiat.basicunittesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import cc.somkiat.basicunittesting.exception.ValidateException;
import cc.somkiat.basicunittesting.validator.EmailValidator;
import cc.somkiat.basicunittesting.validator.NameValidator;
import cc.somkiat.basicunittesting.validator.ValidateResult;

public class MainActivity extends AppCompatActivity {
    EditText userNameInput;
    EditText emailInput;
    NameValidator nameValidator;
    EmailValidator emailValidator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userNameInput = findViewById(R.id.userNameInput);
        emailInput = findViewById(R.id.emailInput);

        nameValidator = new NameValidator();
        emailValidator = new EmailValidator();
    }

    public void onSaveClick(View view) {
        String name = userNameInput.getText().toString();
        String email = emailInput.getText().toString();

        displayResult(nameValidator.validate(name), emailValidator.validate(email));
    }

    public void onRevertClick(View view) {
        userNameInput.setText("");
        emailInput.setText("");
    }

    private void displayResult(ValidateResult nameResult, ValidateResult emailResult) {
        if (!nameResult.isValid()) {
            Toast.makeText(this, nameResult.getMessage(), Toast.LENGTH_SHORT).show();
        }

        if (!emailResult.isValid()) {
            Toast.makeText(this, emailResult.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
