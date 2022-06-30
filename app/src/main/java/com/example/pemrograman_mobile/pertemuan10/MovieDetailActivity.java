package com.example.pemrograman_mobile.pertemuan10;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.pemrograman_mobile.R;

public class MovieDetailActivity extends AppCompatActivity {

    private ImageView imgFotoDetail;
    private TextView txJudulDetail, txReleaseDetail, txDeskripsiDetail, txReviewDetail;

    public static String EXTRA_MOVIE = "extra_movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        imgFotoDetail = findViewById(R.id.imgFotoDetail);
        txJudulDetail = findViewById(R.id.txJudulDetail);
        txReleaseDetail = findViewById(R.id.txReleaseDetail);
        txDeskripsiDetail = findViewById(R.id.txDeskripsiDetail);
        txReviewDetail = findViewById(R.id.txReviewDetail);

        // Ambil paket EXTRA_MOVIE dari adapter
        PojoMovies movies =  getIntent().getParcelableExtra(EXTRA_MOVIE);

        txJudulDetail.setText(movies.getTitle());
        txReleaseDetail.setText(movies.getReleaseDate());
        txDeskripsiDetail.setText(movies.getDesc());
        txReviewDetail.setText(movies.getReview());

        // Set gambar
        Glide.with(MovieDetailActivity.this).load(movies.getPoster())
                .apply(new RequestOptions()).into(imgFotoDetail);

    }
}
