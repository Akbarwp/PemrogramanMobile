package com.example.pemrograman_mobile.pertemuan5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pemrograman_mobile.R;

public class HasilForm extends AppCompatActivity {

    private TextView txNama, txNIM;
    private Button btnKembali;
    private ImageButton imgKembali;

    private String nim;
    private String nama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_form);

        Bundle extras = getIntent().getExtras();

        nama = extras.getString("KEY_NIM", nama);
        nim = extras.getString("KEY_NAMA", nim);

        txNama = findViewById(R.id.txNama);
        txNIM = findViewById(R.id.txNIM);

        txNama.setText(nim);
        txNIM.setText(nama);

        btnKembali = findViewById(R.id.btnKembali);
        imgKembali = findViewById(R.id.imgKembali);

        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent form1 = new Intent(HasilForm.this, Form1.class);
                startActivity(form1);
            }
        });

        imgKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent form1 = new Intent(HasilForm.this, Form1.class);
                startActivity(form1);
            }
        });
    }
}