package com.example.shaki.newlogin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TourInfoActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    String title,desc,budget;
    private TextView textView;
    private EditText tourtitle,tourDes,tourBudget;
    private Button save;
    private Context context;
    private String key;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_info);
        textView = findViewById(R.id.title);

        tourtitle = findViewById(R.id.tourTitle);
        tourDes = findViewById(R.id.tourDes);
        tourBudget = findViewById(R.id.tourBudget);
        save = findViewById(R.id.saveId);
        databaseReference = FirebaseDatabase.getInstance().getReference("User");

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                saveDataToFireBase();


                Intent intent = new Intent(TourInfoActivity.this,TourHistoryActivity.class);
                Toast.makeText(context, "going", Toast.LENGTH_SHORT).show();


            }
        });

    }

    public void saveDataToFireBase(){
        String title = tourtitle.getText().toString().trim();
        String desc = tourDes.getText().toString().trim();
        String budget = tourBudget.getText().toString().trim();
        String key = databaseReference.push().getKey();

        TourInformation tourInformation = new TourInformation(title,desc,budget);
        databaseReference.child(key).setValue(tourInformation);

        Toast.makeText(getApplicationContext(),"UserProfile Data are saved",Toast.LENGTH_SHORT).show();
        tourtitle.setText("");
        tourDes.setText("");
        tourBudget.setText("");




    }
}


