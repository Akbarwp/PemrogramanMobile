package com.example.pemrograman_mobile.pertemuan9;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pemrograman_mobile.R;

public class MainNilaiMahasiswa extends AppCompatActivity {

    EditText edtTugas, edtUTS, edtUAS;
    Button btnHitung;
    TextView txtHasil;
    double hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_nilai_mahasiswa);

        edtTugas=findViewById(R.id.edtTgs);
        edtUTS=findViewById(R.id.edtUTS);
        edtUAS=findViewById(R.id.edtUAS);
        btnHitung=findViewById(R.id.btnHitung);
        txtHasil=findViewById(R.id.txtHasil);

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nilaiMahasiswa nm= new nilaiMahasiswa();

                nm.setTgs(Double.parseDouble(edtTugas.getText().toString()));
                nm.setUts(Double.parseDouble(edtUTS.getText().toString()));
                nm.setUas(Double.parseDouble(edtUAS.getText().toString()));

                hasil=nm.getNilai();

                txtHasil.setText("hasilnya : "+ String.valueOf(hasil));
            }
        });
    }
}
