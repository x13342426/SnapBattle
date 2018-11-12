package com.example.bren.snapbattle;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    EditText editTextEmail;
    EditText editTextPass;
    TextView textViewSignup;
    Button buttonSign;


    private Button BLogin , BdDisplay;
    private EditText tUsn, tPass, tEmail;



    RelativeLayout rellay1, rellay2;

    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            rellay1.setVisibility(View.VISIBLE);
            rellay2.setVisibility(View.VISIBLE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();


        editTextEmail = (EditText) findViewById(R.id.tEmail);
        editTextPass = (EditText) findViewById(R.id.tPass);
        textViewSignup = (TextView) findViewById(R.id.tSign);
        buttonSign = (Button) findViewById(R.id.Blogin);

        rellay1 = (RelativeLayout) findViewById(R.id.rellay1);
        rellay2 = (RelativeLayout) findViewById(R.id.rellay2);

        handler.postDelayed(runnable, 2000); //2000 is the timeout for the splash
    }

    private void userLogin(){

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

        mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Intent intent = new Intent(MainActivity.this, Voting_Page.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public void onButtonClick(View v)
    {
        if (v.getId() == R.id.BSign) {
            userLogin();


            Intent i = new Intent(MainActivity.this, Voting_Page.class);
            startActivity(i);

        }

        if (v.getId() == R.id.BdDisplay) {
            Intent i = new Intent(MainActivity.this, Register.class);
            startActivity(i);
        }

    }
}
