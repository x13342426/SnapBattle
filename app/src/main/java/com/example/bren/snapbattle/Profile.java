package com.example.bren.snapbattle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Profile extends MainActivity {
    Button vote;
    Button pic;
    Button comp;
    Button reward;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        vote = findViewById(R.id.Btnvote);
        pic = findViewById(R.id.Btnpic);
        comp = findViewById(R.id.Btncomp);
        reward = findViewById(R.id.Btnreward);

    }

    public void onButtonClick(View v) {
        if (v.getId() == R.id.Btnvote) {
            Intent i = new Intent(Profile.this, Voting.class);
            startActivity(i);
        }
        if (v.getId() == R.id.Btnpic) {
            Intent i = new Intent(Profile.this, Camera.class);
            startActivity(i);

        }
        if (v.getId() == R.id.Btncomp) {
            Intent i = new Intent(Profile.this, Competition.class);
            startActivity(i);
        }
        if (v.getId() == R.id.Btnreward) {
            Intent i = new Intent(Profile.this, Rewards.class);
            startActivity(i);
        }

    }
}