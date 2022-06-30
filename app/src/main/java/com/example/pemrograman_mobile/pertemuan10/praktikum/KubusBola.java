package com.example.pemrograman_mobile.pertemuan10.praktikum;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pemrograman_mobile.R;

public class KubusBola extends AppCompatActivity {

    private EditText panjang;
    private TextView kubus, bola;
    private Button btnHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kubus_bola);

        panjang = findViewById(R.id.edPanjang);
        kubus = findViewById(R.id.txKubus);
        bola = findViewById(R.id.txBola);
        btnHasil = findViewById(R.id.btnHasil);

        btnHasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                RumusKubusBola rumus = new RumusKubusBola();

                rumus.setPanjang(Double.parseDouble(panjang.getText().toString()));

                kubus.setText(String.valueOf(rumus.rumusKubus()));
                bola.setText(String.valueOf(rumus.rumusBola()));
            }
        });
    }
}