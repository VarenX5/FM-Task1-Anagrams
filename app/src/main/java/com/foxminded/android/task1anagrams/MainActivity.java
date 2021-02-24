package com.foxminded.android.task1anagrams;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

//import android.app.Reversing;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Reversing reverser = new Reversing();
        TextView wordsOutput = findViewById(R.id.textViewOutput);
        EditText filter = findViewById(R.id.editTextFilter);
        EditText userInput = findViewById(R.id.editTextUserInput);
        filter.addTextChangedListener(new TextWatcher() {
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
        });
        userInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                wordsOutput.setText(Reversing.reverseWords(s.toString(), filter.getText().toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}