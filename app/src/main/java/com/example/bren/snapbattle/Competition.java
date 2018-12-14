package com.example.bren.snapbattle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Competition extends MainActivity {
    Button vote;
    Button home;
    Button enter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comp);



            vote = findViewById(R.id.Btnvote);
            home = findViewById(R.id.BtnHome);
            enter = findViewById(R.id.BtnEnter);

        }

        public void onButtonClick(View v) {
            if (v.getId() == R.id.BtnEnter) {
                Intent i = new Intent(Competition.this, Camera.class);
                startActivity(i);
            }
            if (v.getId() == R.id.BtnHome) {
                Intent i = new Intent(Competition.this, Profile.class);
                startActivity(i);

            }
            if (v.getId() == R.id.Btnvote) {
                Intent i = new Intent(Competition.this, Voting.class);
                startActivity(i);
            }
    }
}