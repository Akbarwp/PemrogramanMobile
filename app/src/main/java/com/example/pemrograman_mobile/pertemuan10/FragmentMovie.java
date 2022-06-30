package com.example.pemrograman_mobile.pertemuan10;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pemrograman_mobile.R;
import com.example.pemrograman_mobile.pertemuan8.adapter.movieAdapter;
import com.example.pemrograman_mobile.pertemuan8.pojo.PojoMovies;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentMovie#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentMovie extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView rvMovies;
    private ArrayList<PojoMovies> listMovies = new ArrayList<>();

    public FragmentMovie() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentMovie.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentMovie newInstance(String param1, String param2) {
        FragmentMovie fragment = new FragmentMovie();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie, container, false);
        rvMovies = view.findViewById(R.id.movies_fragment);
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