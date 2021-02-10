package com.example.shaki.newlogin;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.view.View;



public class TourActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour);

        CardView newTour = findViewById(R.id.newTour);
        CardView tourHistory = findViewById(R.id.tourHistory);
        CardView tourExpense = findViewById(R.id.tourExpense);
        CardView tourMoment = findViewById(R.id.tourMoment);
        CardView nearbyPlace = findViewById(R.id.nearbyPlace);
        CardView weather = findViewById(R.id.weather);



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


            case R.id.weather:
                Intent intent3 = new Intent(this, WeatherActivity.class);
                startActivity(intent3);
                break;

            case R.id.tourExpense:
                Intent intent4 = new Intent(this, ExpenseActivity.class);
                startActivity(intent4);
                break;
        }

    }
}

