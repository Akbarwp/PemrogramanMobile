package com.example.pemrograman_mobile.pertemuan13;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pemrograman_mobile.R;

import java.util.List;

public class adapterMhs extends RecyclerView.Adapter<adapterMhs.MyHolder> {

    private Context context;
    private List<modelMhs> list;


    public adapterMhs(Context context, List<modelMhs> list) {
        this.context = context;
        this.list = list;
    }


    public Context getContext() {
        return context;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_firestore, parent,false);
        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        modelMhs m = list.get(position);
        holder.output.setText(m.getNama());
        Glide.with(context).load(list.get(position).getFoto()).into(holder.foto);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView output;
        ImageView foto;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            output = itemView.findViewById(R.id.textView);
            foto = itemView.findViewById(R.id.foto);


        }
    }
}
