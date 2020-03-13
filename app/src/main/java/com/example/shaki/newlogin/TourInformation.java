package com.example.shaki.newlogin;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;

public class TourInformation {
    private Context context;
    private String tourTitle,tourDesc,tourId;
    private int startDate,endDate;
    private int tourAmount;
    public String key;
    private FirebaseAuth mAuth;
    private FirebaseDatabase firebaseDatabase;
    Button SaveTour;

    public TourInformation(String tourTitle, String tourDesc, int tourAmount, int startDate, int endDate)
    {

        this.key = "";

    }
    public TourInformation(Context context2)
    {

        this.key = "";

        this.context = context2;

    }

    public TourInformation(String tourTitle, String tourDesc, int tourAmount, int startDate, int endDate, Context context2)
    {
        this.key = "";

        this.tourTitle = tourTitle;

        this.tourDesc = tourDesc;

        this.startDate = startDate;

        this.endDate = endDate;

        this.tourAmount = tourAmount;

        this.context = context2;

    }


    public TourInformation(String tourId, String tourTitle, String tourDesc, int tourAmount, int startDate, int endDate)
    {

        this.key = "";

        this.tourId = this.tourId;

        this.tourTitle = tourTitle;

        this.tourDesc = tourDesc;

        this.tourAmount = tourAmount;

        this.startDate = startDate;

        this.endDate = endDate;

    }

    public void setTourTitle(String tourTitle)
    {
        this.tourTitle = tourTitle;
    }

    public void setTourDesc(String tourDesc)
    {
        this.tourDesc = tourDesc;
    }

    public void setStartDate(int startDate)
    {
        this.startDate = startDate;
    }

    public void setEndDate(int endDate)
    {
        this.endDate = endDate;
    }

    public void setTourAmount(int tourAmount)
    {
        this.tourAmount = tourAmount;
    }

    public void setTourId(String tourId)
    {
        this.tourId = tourId;
    }



    public String getTourTitle() {
        return tourTitle;
    }

    public String getTourDesc() {
        return tourDesc;
    }

    public String getTourId() {
        return tourId;
    }

    public double getStartDate() {
        return startDate;
    }

    public double getEndDate() {
        return endDate;
    }

    public double gettourBudget() {
        return tourAmount;
    }




    void sendTourDataToDatabase() {

        String mail = this.context.getSharedPreferences("userdata", 0).getString("email", "not set");

        if (!TextUtils.isEmpty(mail))

        {

            FirebaseDatabase.getInstance().getReference().child("user").orderByChild("email").equalTo(mail).addListenerForSingleValueEvent(new ValueEventListener()

            {

                public void onDataChange(DataSnapshot snapshot)

                {
                    for (DataSnapshot snap : snapshot.getChildren())

                    {
                        TourInformation.this.key = snap.getKey();


                    }

                    if (!TextUtils.isEmpty(TourInformation.this.key))

                    {

                        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("user").child(TourInformation.this.key);

                        TourInformation tourInformation = new TourInformation(tourTitle,tourDesc,tourAmount,startDate,endDate);

                        String id = ref.child("tourlist").push().getKey();

                        tourInformation.setTourId(id);

                        ref.child("tourlist").child(id).setValue(tourInformation);
                    }

                }


                public void onCancelled(DatabaseError error)
                {

                    Log.d("Key:Error", error.getMessage());

                }

            });

        }

    }

}
