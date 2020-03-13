package com.example.shaki.newlogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

import java.util.List;

public class TourHistoryActivity extends AppCompatActivity {
    DatabaseReference databaseReference;
    private FirebaseAuth mAuth;
    private MyAdapter myAdapter;
    FirebaseUser presentUser;
    private RecyclerView recyclerView;
    private Button showData;
    private List<TourInfo> tourList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_history);
    }
}
