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
 * Use the {@link FragmentTv#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentTv extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView rvTv;
    private ArrayList<PojoTv> listTv = new ArrayList<>();

    public FragmentTv() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentTv.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentTv newInstance(String param1, String param2) {
        FragmentTv fragment = new FragmentTv();
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
        View view = inflater.inflate(R.layout.fragment_tv, container, false);
        rvTv = view.findViewById(R.id.tv_fragment);
        rvTv.setHasFixedSize(true);

        listTv.addAll(getListDataTv());
        showRecyclerViewTv();

        return view;
    }

    private void showRecyclerViewTv() {
        rvTv.setLayoutManager(new LinearLayoutManager(this.getContext()));
        tvAdapter adapter = new tvAdapter(this.getContext());
        adapter.setlistTv(listTv);
        rvTv.setAdapter(adapter);
    }

    private ArrayList<PojoTv> getListDataTv() {
        String[] tvTitle = getResources().getStringArray(R.array.tv_titles);
        String[] tvReleased = getResources().getStringArray(R.array.tv_released);
        String[] tvDesc = getResources().getStringArray(R.array.tv_description);
        String[] tvReview = getResources().getStringArray(R.array.tv_reviews);
        TypedArray tvPoster = getResources().obtainTypedArray(R.array.tv_poster);

        ArrayList<PojoTv> listTv = new ArrayList<>();
        for (int i = 0; i<tvTitle.length; i++) {
            PojoTv tv = new PojoTv();
            tv.setTitle(tvTitle[i]);
            tv.setReleaseDate(tvReleased[i]);
            tv.setDesc(tvDesc[i]);
            tv.setReview(tvReview[i]);
            tv.setPoster(tvPoster.getResourceId(i, -1));
            listTv.add(tv);
        }
        return listTv;
    }
}