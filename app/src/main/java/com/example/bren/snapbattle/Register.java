package com.example.bren.snapbattle;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

public class Register extends MainActivity implements View.OnClickListener{
    private FirebaseAuth mAuth;
    private EditText editTextEmail;
    private EditText editTextPass;
    private TextView textViewSignup;
    private Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        mAuth = FirebaseAuth.getInstance();
        findViewById(R.id.Blogin).setOnClickListener(this);


        buttonRegister = (Button) findViewById(R.id.Blogin);
        editTextEmail = (EditText) findViewById(R.id.tEmail);
        editTextPass = (EditText) findViewById(R.id.tPass);
        textViewSignup = (TextView) findViewById(R.id.tSign);

        buttonRegister.setOnClickListener(this);
        textViewSignup.setOnClickListener(this);

    }


    private void registerUser(){
        String email = editTextEmail.getText().toString().trim();
        String pass = editTextPass.getText().toString().trim();





            if (email.isEmpty()) {
                editTextEmail.setError("Email is required");
                editTextEmail.requestFocus();
                return;
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                editTextEmail.setError("Please enter a valid email");
                editTextEmail.requestFocus();
                return;
            }

            if (pass.isEmpty()) {
                editTextPass.setError("Password is required");
                editTextPass.requestFocus();
                return;

            }

            if (pass.length() < 6) {
                editTextPass.setError("Password needs to be 6 characters");
                editTextPass.requestFocus();
                return;
            }


            mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<com.google.firebase.auth.AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<com.google.firebase.auth.AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(getApplicationContext(), "User Registered Successful", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }




    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.Blogin:
                registerUser();
                break;

            case R.id.tSign:
                startActivity(new Intent(this, MainActivity.class));
                break;

        }

    }
}

