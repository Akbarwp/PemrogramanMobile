package com.example.pemrograman_mobile.pertemuan13;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.pemrograman_mobile.R;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class InputActivity extends AppCompatActivity {

    EditText nama;
    Button submit;
    ImageView foto;

    String name;

    // Akses Firestore
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseStorage storage = FirebaseStorage.getInstance();

    // Deklarasi untuk mengambil photo
    ActivityResultLauncher<Intent> activityResultLauncherPhoto;
    ActivityResultLauncher<String> activityResultLauncherGallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        nama = findViewById(R.id.textNama);
        submit = findViewById(R.id.btnSubmit);
        foto = findViewById(R.id.foto);

        // Event click button submit
        submit.setOnClickListener(view -> {

            // Memanggil fungsi insert dan uploud foto sesuai parameter (EditText & ImageView)
            name = nama.getText().toString();
            uploudImage(name);
        });

        // Event click button pilih foto
        foto.setOnClickListener(view -> {
            // Memanggil fungsi select Image
            selectImage();
        });

        // Receiver (menerima intent) --> mengambil foto dari kamera
        // Cara 1 --> startActivityforResult
        // Cara 2
        activityResultLauncherPhoto = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            Thread thread = new Thread(() -> {
                // Setiap intent yang mengakses aplikasi bawaan dari HP terdapat kode
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    // open camera
                    Bundle bundle = result.getData().getExtras();
                    Bitmap bitmap = (Bitmap) bundle.get("data");
                    foto.post(() -> foto.setImageBitmap(bitmap));
                }
            });
            thread.start();
        });

        // Mengambil foto dari galeri
        activityResultLauncherGallery = registerForActivityResult(new ActivityResultContracts.GetContent(), result -> {
            if (result != null) {
                foto.setImageURI(result);
            }
        });

    }

    void insert(String nama, String foto) {
        Map<String, Object> user = new HashMap<>();
        user.put("namaMhs", nama);
        user.put("fotoMhs", foto);

        // Membuat collection (tabel), document (kumpulan field-field + value)
        db.collection("mahasiswa")
                .add(user)
                .addOnSuccessListener(documentReference -> {
                    Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show();
                    finish();
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                });
    }

    void selectImage() {
        CharSequence[] itemImage = {"Take a photo", "Choose from gallery", "Cancel"};
        AlertDialog.Builder builder = new AlertDialog.Builder(InputActivity.this);

        builder.setItems(itemImage, (DialogInterface dialog, int i) -> {

            if (itemImage[i].equals("Take a photo")) {
                // intent untuk buka kamera
                Intent intentPhoto = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                // Call intent
                activityResultLauncherPhoto.launch(intentPhoto);

            } else if (itemImage[i].equals("Choose from gallery")) {
                // Call activityResult
                activityResultLauncherGallery.launch("image/*");

            } else {
                dialog.dismiss();
            }
        });
        builder.show();
    }

    // Uploud foto
    void uploudImage(String photo) {
        foto.setDrawingCacheEnabled(true);
        foto.buildDrawingCache();
        Bitmap bitmap = ((BitmapDrawable) foto.getDrawable()).getBitmap();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
        byte[] byteData = outputStream.toByteArray();

        // Membuat penyimpanan/storage di Firestore
        StorageReference reference = storage.getReference("images").child("IMG" + new Date().getTime() + ".jpeg");
        UploadTask uploudTask = reference.putBytes(byteData);
        uploudTask.addOnFailureListener(e -> {
            Toast.makeText(this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        })
                .addOnSuccessListener(taskSnapshot -> {
            if (taskSnapshot.getMetadata().getReference() != null) {
                taskSnapshot.getMetadata().getReference().getDownloadUrl()
                        .addOnCompleteListener(task -> {
                            if (task.getResult() != null) {
                                insert(photo, task.getResult().toString());
                            }
                        });
            } else {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}