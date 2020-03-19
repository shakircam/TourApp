package com.example.shaki.newlogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText signup_name, signup_email, signup_password, signup_number;
    private TextView signinTV;
    private Button signupBTN;
    private FirebaseAuth mAuth;
    private FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        this.setTitle("Sign Up");
        signup_name = findViewById(R.id.signup_nameId);
        signup_email = findViewById(R.id.signup_emailId);
        signup_password = findViewById(R.id.signup_passwordId);
        signup_number = findViewById(R.id.signup_numberId);
        signupBTN = findViewById(R.id.signupBTN);
        signinTV = findViewById(R.id.signinTV);

        mAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("user");

        signupBTN.setOnClickListener(this);
        signinTV.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.signupBTN:
                creatingUserInfo();
                break;
            case R.id.signinTV:
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                break;
        }

    }

    private void creatingUserInfo() {
        String name = signup_name.getText().toString().trim();
        String email = signup_email.getText().toString().trim();
        String password = signup_password.getText().toString().trim();
        String number = signup_number.getText().toString().trim();

        if (name.isEmpty()) {
            signup_name.setError("Enter The Name");
            signup_name.requestFocus();
            return;
        }

        //checking the validity of the email
        if (email.isEmpty()) {
            signup_email.setError("Enter an email address");
            signup_email.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            signup_email.setError("Enter a valid email address");
            signup_email.requestFocus();
            return;
        }


        // checking the validity of the password
        if (password.isEmpty()) {
            signup_password.setError("Enter a password");
            signup_password.requestFocus();
            return;
        }
        if (password.length() < 6) {
            signup_password.setError("Minimum Password length is 6");
            signup_password.requestFocus();
            return;
        }
        if (number.isEmpty()) {
            signup_number.setError("Enter your Number");
            signup_number.requestFocus();
            return;
        }
        if (number.length() < 11) {
            signup_number.setError("Number will be 11 Digit");
            signup_number.requestFocus();
            return;
        }


        saveDatabase();

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {

                    finish();
                    Intent intent = new Intent(getApplicationContext(), TourActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                else {
                    if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                        Toast.makeText(getApplicationContext(), " User Already Register  ", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), " Error  " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }



    private void saveDatabase() {
        String name = signup_name.getText().toString().trim();
        String email = signup_email.getText().toString().trim();
        String password = signup_password.getText().toString().trim();
        String number = signup_number.getText().toString().trim();

        String key = databaseReference.push().getKey();
        User user = new User(name,email,password,number);
        databaseReference.child(key).setValue(user);
    }
}


