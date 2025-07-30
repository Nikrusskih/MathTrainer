package com.example.calculator;

import android.annotation.SuppressLint;
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

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView textViewExample;

    Random random = new Random();
    int correctAnswer;
    int winScore = 0;
    int loseScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextAnswer = findViewById(R.id.editTextAnswer); /*поле ввода*/
        Button buttonAnswer = findViewById(R.id.buttonAnswer); /*кнопка*/
        TextView textViewCorrect = findViewById(R.id.textViewCorrectAnswer); /*правильный ответ*/
        TextView textViewIncorrect = findViewById(R.id.textViewIncorrect); /*неправильный ответ*/

//        TextView textViewExample = findViewById(R.id.textViewExample);
        getRandomAnswer();


        buttonAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editTextAnswer.getText().toString();
                int number = Integer.parseInt(text);
                if (number == correctAnswer) {
                    textViewCorrect.setVisibility(View.VISIBLE);
                    textViewIncorrect.setVisibility(View.GONE);

                    editTextAnswer.setText("");
                    getRandomAnswer();

                } else {
                    textViewCorrect.setVisibility(View.GONE);
                    textViewIncorrect.setVisibility(View.VISIBLE);

                    editTextAnswer.setText("");
                    getRandomAnswer();
                }
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void getRandomAnswer() {
        int num1 = random.nextInt(100) + 1;
        int num2 = random.nextInt(100) + 1;
        int operator = random.nextInt(4); // 0: +, 1: -, 2: *, 3: /

        String operationSymbol = "";

        switch (operator) {
            case 0:
                correctAnswer = num1 + num2;
                operationSymbol = "+";
                break;
            case 1:
                correctAnswer = num1 - num2;
                operationSymbol = "-";
                break;
            case 2:
                correctAnswer = num1 * num2;
                operationSymbol = "*";
                break;
            case 3:
                correctAnswer = num1 / num2;
                operationSymbol = "/";
                break;
        }
        TextView textViewExample = findViewById(R.id.textViewExample);
        textViewExample.setText(num1 + " " + operationSymbol + " " + num2 + " = ? ");
    }
}