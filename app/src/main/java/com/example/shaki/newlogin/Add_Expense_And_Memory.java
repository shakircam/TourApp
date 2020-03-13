package com.example.shaki.newlogin;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Add_Expense_And_Memory extends AppCompatActivity {
    public Button addexpense;
    public Button addmemory;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__expense__and__memory);

        addexpense =  findViewById(R.id.expenseId);

        addmemory =  findViewById(R.id.memoryId);


        replaceFragment(new Expense_Fragment());

        addexpense.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

        addmemory.setBackgroundColor(getResources().getColor(R.color.white));

        addexpense.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {


                Add_Expense_And_Memory.replaceFragment(new Expense_Fragment());

                Add_Expense_And_Memory.addexpense.setBackgroundColor(Add_Expense_And_Memory.getResources().getColor(R.color.white));

                Add_Expense_And_Memory.addmemory.setBackgroundColor(Add_Expense_And_Memory.getResources().getColor(R.color.colorPrimary));

            }

        });

        addmemory.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Add_Expense_And_Memory.replaceFragment(new Memory_Fragment());

                Add_Expense_And_Memory.addexpense.setBackgroundColor(Add_Expense_And_Memory.getResources().getColor(R.color.white));

                Add_Expense_And_Memory.addmemory.setBackgroundColor(Add_Expense_And_Memory.getResources().getColor(R.color.colorPrimary));

            }

        });

    }


    public void replaceFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        fragmentTransaction.replace(R.id.framelayout, fragment);

        fragmentTransaction.commit();

    }
    }
}
