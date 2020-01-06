package com.princedev.coddinggeek.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


import com.princedev.coddinggeek.Model.Language;
import com.princedev.coddinggeek.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class LanguageAdapter extends RecyclerView.Adapter<LanguageAdapter.MyViewHolder> {

    private Context context;
    private List<Language> languageList;

    public LanguageAdapter(Context context, List<Language> languageList) {
        this.context = context;
        this.languageList = languageList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.language_item, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        Log.d("DATA LANGUAGE", "onBindViewHolder: "+ languageList);
        Picasso.get().load(languageList.get(position).getImage()).into(myViewHolder.imageButton);
    }

    @Override
    public int getItemCount() {
        return languageList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageButton imageButton;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageButton = itemView.findViewById(R.id.language_image);

        }
    }
}
