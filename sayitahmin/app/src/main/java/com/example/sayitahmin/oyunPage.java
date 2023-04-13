package com.example.sayitahmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.Random;

public class oyunPage extends AppCompatActivity {

    private Intent intent;
    private Button pass_btn;
    private TextView stateText;
    private EditText takeAnumberEdit;
    ImageView h1,h2,h3,h4,h5,State_im;

    private int kalan_hak = 4, flagB = 0, flagS=0, random_number, predict_num;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oyun_page);
        definition();
        setStart();

        pass_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (takeAnumberEdit.getText().toString().length() != 0) {
                     predict_num = Integer.parseInt(takeAnumberEdit.getText().toString());
                }
                else {
                    Toast.makeText(oyunPage.this, "boş bırakılamaz", Toast.LENGTH_SHORT).show();
                    predict_num = 101;

                }
                int result = gameState(random_number,predict_num);

                if (result == 0) {
                    Toast.makeText(oyunPage.this, "buldun: "+random_number, Toast.LENGTH_SHORT).show();
                    intent.putExtra("sonuc",true);
                    startActivity(intent);
                    finish();
                }

                else if (kalan_hak == 0) {
                    intent.putExtra("sonuc",false);
                    intent.putExtra("num",random_number);
                    startActivity(intent);
                    finish();
                }

                else if (result == 1) {
                    stateText.setText("ARTTIR");
                    State_im.setImageResource(R.drawable.increase);
                }
                else if (result == 2) {
                    stateText.setText("AZALT");
                    State_im.setImageResource(R.drawable.decrease);
                }


                else if (result == -2) {
                    stateText.setText("Sayı 0 ile 100 arasında olmalı");
                    kalan_hak++;
                    State_im.setImageResource(R.drawable.sadface);
                }

                else if (result == -1) {
                    stateText.setText("lutfen bir sayı girin");
                    kalan_hak++;
                    State_im.setImageResource(R.drawable.sadface);
                }
                updateState();

            }
        });
    }

    void setStart() {
        stateText.setText("0 ile 100 arasında bir sayı gir");
    }

    void definition() {

        Random r = new Random();
        random_number = r.nextInt(101);

        intent = new Intent(oyunPage.this, resultPage.class);
        h1 = findViewById(R.id.hearth_1);
        h2 = findViewById(R.id.hearth_2);
        h3 = findViewById(R.id.hearth_3);
        h4 = findViewById(R.id.hearth_4);
        h5 = findViewById(R.id.hearth_5);
        State_im = findViewById(R.id.dec_or_inc_png);
        pass_btn = findViewById(R.id.take_num_button);
        takeAnumberEdit = findViewById(R.id.TakeAnumberEditText);
        stateText = findViewById(R.id.stateText);



    }

    void updateState() {
        kalan_hak--;
        takeAnumberEdit.setText("");
        Log.e("----------------",String.valueOf(kalan_hak));
        switch (kalan_hak+1) {
            case 4:
                h5.setVisibility(View.INVISIBLE);
                break;
            case 3:
                h4.setVisibility(View.INVISIBLE);
                break;
            case 2:
                h3.setVisibility(View.INVISIBLE);
                break;
            case 1:
                h2.setVisibility(View.INVISIBLE);
                State_im.setImageResource(R.drawable.think);
                break;
            case 0:
                h1.setVisibility(View.INVISIBLE);
                break;
        }
    }

    int gameState(int random, int predict) {

        if (predict > 100 || predict < 0)
            return -2;

        else if (predict == random) {
            return 0;
        }
        else if (predict < random) {
            return 1;
        }
        else if (predict > random) {
            return 2;
        }

        else
            return -1;
    }

}