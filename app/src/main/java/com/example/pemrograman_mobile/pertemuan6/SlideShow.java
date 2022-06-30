package com.example.pemrograman_mobile.pertemuan6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.pemrograman_mobile.R;

import java.util.ArrayList;

public class SlideShow extends AppCompatActivity {

//    Deklarasi Widget
    private ImageSlider slider;
    private ArrayList<SlideModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_show);

        slider = findViewById(R.id.imageSlider);

        list = new ArrayList<>();
        list.add(new SlideModel("https://images.unsplash.com/photo-1636858507939-acc6b17bda52?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1858&q=80", ScaleTypes.CENTER_CROP));
        list.add(new SlideModel(R.drawable.gambar1, ScaleTypes.CENTER_CROP));
        list.add(new SlideModel("https://bit.ly/2BteuF2", "Gambar apa ini?", ScaleTypes.CENTER_CROP));

        slider.setImageList(list);
    }
}