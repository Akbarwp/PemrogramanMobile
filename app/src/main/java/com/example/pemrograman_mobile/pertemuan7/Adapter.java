package com.example.pemrograman_mobile.pertemuan7;

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

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

//    Deklarasi kelas PojoClass
    ArrayList<PojoClass> listData = new ArrayList<>();

//    Constructor dari class PojoCLass
    public Adapter(ArrayList<PojoClass> listData) {
        this.listData = listData;
    }

//    Mengisi override methods
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

//        Meyambungkan layout xml rv_item_list.xml (keyword: Inflater)
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_list, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

//        Untuk memasukkan data ke dalam arraylist
        PojoClass pojo = listData.get(position);

//        Load ImageView dan TextView
        Glide.with(holder.imgFoto.getContext()).load(pojo.getFoto()).into(holder.imgFoto);

        holder.txNama.setText(pojo.getNama());
        holder.txDeskripsi.setText(pojo.getDeskripsi());
    }

//    Mengembalikan nilai RecyclerView
    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

//        Deklarasi Widget di rv_item_list.xml
        ImageView imgFoto;
        TextView txNama, txDeskripsi;

//        Constructor ViewHolder
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgFoto = itemView.findViewById(R.id.imgFoto);
            txNama = itemView.findViewById(R.id.txNama);
            txDeskripsi = itemView.findViewById(R.id.txDeskripsi);
        }
    }
}
