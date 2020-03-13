package com.example.shaki.newlogin;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class TourInfoActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "TourInfoActivity";
    private FloatingActionButton floatingActionButton;
    private BottomSheet bottomSheet;
    private Context context;
    public DatabaseReference databaseReference;
    private String expenseAmount;
    public String key = "";
    public RecyclerView mRecyclerView;
    private String tourDesc;
    private String tourName;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_info);

        mRecyclerView = findViewById(R.id.mRecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        floatingActionButton = findViewById(R.id.floatingId);
        Intent intent = getIntent();

        String key2 = getKey();






        floatingActionButton.setOnClickListener(this);

    }

    private String getKey() {

        String str = "";
        String key2 = getSharedPreferences("userdata", 0).getString("email", "none");
        Toast.makeText(this, key2, 0).show();
        if (key2.equals("none"))
        {
            return key2;
        }
        getKeyFromEmail(key2);
        return this.key;
    }

    @Override
    public void onClick(View v) {
        bottomSheet = new BottomSheet();
        bottomSheet.show(getSupportFragmentManager(), "bottomSheet");
    }
    private void getKeyFromEmail(String mail) {

        if (!TextUtils.isEmpty(mail)) {


            FirebaseDatabase.getInstance().getReference().child("user").orderByChild("email").equalTo(mail.trim()).addListenerForSingleValueEvent(new ValueEventListener() {
                public void onDataChange(DataSnapshot snapshot) {
                    for (DataSnapshot snap : snapshot.getChildren()) {
                        TourInfoActivity.this.key = snap.getKey();
                    }
                    Log.d("Key:Found", TourInfoActivity.this.key);
                    TourInfoActivity.this.databaseReference = FirebaseDatabase.getInstance().getReference().child("user").child(TourInfoActivity.this.key).child("tourlist");
                    TourInfoActivity.this.setData();
                }

                public void onCancelled(DatabaseError error) {
                    Log.d("Key:Error", error.getMessage());
                }
            });
        }
    }

    public void setData() {
        if (this.databaseReference == null) {
            Toast.makeText(this, "Please Check User", 0).show();
        } else {

            databaseReference.addValueEventListener(new ValueEventListener() {

                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    List<TourInfo> tourList = new ArrayList<>();

                    Log.d("Data", dataSnapshot.toString());

                    for (DataSnapshot dataSnap : dataSnapshot.getChildren()) {

                        tourList.add((TourInfo) dataSnap.getValue(TourInfo.class));

                        Toast.makeText(TourInfoActivity.this, "okk", 0).show();

                    }

                    MyAdapter myAdapter = new MyAdapter(TourInfoActivity.this, tourList);

                    TourInfoActivity.this.mRecyclerView.setAdapter(myAdapter);

                    myAdapter.setOnItemClickListener(new AdapterView.OnItemClickListener() {


                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        }

                        public void onItemClick(int position) {

                            Toast.makeText(TourInfoActivity.this, "going", 0).show();

                            TourInfoActivity.this.startActivity(new Intent(TourInfoActivity.this, Add_Expense_And_Memory.class));

                            Log.d(TourInfoActivity.TAG, "onItemClick: I am here");

                        }

                    });

                }


                public void onCancelled(@NonNull DatabaseError databaseError) {

                    Toast.makeText(TourInfoActivity.this, "Something Wrong", 0).show();

                    Log.d("Data", databaseError.getMessage());

                }

            });

        }

    }
}
