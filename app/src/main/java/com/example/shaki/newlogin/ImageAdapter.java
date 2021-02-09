package com.example.shaki.newlogin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.*;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class ImageAdapter extends RecyclerView.Adapter<ImageViewHolder> {
  private Context context;
  private ArrayList<UplodeImage> uplodeImageArrayList;

  public ImageAdapter(Context context, ArrayList<UplodeImage> uplodeImageArrayList) {
    this.context = context;
    this.uplodeImageArrayList = uplodeImageArrayList;
  }

  @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
      View view1 = LayoutInflater.from(context).inflate(R.layout.uplode_image,parent,false);
      ImageViewHolder imageViewHolder = new ImageViewHolder(view1);
        return imageViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int i) {
      UplodeImage uplodeImage = uplodeImageArrayList.get(i);
      holder.textView.setText(uplodeImage.getImageDescription());
      Picasso.get()
              .load(uplodeImage.getImageUrl())
              .placeholder(R.drawable.tree)
              .fit().centerCrop()
              .into( holder.imageView);

//      Glide.with(holder.imageView)
//              .load(uplodeImage.getImageUrl())
//              .into(holder.imageView);

    }

    @Override
    public int getItemCount()
    {

      return uplodeImageArrayList.size();
    }
}
