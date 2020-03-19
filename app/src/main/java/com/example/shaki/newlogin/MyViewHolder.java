package com.example.shaki.newlogin;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;



class MyViewHolder extends RecyclerView.ViewHolder {
    TextView title,desc,budget;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        title= itemView.findViewById(R.id.tourTitle);
        desc = itemView.findViewById(R.id.tourDes);
        budget= itemView.findViewById(R.id.tourBudget);

    }
}
