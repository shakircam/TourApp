package com.example.shaki.newlogin;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class TourHistoryActivity extends AppCompatActivity {
    ArrayList<TourInformation> list;
    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    MyAdapter adapter;


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
                adapter = new MyAdapter( list,TourHistoryActivity.this);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(TourHistoryActivity.this, "Error..........Here", Toast.LENGTH_SHORT).show();

            }
        });


        super.onStart();
    }
}
