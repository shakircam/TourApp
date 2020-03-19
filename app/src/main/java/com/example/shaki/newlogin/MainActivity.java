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

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText signin_email,signin_password;
    private Button signinBTN;
    private TextView signupTV;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Sign In");

        signin_email = findViewById(R.id.signin_emailId);
        signin_password = findViewById(R.id.signin_passwordId);
        signinBTN = findViewById(R.id.signinBTN);
        signupTV = findViewById(R.id.signupTV);

        mAuth = FirebaseAuth.getInstance();

        signinBTN.setOnClickListener(this);
        signupTV.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.signinBTN:
                userLogin();
                break;
            case R.id.signupTV:
                Intent intent = new Intent(getApplicationContext(),SignupActivity.class);
                startActivity(intent);
                break;
        }

    }

    private void userLogin() {


        String email = signin_email.getText().toString().trim();
        String password = signin_password.getText().toString().trim();


        //checking the validity of the email
        if (email.isEmpty()) {
            signin_email.setError("Enter an email address");
            signin_email.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            signin_email.setError("Enter a valid email address");
            signin_email.requestFocus();
            return;
        }


        // checking the validity of the password
        if (password.isEmpty()) {
            signin_password.setError("Enter a password");
            signin_password.requestFocus();


        }
        if (password.length() < 6) {
            signin_password.setError("Minimum Password length is 6");
            signin_password.requestFocus();
            return;
        }
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    finish();
                    Intent intent = new Intent(getApplicationContext(),TourActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);

                }
                else{
                    Toast.makeText(getApplicationContext(), " Login is not Successful ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
