package com.example.shaki.newlogin;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    private AdapterView.OnItemClickListener mListener;
    private AdapterView.OnItemLongClickListener mlongClickListener;
    List<TourInfo> tourList;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.show_tour_info, parent, false), this.mListener);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        TextView textView = myViewHolder.tourTitle;

        StringBuilder sb = new StringBuilder();

        sb.append("Tour Titile: ");

        sb.append(((TourInfo) this.tourList.get(position)).getTourTitle());

        textView.setText(sb.toString());


        TextView textView2 = myViewHolder.tourDesc;

        StringBuilder sb2 = new StringBuilder();

        sb2.append("Tour Desc: ");

        sb2.append(((TourInfo) this.tourList.get(position)).getTourDesc());

        textView2.setText(sb2.toString());


        TextView textView3 = myViewHolder.tourAmount;

        StringBuilder sb3 = new StringBuilder();

        sb3.append("Tour Budget: ");

        sb3.append(String.valueOf(((TourInfo) this.tourList.get(position)).getTourAmount()));

        textView3.setText(sb3.toString());


        TextView textView4 = myViewHolder.startDate;

        StringBuilder sb4 = new StringBuilder();

        sb4.append("Start Date: ");

        sb4.append(String.valueOf(((TourInfo) this.tourList.get(position)).getStartDate()));

        textView4.setText(sb4.toString());


        TextView textView5 = myViewHolder.endDate;

        StringBuilder sb5 = new StringBuilder();

        sb5.append("End Date: ");

        sb5.append(String.valueOf(((TourInfo) this.tourList.get(position)).getEndDate()));

        textView5.setText(sb5.toString());


    }

    @Override
    public int getItemCount() {
        if (this.tourList != null)
        {
            return this.tourList.size();
        }
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView deleteTv;
        public TextView detailsTv;
        public TextView endDate;
        public TextView memoryTv;
        public TextView startDate;
        public TextView tourAmount;
        public TextView tourDesc;
        public TextView tourTitle;

        public MyViewHolder(@NonNull View itemView, final AdapterView.OnItemClickListener listener) {
            super(itemView);

            tourTitle =   itemView.findViewById(R.id.tourTitle);
            tourDesc =    itemView.findViewById(R.id.tourDesc);
            tourAmount =  itemView.findViewById(R.id.tourAmount);
            startDate =   itemView.findViewById(R.id.startDate);
            endDate =     itemView.findViewById(R.id.endDate);
            detailsTv =   itemView.findViewById(R.id.detailsTv);
            memoryTv =    itemView.findViewById(R.id.memoryTv);
            deleteTv =    itemView.findViewById(R.id.deleteTv);


            itemView.setOnClickListener(new View.OnClickListener(MyAdapter.this) {


                public void onClick(View view) {


                    if (listener != null) {

                        int position = MyViewHolder.this.getAdapterPosition();

                        if (position != -1) {

                            listener.onItemClick(position);

                        }

                    }

                }

            });

        }

    }


    public interface OnItemClickListener
    {

        void onItemClick(int i);

    }


    public void setOnItemClickListener(OnItemClickListener listener) {

        this.mListener = (AdapterView.OnItemClickListener) listener;

    }


    public MyAdapter(Context context2, List<TourInfo> tourList2) {

        this.context = context2;

        this.tourList = tourList2;


    }
    }


}
