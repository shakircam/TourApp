package com.example.shaki.newlogin;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Toast;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class TourHistoryActivity extends AppCompatActivity implements View.OnClickListener {
    ArrayList<TourInformation> list;
    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    MyAdapter adapter;
    int position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_history);

        recyclerView = findViewById(R.id.recycler_viewId);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        databaseReference = FirebaseDatabase.getInstance().getReference("User");

        list = new ArrayList <TourInformation>();


    }

    @Override
    protected void onStart() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //list.clear();

                for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                {
                    TourInformation tourInformation = dataSnapshot1.getValue(TourInformation.class);
                    list.add(tourInformation);
                }
                adapter = new MyAdapter(list, getApplicationContext(), new MyAdapter.Onclick() {
                    @Override
                    public void onEvent(TourInformation inf, int pos) {
                        position = pos;
                    }
                });

                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(TourHistoryActivity.this, "Error..........Here", Toast.LENGTH_SHORT).show();

            }
        });


        super.onStart();
    }

    @Override
    public void onClick(View v) {

    }
}
