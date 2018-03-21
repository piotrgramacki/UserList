package com.example.piotrgramacki238493.userlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InputDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data);

        Button btnAdd = findViewById(R.id.button_add);
        final EditText name_data = findViewById(R.id.name_data);
        final EditText surname_data = findViewById(R.id.surname_data);
        final EditText birthDate_data = findViewById(R.id.birthDate_data);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name_text = name_data.getText().toString();
                String surname_text = surname_data.getText().toString();
                String birthDate_text = birthDate_data.getText().toString();

                if (validInput(name_text, surname_text, birthDate_text)) {
                    Intent result = new Intent();
                    result.putExtra("userName", name_text);
                    result.putExtra("userSurname", surname_text);
                    result.putExtra("userAge", birthDate_text);

                    setResult(MainActivity.RESULT_OK, result);
                    finish();
                }
                else Toast.makeText(
                        getApplicationContext(),
                        getString(R.string.wrong_data),
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    private boolean validInput(String name, String surname, String date) {
        return name.length() != 0 && surname.length() != 0 && User.isDateValid(date);
    }
}
