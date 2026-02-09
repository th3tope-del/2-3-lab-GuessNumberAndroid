package com.example.guessthenumber;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    TextView tvInfo;
    EditText etInput;
    Button bControl;

    int guess;
    boolean gameFinished;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo = (TextView) findViewById(R.id.textView1);
        etInput = (EditText) findViewById(R.id.editText1);
        bControl = (Button) findViewById(R.id.button1);

        guess = (int) (Math.random() * 100);
        gameFinished = false;
    }

    public void onClick(View v) {
        if (!gameFinished) {
            int input = Integer.parseInt(etInput.getText().toString());

            if (input > guess) {
                tvInfo.setText("Загаданное число меньше");
            }

            if (input < guess) {
                tvInfo.setText("Загаданное число больше");
            }

            if (input == guess) {
                tvInfo.setText("Вы угадали число!");
                bControl.setText("Сыграть ещё");
                gameFinished = true;
            }
        } else {
            guess = (int) (Math.random() * 100);
            tvInfo.setText("Попробуйте угадать число (0–100)");
            bControl.setText("Ввести значение");
            gameFinished = false;
        }

        etInput.setText("");
    }
}
