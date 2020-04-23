package com.example.shaki.newlogin;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.view.View;



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

            case R.id.tourHistory:
                Intent intent1 = new Intent(this, TourHistoryActivity.class);
                startActivity(intent1);
                break;

            case R.id.tourMoment:
                Intent intent2 = new Intent(this, TourMomentActivity.class);
                startActivity(intent2);
                break;
        }

    }
}

