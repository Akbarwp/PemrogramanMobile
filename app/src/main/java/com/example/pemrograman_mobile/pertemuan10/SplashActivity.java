package com.example.pemrograman_mobile.pertemuan10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.pemrograman_mobile.R;
import com.example.pemrograman_mobile.pertemuan8.KatalogFilm;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent home = new Intent(SplashActivity.this, MainSplash.class);
                startActivity(home);
                finish();
            }
        }, 1000);
    }
}