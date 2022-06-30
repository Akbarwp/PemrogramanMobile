package com.example.pemrograman_mobile.pertemuan8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.pemrograman_mobile.R;
import com.example.pemrograman_mobile.pertemuan8.fragment.MovieFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class KatalogFilm extends AppCompatActivity {

    private BottomNavigationView navView;

    // Listener
    private BottomNavigationView.OnNavigationItemSelectedListener listener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                // Kondisi halaman yang ditampilkan dari bottom nav
                switch (item.getItemId()) {
                    case R.id.nav_movies:
                        fragment = new MovieFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment, fragment.getClass().getSimpleName()).commit();
                        return true;

                    case R.id.nav_tvShows:
                        // fragment = new TvFragment();
                        // getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment, fragment.getClass().getSimpleName()).commit();
                        return true;

                }
                return false;
            }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_katalog_film);

        navView = findViewById(R.id.bottom_nav);

        navView.setOnNavigationItemSelectedListener(listener);
        if (savedInstanceState == null) {
            navView.setSelectedItemId(R.id.nav_movies);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bottom_nav_view, menu);
        return super.onCreateOptionsMenu(menu);
    }
}