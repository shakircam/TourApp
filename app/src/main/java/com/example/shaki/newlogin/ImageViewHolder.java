package com.example.shaki.newlogin;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class ImageViewHolder extends RecyclerView.ViewHolder {
  TextView textView;
  ImageView imageView;

    public ImageViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.cardText);
        imageView = itemView.findViewById(R.id.cardImage);
    }
}
