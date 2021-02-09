package com.example.shaki.newlogin;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class TourInfoActivity extends AppCompatActivity implements
        View.OnClickListener {
    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    String title,desc,budget;
    private TextView textView;
    private EditText tourTitle,tourDes,tourBudget,startDate,endDate;
    private int mYear, mMonth, mDay;
    private Button save;
    private ImageButton sDate,eDate;
    private Context context;
    private String key;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_info);
        textView = findViewById(R.id.title);
        sDate = findViewById(R.id.sDate);
        eDate = findViewById(R.id.eDate);
        tourTitle = findViewById(R.id.tourTitle);
        tourDes = findViewById(R.id.tourDes);
        tourBudget = findViewById(R.id.tourBudget);
        startDate = findViewById(R.id.startDate);
        endDate = findViewById(R.id.endDate);
        save = findViewById(R.id.saveId);
        databaseReference = FirebaseDatabase.getInstance().getReference("User");
        sDate.setOnClickListener(this);
        eDate.setOnClickListener(this);

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
        String title = tourTitle.getText().toString().trim();
        String desc = tourDes.getText().toString().trim();
        String budget = tourBudget.getText().toString().trim();
        String sDatePicker = startDate.getText().toString().trim();
        String eDatePicker = endDate.getText().toString().trim();
        String key = databaseReference.push().getKey();

        TourInformation tourInformation = new TourInformation(title,desc,budget,sDatePicker,eDatePicker);
        databaseReference.child(key).setValue(tourInformation);

        Toast.makeText(getApplicationContext(),"UserProfile Data are saved",Toast.LENGTH_SHORT).show();
        tourTitle.setText("");
        tourDes.setText("");
        tourBudget.setText("");




    }

    @Override
    public void onClick(View v) {
        if (v == sDate) {
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            startDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
        if (v == eDate){
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            endDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
    }
}


