package com.example.bren.snapbattle;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

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

        rellay1 = (RelativeLayout) findViewById(R.id.rellay1);
        rellay2 = (RelativeLayout) findViewById(R.id.rellay2);

        handler.postDelayed(runnable, 2000); //2000 is the timeout for the splash
    }


    public void onButtonClick(View v)
    {
        if (v.getId() == R.id.BSign) {


                Intent i = new Intent(MainActivity.this, Voting_Page.class);
                startActivity(i);

            }

            if (v.getId() == R.id.BdDisplay) {
                Intent i = new Intent(MainActivity.this, Register.class);
                startActivity(i);
            }

        }
    }
