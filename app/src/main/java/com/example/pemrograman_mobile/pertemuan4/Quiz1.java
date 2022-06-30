package com.example.pemrograman_mobile.pertemuan4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pemrograman_mobile.R;

public class Quiz1 extends AppCompatActivity {

    private EditText edNIM, edNama, edTugas, edUTS, edUAS, edAkhir;
    private Button btnCek, btnSubmit;

    private double tugas, uts, uas, nilaiAkhir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1);

        edNIM = findViewById(R.id.edNIM);
        edNama = findViewById(R.id.edNama);
        edTugas = findViewById(R.id.edTugas);
        edUTS = findViewById(R.id.edUTS);
        edUAS = findViewById(R.id.edUAS);
        edAkhir = findViewById(R.id.edAkhir);

        btnCek = findViewById(R.id.btnCek);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnCek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tugas = Double.parseDouble(edTugas.getText().toString());
                uts = Double.parseDouble(edUTS.getText().toString());
                uas = Double.parseDouble(edUAS.getText().toString());

                nilaiAkhir = (0.4 * tugas) + (0.3 * uts) + (0.3 * uas);
                edAkhir.setText(String.valueOf(nilaiAkhir));
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nilaiAkhir < 80) {
                    Toast.makeText(Quiz1.this, "Maaf, " + edNama.getText() + " Harus Perbaikan", Toast.LENGTH_SHORT).show();

                } else if (nilaiAkhir >= 80) {
                    Toast.makeText(Quiz1.this, "Selamat, " + edNama.getText() + " Lulus", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}