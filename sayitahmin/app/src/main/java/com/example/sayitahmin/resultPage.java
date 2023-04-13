package com.example.sayitahmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class resultPage extends AppCompatActivity {
    private Button pass_button;
    private Intent intent;
    private ImageView image;
    private TextView resultText,resultNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_page);
        definition();
        takeValues();
        pass_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(resultPage.this, MainActivity.class));
                finish();

            }
        });
    }

    void takeValues() {
        boolean result = getIntent().getBooleanExtra("sonuc",false);
        int num = getIntent().getIntExtra("num",0);
        if (result) {
            image.setImageResource(R.drawable.win);
            resultText.setText("KAZANDINIZ");
            resultNum.setText("");
        }
        else {
            resultNum.setText("aradıgın sayı: " + String.valueOf(num));
        }
    }
    void definition() {
        pass_button = findViewById(R.id.TurnMainMenu_button);
        intent = new Intent(resultPage.this, MainActivity.class);
        image = findViewById(R.id.resultImage);
        resultText = findViewById(R.id.resultText);
        resultNum = findViewById(R.id.result_num);
    }
}