package com.example.shaki.newlogin;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;


class MyViewHolder extends RecyclerView.ViewHolder {
    TextView title,desc,budget,sDate,eDate;
    MaterialButton deleteItem;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        title= itemView.findViewById(R.id.tourTitle);
        desc = itemView.findViewById(R.id.tourDes);
        budget= itemView.findViewById(R.id.tourBudget);
        sDate = itemView.findViewById(R.id.sDate_view);
        eDate = itemView.findViewById(R.id.eDate_view);
        deleteItem = itemView.findViewById(R.id.delete_item);

    }
}
