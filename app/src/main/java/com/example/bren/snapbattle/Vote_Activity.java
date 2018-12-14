package com.example.bren.snapbattle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Vote_Activity extends AppCompatActivity {

    private TextView newname, newscore;
    private ImageView img;
    Button vote_rtn;

    TextView votescore;
    Button addBtn;
    Button minusBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote_);

        newname = (TextView) findViewById(R.id.txtname);
        newscore = (TextView) findViewById(R.id.txtScore);
        img = (ImageView) findViewById(R.id.selfie);

        // Recieve data
        Intent intent = getIntent();
        String Name = intent.getExtras().getString("Name");
        String Score = intent.getExtras().getString("Score");
        int image = intent.getExtras().getInt("Thumbnail");

        // Setting values

        newname.setText(Name);
        newscore.setText(Score);
        img.setImageResource(image);

        setContentView(R.layout.activity_vote_);
        vote_rtn = findViewById(R.id.button_return);

        votescore = findViewById(R.id.txtScore);
        addBtn = (Button) findViewById(R.id.add_score);
        minusBtn = (Button) findViewById(R.id.minus_score);


    }

    public void onBackPressed(View view) {

        if ((view.getId() == R.id.button_return)) {
            Intent i = new Intent(Vote_Activity.this, Voting.class);
            startActivity(i);
        }

    }

    public void onAddPressed(View view) {

        /*if (votescore.equals("")){*/ //attempt to check the current number before incrementing
            String scoreAdd = votescore.getText().toString().trim();
            int count = Integer.parseInt(scoreAdd);
            count++;
            votescore.setText(String.valueOf(count));

        }
        /*else if(votescore.equals("1")){ //if the current number matches disable ability to increment
            addBtn.setEnabled(false);
        }*/

    public void onSubPressed(View view) {
    /*
        if (newScore.equals("1")){*/
            String scoreReduce = votescore.getText().toString().trim();
            int count2 = Integer.parseInt(scoreReduce);
            count2--;
            votescore.setText(String.valueOf(count2));

        }/*
        if(newScore.equals("0")){
            addBtn.setEnabled(false);
        }

    }*/
         /*

        String scoreAdd = newScore.getText().toString().trim();
       if(newScore.equals("")) {
            int count = Integer.parseInt(scoreAdd);
            count++;
            newScore.setText(String.valueOf(count));
        }
    }

    public void onSubPressed(View view) {
        String scoreReduce = newScore.getText().toString().trim();
        if(newScore.equals("")){
            int count2 = Integer.parseInt(scoreReduce);
            count2--;
            newScore.setText(String.valueOf(count2));
        }

    }*/
         //unable to implemetn tally/total vote of this slefie recived due to lack of access
}