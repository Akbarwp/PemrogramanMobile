package com.example.pemrograman_mobile.pertemuan3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pemrograman_mobile.R;

public class Login extends AppCompatActivity {

    //    Inisialisasi atribut xml
    private EditText edUser, edPass;
    private Button btnLogin, btnTambah, btnKurang;
    private TextView txUser, txPass, txPesan, txKumulatif;

    //    Membuat variabel tambahan
    private String Username, Password;

    int x, kumulatif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

//        Menghubungkan variabel atribut di Java dengan xml
        edUser = findViewById(R.id.edUser);
        edPass = findViewById(R.id.edPass);
        btnLogin = findViewById(R.id.btnLogin);
        btnTambah = findViewById(R.id.btnTambah);
        btnKurang = findViewById(R.id.btnKurang);
        txPesan = findViewById(R.id.txPesan);
        txKumulatif = findViewById(R.id.txKumulatif);

//        Cara1:
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//            Set username dan password
                Username = "admin";
                Password = "1234";

                String pesan = "Success, Hai " + edUser.getText().toString();

                if (edUser.getText().toString().equals(Username) && edPass.getText().toString().equals(Password)) {
                    txPesan.setText(pesan);
                    Toast.makeText(Login.this, pesan, Toast.LENGTH_SHORT).show();
                } else {
                    txPesan.setText("Gagal Login");
                    Toast.makeText(Login.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

////    Cara2: pakai implement View.OnClickListener
//    @Override
//    public void onClick(View view) {
//        if (view == btnLogin) {
//            Username = "admin";
//            Password = "1234";
//
//            if (edUser.getText().toString().equals(Username) && edPass.getText().toString().equals(Password)) {
//                Toast.makeText(this, "Succsess", Toast.LENGTH_SHORT).show();
//            } else {
//                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
//            }
//        }
//    }

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kumulatif = x++;
                txKumulatif.setText(String.valueOf(kumulatif));
            }
        });

        btnKurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kumulatif = x--;
                txKumulatif.setText(String.valueOf(kumulatif));
            }
        });
    }
}