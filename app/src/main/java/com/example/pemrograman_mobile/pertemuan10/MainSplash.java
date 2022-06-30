package com.example.pemrograman_mobile.pertemuan10;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pemrograman_mobile.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

public class MainSplash extends AppCompatActivity {

    BottomNavigationView nav;
    Fragment fragment;

    FloatingActionButton infoFab, searchFab, addFab;
    TextView txSearchFab, txAddFab;
    Boolean isAllFabsVisible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_splash);

        nav = findViewById(R.id.bottom_navigation);

        infoFab = findViewById(R.id.infoFab);
        searchFab = findViewById(R.id.searchFab);
        addFab = findViewById(R.id.addFab);

        txSearchFab = findViewById(R.id.txSearchFab);
        txAddFab = findViewById(R.id.txAddFab);

        infoFab.setVisibility(View.VISIBLE);
        searchFab.setVisibility(View.GONE);
        addFab.setVisibility(View.GONE);
        txSearchFab.setVisibility(View.GONE);
        txAddFab.setVisibility(View.GONE);

        isAllFabsVisible = false;

        fragment = new FragmentMovie();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment, fragment.getClass().getSimpleName()).commit();

        // Event click navigasi
        nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // halaman fragmnet (berisi list data atau form atau dll.)

                // Membuat fragment kosong
                fragment = null;

                // Cek menu yang diklik
                switch (item.getItemId()) {
                    case R.id.menu_movie:
                        // Memanggil halaman fragment movie
                        fragment = new FragmentMovie();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment, fragment.getClass().getSimpleName()).commit();
                        break;

                    case R.id.menu_tv:
                        // Memanggil halaman fragment TV
                        fragment = new FragmentTv();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment, fragment.getClass().getSimpleName()).commit();
                        break;
                }
                return true;
            }
        });

        // Event click FAB
        infoFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!isAllFabsVisible) {
                    searchFab.show();
                    addFab.show();
                    txSearchFab.setVisibility(View.VISIBLE);
                    txAddFab.setVisibility(View.VISIBLE);

                    isAllFabsVisible = true;

                } else {
                    searchFab.hide();
                    addFab.hide();
                    txSearchFab.setVisibility(View.GONE);
                    txAddFab.setVisibility(View.GONE);

                    isAllFabsVisible = false;
                }
            }
        });
        
        searchFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainSplash.this, "Searching Button", Toast.LENGTH_SHORT).show();
            }
        });

        addFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainSplash.this, "Add Button", Toast.LENGTH_SHORT).show();
            }
        });

    }

}