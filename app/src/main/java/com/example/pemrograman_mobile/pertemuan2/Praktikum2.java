package com.example.pemrograman_mobile.pertemuan2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.pemrograman_mobile.R;

public class Praktikum2 extends AppCompatActivity {

//    Inisialisasi atribut xml
    EditText txNama;
    EditText txNIM;
    Button btProses;
    ImageView gambar1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_praktikum2);

//        Menghubungkan variabel atribut di Java dengan xml
        txNama = findViewById(R.id.txNama);
        txNIM = findViewById(R.id.txNIM);

        gambar1 = findViewById(R.id.gambar1);

        btProses = findViewById(R.id.btProses);

        btProses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Praktikum2.this, txNama.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}