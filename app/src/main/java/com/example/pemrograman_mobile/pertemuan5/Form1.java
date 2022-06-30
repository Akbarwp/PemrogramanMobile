package com.example.pemrograman_mobile.pertemuan5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pemrograman_mobile.R;

public class Form1 extends AppCompatActivity implements View.OnClickListener {

    private EditText edNama, edNIM;
    private Button btnKirim, btnGoogle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form1);

        edNama = findViewById(R.id.edNama);
        edNIM = findViewById(R.id.edNIM);

        btnKirim = findViewById(R.id.btnKirim);
        btnGoogle = findViewById(R.id.btnGoogle);

        btnKirim.setOnClickListener(this);
        btnGoogle.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == btnKirim) {
            if (edNIM != null && edNama != null) {
//            Perpindahan activity ke activity lain
                Intent hslForm = new Intent(Form1.this, HasilForm.class);

                hslForm.putExtra("KEY_NAMA", edNama.getText().toString());
                hslForm.putExtra("KEY_NIM", edNIM.getText().toString());

//            Start intent
                startActivity(hslForm);
                
            } else {
                Toast.makeText(this, "Masukkan Nama dan NIM Anda", Toast.LENGTH_SHORT).show();
            }

        } else if (view == btnGoogle) {
            Uri linkGoogle = Uri.parse("https://www.google.co.id/");
            Intent google = new Intent(Intent.ACTION_VIEW, linkGoogle);
            startActivity(google);
        }
    }
}