package com.example.pemrograman_mobile.pertemuan7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.pemrograman_mobile.R;

import java.util.ArrayList;

public class RV extends AppCompatActivity {

//    Deklarasi Widget: ImageSlider
    private ImageSlider slider;
    private ArrayList<SlideModel> list;

//    Deklarasi Widget: RecyclerView
    private RecyclerView rv;
    private ArrayList<PojoClass> listPahlawan = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv);

//        ImageSlider
        slider = findViewById(R.id.imageSlider);

        list = new ArrayList<>();
        list.add(new SlideModel("https://images.unsplash.com/photo-1636858507939-acc6b17bda52?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1858&q=80", ScaleTypes.CENTER_CROP));
        list.add(new SlideModel(R.drawable.gambar1, ScaleTypes.CENTER_CROP));
        list.add(new SlideModel("https://bit.ly/2BteuF2", "Gambar apa ini?", ScaleTypes.CENTER_CROP));

        slider.setImageList(list);

//        RecyclerView
        rv = findViewById(R.id.rvPahlawan);
//        Optimalisasi ukuran saat isi adapternya berubah
        rv.setHasFixedSize(true);

        listPahlawan.addAll(DataPahlawan.getListData());

//        Menampilkan RecyclerView
        rv.setLayoutManager(new LinearLayoutManager(this));
        Adapter listAdapter = new Adapter(listPahlawan);
        rv.setAdapter(listAdapter);
    }
}