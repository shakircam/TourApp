package com.example.shaki.newlogin;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class TourMomentActivity extends AppCompatActivity {
    ArrayList<UplodeImage> list1;
    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    ImageAdapter imageAdapter;
    //ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_moment);
        FloatingActionButton fab = findViewById(R.id.fabId);
       //progressBar = findViewById(R.id.prgressbarId);
        recyclerView = findViewById(R.id.recyclerid);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.hasFixedSize();
        databaseReference = FirebaseDatabase.getInstance().getReference("User");
        list1 = new ArrayList <UplodeImage>();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TourMomentActivity.this,UplodeTourMomentActivity.class);
                startActivity(intent);
            }
        });
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot2:dataSnapshot.getChildren())
                {
                    UplodeImage uplodeImage = dataSnapshot2.getValue(UplodeImage.class);
                    list1.add(uplodeImage);
                }
                imageAdapter = new ImageAdapter(TourMomentActivity.this,list1);
                recyclerView.setAdapter(imageAdapter);

                //progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), "Database Retrieve Error..........", Toast.LENGTH_SHORT).show();
               // progressBar.setVisibility(View.INVISIBLE);

            }
        });
    }
}
