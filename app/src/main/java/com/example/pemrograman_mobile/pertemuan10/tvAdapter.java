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

import java.util.ArrayList;

// class untuk menampilkan data (list) sesuai layout item_list yang dibuat
public class tvAdapter extends RecyclerView.Adapter<tvAdapter.ViewHolder> {

    // Deklarasi kelas PojoTv
    private static ArrayList<PojoTv> listTv;
    private Context context;

    // Constructor dari class PojoTv
    public tvAdapter(ArrayList<PojoTv> listTv) {
        this.listTv = listTv;
    }

    // Constructor dari Context
    public tvAdapter(Context context) {
        this.context = context;
    }

    // Getter dan Setter
    public static ArrayList<PojoTv> getlistTv() {
        return listTv;
    }
    public static void setlistTv(ArrayList<PojoTv> listTv) {
        tvAdapter.listTv = listTv;
    }

    // Mengisi override methods
    @NonNull
    @Override // inflate layout item_list
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_tv, parent, false);
        return new ViewHolder(view);
    }

    // Penempatan data Pojo ke item_list
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        PojoTv pm = getlistTv().get(position);

        holder.titleTv.setText(pm.getTitle());
        holder.descTv.setText(pm.getDesc());
        holder.releaseTv.setText(pm.getReleaseDate());

        Glide.with(holder.itemView.getContext()).load(pm.getPoster()).into(holder.posterTv);
    }

    @Override
    public int getItemCount() {
        return getlistTv().size();
    }

    // Menghubungkan dengan layout XML item_list
    public class ViewHolder extends RecyclerView.ViewHolder {

        // Deklarasi apa yang ada di XML item_list
        private ImageView posterTv;
        private TextView releaseTv, descTv, titleTv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            posterTv = itemView.findViewById(R.id.posterTv);
            titleTv = itemView.findViewById(R.id.titleTv);
            releaseTv = itemView.findViewById(R.id.releaseTv);
            descTv = itemView.findViewById(R.id.descriptionTv);

            // event onClick untuk list (req: buat 1 activity baru --> halaman detail)
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Isi yang ditampilkan di halamn 2 sesuai dengan gambar/data yang dipilih
                    int i = getAdapterPosition();
                    PojoTv Tv = getlistTv().get(i);

                    Intent tvDetail = new Intent(itemView.getContext(), TvDetailActivity.class);
                    itemView.getContext().startActivities(new Intent[]{tvDetail});
                }
            });
        }
    }
}
