package com.example.pemrograman_mobile.pertemuan11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.pemrograman_mobile.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CobaFloatingButton extends AppCompatActivity {

    FloatingActionButton infoFab, searchFab, addFab;
    Boolean isAllFabsVisible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coba_floating_button);


        infoFab = findViewById(R.id.infoFab);
        searchFab = findViewById(R.id.searchFab);
        addFab = findViewById(R.id.addFab);

        infoFab.setVisibility(View.VISIBLE);
        searchFab.setVisibility(View.GONE);
        addFab.setVisibility(View.GONE);

        isAllFabsVisible = false;

        // Event click FAB
        infoFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!isAllFabsVisible) {
                    searchFab.show();
                    addFab.show();

                    isAllFabsVisible = true;

                } else {
                    searchFab.hide();
                    addFab.hide();

                    isAllFabsVisible = false;
                }
            }
        });
    }
}