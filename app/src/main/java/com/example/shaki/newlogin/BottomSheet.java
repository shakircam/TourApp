package com.example.shaki.newlogin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BottomSheet extends BottomSheetDialogFragment {
    public Context context;
    public int endDate;
    public int startDate;
    public Integer tourAmount;

    private EditText tourNameET, tourDescriptionET, tourBudgetET, tourStartDate, tourEndDate;
    Button saveTrip;
    private String tourNameS, tourDesc, tourTitle;
    String expenseAmountD, tourBudgetD;

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottomsheet_layout, container, false);

        tourNameET = view.findViewById(R.id.tourNameET);
        tourDescriptionET = view.findViewById(R.id.tourDescriptionET);
        tourStartDate = view.findViewById(R.id.startDP);
        tourEndDate = view.findViewById(R.id.endDP);
        tourBudgetET = view.findViewById(R.id.budgetET);
        saveTrip = view.findViewById(R.id.saveTrip);


        saveTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tourTitle = tourNameET.getText().toString();
                tourDesc = tourDescriptionET.getText().toString();
                tourAmount = Integer.valueOf(tourBudgetET.getText().toString()).intValue();
                startDate = Integer.valueOf(tourStartDate.getText().toString()).intValue();
                endDate = Integer.valueOf(tourEndDate.getText().toString()).intValue();


                TourInformation tourInformation = new TourInformation(tourTitle, tourDesc, tourAmount,
                        startDate, endDate, context);

                tourInformation.sendTourDataToDatabase();


            }
        });


        return view;
    }

    public void onAttach(Context context2) {

        super.onAttach(context2);

        this.context = context2;


    }
}
