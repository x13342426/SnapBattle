package com.example.bren.snapbattle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Vote_Basic_Activity extends AppCompatActivity {

    private TextView newtitle,newscore;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote__basic_);

        newtitle = (TextView) findViewById(R.id.voteusername);
        newscore = (TextView) findViewById(R.id.votescore);
        img = (ImageView) findViewById(R.id.votethumbnail);


        //Receive data
        Intent intent = getIntent();
        String Title = intent.getExtras().getString("Title");
        int image = intent.getExtras().getInt("Thumbnail");
        int result = intent.getExtras().getInt("Score");

        //Setting values

        newtitle.setText(Title);
        newscore.setText(result);
        img.setImageResource(image);

    }
}
