package com.example.pemrograman_mobile.pertemuan5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pemrograman_mobile.R;

public class TugasIntent extends AppCompatActivity {

    private EditText edRecipients, edSubject, edCompose;
    private Button btnSend, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tugas_intent);

        edRecipients = findViewById(R.id.edRecipients);
        edSubject = findViewById(R.id.edSubject);
        edCompose = findViewById(R.id.edCompose);
        btnSend = findViewById(R.id.btnSend);
        btnCancel = findViewById(R.id.btnCancel);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {edRecipients.getText().toString()});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, edSubject.getText().toString());
                emailIntent.putExtra(Intent.EXTRA_TEXT, edCompose.getText().toString());

                startActivity(Intent.createChooser(emailIntent, "Mengirim Email"));
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edRecipients.setText("");
                edSubject.setText("");
                edCompose.setText("");
            }
        });
    }
}
