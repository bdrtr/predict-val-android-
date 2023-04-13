package com.example.sayitahmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Button pass_button;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        definiton();
        pass_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,oyunPage.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menutoolbar,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_theme:
                changeTheme();
                return true;
            case R.id.action_about:
                //about();
                return true;
            default:
                return false;
        }
    }

    public void changeTheme() {
        int current_mode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        switch (current_mode) {
            case Configuration.UI_MODE_NIGHT_NO:
                getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                break;
            case Configuration.UI_MODE_NIGHT_YES:
                getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                break;
        }
    }
    void definiton() {
        pass_button = findViewById(R.id.start_game_button);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Hadi Tahmin Et!");
        toolbar.setSubtitle("0 ile 100 arasında bir sayı");
        toolbar.setLogo(R.drawable.sun);
        setSupportActionBar(toolbar);
    }


}