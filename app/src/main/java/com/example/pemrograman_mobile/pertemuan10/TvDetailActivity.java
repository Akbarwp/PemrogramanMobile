package com.example.pemrograman_mobile.pertemuan10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.pemrograman_mobile.R;

public class TvDetailActivity extends AppCompatActivity {

    public static String EXTRA_TV = "extra_tv";

    private ImageView imgFotoDetail;
    private TextView txJudulDetail, txReleaseDetail, txDeskripsiDetail, txReviewDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_detail);

        imgFotoDetail = findViewById(R.id.imgFotoDetailTv);
        txJudulDetail = findViewById(R.id.txJudulDetailTv);
        txReleaseDetail = findViewById(R.id.txReleaseDetailTv);
        txDeskripsiDetail = findViewById(R.id.txDeskripsiDetailTv);
        txReviewDetail = findViewById(R.id.txReviewDetailTv);

        PojoMovies tv = getIntent().getParcelableExtra(EXTRA_TV);

        txJudulDetail.setText(tv.getTitle());
        txReleaseDetail.setText(tv.getReleaseDate());
        txDeskripsiDetail.setText(tv.getDesc());
        txReviewDetail.setText(tv.getReview());

        Glide.with(TvDetailActivity.this).load(tv.getPoster())
                .apply(new RequestOptions().override(350,550))
                .into(imgFotoDetail);
    }
}