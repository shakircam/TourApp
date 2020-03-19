package com.example.shaki.newlogin;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    ArrayList<TourInformation> tourInformation;
    Context context;

    public MyAdapter(ArrayList<TourInformation> tourInformation, Context context) {
        this.tourInformation = tourInformation;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.show_tour_info,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.title.setText("Tour Title: "+tourInformation.get(position).getTitle());
        holder.desc.setText("Tour Description: "+tourInformation.get(position).getDesc());
        holder.budget.setText("Tour Budget: "+tourInformation.get(position).getBudget());

    }

    @Override
    public int getItemCount() {
        return tourInformation.size();
    }
}
