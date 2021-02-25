package com.foxminded.android.task1anagrams;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView wordsOutput = findViewById(R.id.textViewOutput);
        EditText filter = findViewById(R.id.editTextFilter);
        EditText userInput = findViewById(R.id.editTextUserInput);
        TextWatcher tW = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                wordsOutput.setText(Reversing.reverseWords(userInput.getText().toString(), filter.getText().toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

        filter.addTextChangedListener(tW);
        userInput.addTextChangedListener(tW);
    }
}
