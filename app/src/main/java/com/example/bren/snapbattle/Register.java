package com.example.bren.snapbattle;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

public class Register extends MainActivity implements View.OnClickListener{
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        mAuth = FirebaseAuth.getInstance();
        findViewById(R.id.Blogin).setOnClickListener(this);

    }


    public void onregisterClick(View v) {
            EditText name = (EditText) findViewById(R.id.tUsn);
            EditText email = (EditText) findViewById(R.id.tEmail);
            EditText pass = (EditText) findViewById(R.id.tPass);
            String namestr = name.getText().toString();
            String emailstr = email.getText().toString();
            String passstr = pass.getText().toString();

            if (emailstr.isEmpty()) {
                email.setError("Email is required");
                email.requestFocus();
                return;
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(emailstr).matches()) {
                email.setError("Please enter a valid email");
                email.requestFocus();
                return;
            }

            if (passstr.isEmpty()) {
                pass.setError("Password is required");
                pass.requestFocus();
                return;

            }

            if (passstr.length() < 6) {
                pass.setError("Password needs to be 6 characters");
                pass.requestFocus();
                return;
            }


            mAuth.createUserWithEmailAndPassword(emailstr, passstr).addOnCompleteListener(new OnCompleteListener<com.google.firebase.auth.AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<com.google.firebase.auth.AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(getApplicationContext(), "User Registered Successful", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }



    @Override
    public void onClick(View v) {

    }
}

