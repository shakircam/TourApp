package com.example.shaki.newlogin;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TourActivity extends AppCompatActivity implements View.OnClickListener{
    private CardView newTour,tourHistory,tourExpense,tourMoment,nearbyPlace,weather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour);

        newTour = findViewById(R.id.newTour);
        tourHistory = findViewById(R.id.tourHistory);
        tourExpense = findViewById(R.id.tourExpense);
        tourMoment = findViewById(R.id.tourMoment);
        nearbyPlace = findViewById(R.id.nearbyPlace);
        weather = findViewById(R.id.weather);



        newTour.setOnClickListener(this);
        tourHistory.setOnClickListener(this);
        tourExpense.setOnClickListener(this);
        tourMoment.setOnClickListener(this);
        nearbyPlace.setOnClickListener(this);
        weather.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.newTour:
                Intent intent = new Intent(this, TourInfoActivity.class);
                startActivity(intent);
                break;
        }

    }
}

