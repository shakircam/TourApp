package com.example.shaki.newlogin;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class Expense_Fragment extends Fragment {


    private Button addExpense;

    private EditText expenseamount;

    private EditText expenseitem;






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view     =  inflater.inflate(R.layout.fragment_expense_, container, false);

        expenseitem   =  view.findViewById(R.id.expenseitemName);

        expenseamount =  view.findViewById(R.id.expenseAmount);

        addExpense    =  view.findViewById(R.id.addExpense);


        addExpense.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {



            }

        });


        return view;
   }








}
