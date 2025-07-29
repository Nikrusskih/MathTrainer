package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextAnswer = findViewById(R.id.editTextAnswer);
        Button buttonAnswer = findViewById(R.id.buttonAnswer);
        TextView textViewIncorrect = findViewById(R.id.textViewIncorrect);
        TextView textViewCorrect = findViewById(R.id.textViewCorrectAnswer);

        TextView textViewExample = findViewById(R.id.textViewExample);

        textViewExample.setText("10 + 20 = ?");


        buttonAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editTextAnswer.getText().toString();
                int number = Integer.parseInt(text);
                if (number == 30) {
                    textViewCorrect.setVisibility(View.VISIBLE);
                    textViewIncorrect.setVisibility(View.GONE);
                } else {
                    textViewCorrect.setVisibility(View.GONE);
                    textViewIncorrect.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}