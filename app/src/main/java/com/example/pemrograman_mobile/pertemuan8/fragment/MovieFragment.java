package com.example.pemrograman_mobile.pertemuan8.fragment;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pemrograman_mobile.R;
import com.example.pemrograman_mobile.pertemuan8.adapter.movieAdapter;
import com.example.pemrograman_mobile.pertemuan8.pojo.PojoMovies;

import java.util.ArrayList;


public class MovieFragment extends Fragment {

    private RecyclerView rvMovies;
    private ArrayList<PojoMovies> listMovies = new ArrayList<>();

    public MovieFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_movies_rv, container, false);
        rvMovies = view.findViewById(R.id.rv_movies);
        rvMovies.setHasFixedSize(true);

        listMovies.addAll(getListDataMovies());
        showRecyclerViewMovie();
        return view;
    }

    private void showRecyclerViewMovie() {
        rvMovies.setLayoutManager(new LinearLayoutManager(this.getContext()));
        movieAdapter adapter = new movieAdapter(this.getContext());
        adapter.setListMovie(listMovies);
        rvMovies.setAdapter(adapter);
    }

    private ArrayList<PojoMovies> getListDataMovies() {
        String[] movieTitle = getResources().getStringArray(R.array.mv_titles);
        String[] movieReleased = getResources().getStringArray(R.array.mv_released);
        String[] movieDesc = getResources().getStringArray(R.array.mv_description);
        String[] movieReview = getResources().getStringArray(R.array.mv_reviews);
        TypedArray moviePoster = getResources().obtainTypedArray(R.array.mv_poster);

        ArrayList<PojoMovies> listMovies = new ArrayList<>();
        for (int i = 0; i<movieTitle.length; i++) {
            PojoMovies movies = new PojoMovies();
            movies.setTitle(movieTitle[i]);
            movies.setReleaseDate(movieReleased[i]);
            movies.setDesc(movieDesc[i]);
            movies.setReview(movieReview[i]);
            movies.setPoster(moviePoster.getResourceId(i, -1));
            listMovies.add(movies);
        }

        return listMovies;
    }


}
