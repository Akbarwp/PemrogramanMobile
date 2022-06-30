package com.example.pemrograman_mobile.pertemuan10;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pemrograman_mobile.R;
import com.example.pemrograman_mobile.pertemuan8.MovieDetailActivity;

import java.util.ArrayList;

// class untuk menampilkan data (list) sesuai layout item_list yang dibuat
public class movieAdapter extends RecyclerView.Adapter<movieAdapter.ViewHolder> {

    // Deklarasi kelas PojoMovies
    private static ArrayList<PojoMovies> listMovie;
    private Context context;

    // Constructor dari class PojoMovies
    public movieAdapter(ArrayList<PojoMovies> listMovie) {
        this.listMovie = listMovie;
    }

    // Constructor dari Context
    public movieAdapter(Context context) {
        this.context = context;
    }

    // Getter dan Setter
    public static ArrayList<PojoMovies> getListMovie() {
        return listMovie;
    }
    public static void setListMovie(ArrayList<PojoMovies> listMovie) {
        movieAdapter.listMovie = listMovie;
    }

    // Mengisi override methods
    @NonNull
    @Override // inflate layout item_list
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_movies, parent, false);
        return new ViewHolder(view);
    }

    // Penempatan data Pojo ke item_list
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        PojoMovies pm = getListMovie().get(position);

        holder.titleMovie.setText(pm.getTitle());
        holder.descMovie.setText(pm.getDesc());
        holder.releaseMovie.setText(pm.getReleaseDate());

        Glide.with(holder.itemView.getContext()).load(pm.getPoster()).into(holder.posterMovies);
    }

    @Override
    public int getItemCount() {
        return getListMovie().size();
    }

    // Menghubungkan dengan layout XML item_list
    public class ViewHolder extends RecyclerView.ViewHolder {

        // Deklarasi apa yang ada di XML item_list
        private ImageView posterMovies;
        private TextView releaseMovie, descMovie, titleMovie, reviewMovie;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            posterMovies = itemView.findViewById(R.id.posterMovies);
            titleMovie = itemView.findViewById(R.id.titleMovies);
            releaseMovie = itemView.findViewById(R.id.releaseMovies);
            descMovie = itemView.findViewById(R.id.descriptionMovies);

            // event onClick untuk list (req: buat 1 activity baru --> halaman detail)
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Isi yang ditampilkan di halamn 2 sesuai dengan gambar/data yang dipilih
                    int i = getBindingAdapterPosition();
                    PojoMovies movies = getListMovie().get(i);

                    Intent movieDetail = new Intent(itemView.getContext(), MovieDetailActivity.class);
                    itemView.getContext().startActivities(new Intent[]{movieDetail});
                }
            });
        }
    }
}
