package com.example.pemrograman_mobile.pertemuan13;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.pemrograman_mobile.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

public class FirestoreActivity extends AppCompatActivity {

    private RecyclerView rv;
    private FloatingActionButton fab;
    private List<modelMhs> list;
    private adapterMhs adapter;
    private modelMhs model;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firestore);

        rv = findViewById(R.id.rv);
        fab = findViewById(R.id.floating_action_button);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        adapter = new adapterMhs(FirestoreActivity.this, list);
        rv.setAdapter(adapter);

        fab.setOnClickListener(view -> startActivity(new Intent(FirestoreActivity.this, InputActivity.class)));

        // Memanggil read data dari firebase
        readData();

    }

    // Membuat fungsi mengambil data
    void readData() {

        db.collection("mahasiswa")
                .get()
                .addOnCompleteListener(task -> {
                   // Jika task sukses
                   if (task.isSuccessful()) {
                       for (QueryDocumentSnapshot documentSnapshot : task.getResult()) {
                           model = new modelMhs(documentSnapshot.getString("namaMhs"), documentSnapshot.getString("fotoMhs"));
                           model.setId(documentSnapshot.getId());
                           list.add(model);
                       }
                       adapter.notifyDataSetChanged();
                   } else {
                       Toast.makeText(this, "Error get document", Toast.LENGTH_SHORT).show();
                   }
                });
    }

    @Override
    protected void onStart() {
        super.onStart();
//        readData();
    }
}