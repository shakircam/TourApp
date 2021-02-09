package com.example.shaki.newlogin;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    ArrayList<TourInformation> tourInformation;
    Context context;
    Onclick onclick;

    public interface Onclick {
        void onEvent(TourInformation inf,int pos);
    }

    public MyAdapter(ArrayList<TourInformation> tourInformation, Context context,Onclick onclick) {
        this.tourInformation = tourInformation;
        this.context = context;
        this.onclick = onclick;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.show_tour_info,parent,false);

        return new MyViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        final TourInformation tour = tourInformation.get(position);
        holder.title.setText("Tour Title: "+tour.getTitle());
        holder.desc.setText("Tour Description: "+tour.getDesc());
        //holder.budget.setText("Tour Budget: "+tourInformation.get(position).getBudget());
        holder.budget.setText("Tour Budget: "+tour.getBudget()+" Tk ");
        holder.sDate.setText("Start Date: "+tour.getsDatePicker());
        holder.eDate.setText("End Date: "+tour.geteDatePicker());

        holder.deleteItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tourInformation.remove(position);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return tourInformation.size();
    }
}
