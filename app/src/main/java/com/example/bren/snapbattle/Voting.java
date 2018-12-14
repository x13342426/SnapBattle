package com.example.bren.snapbattle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Voting extends AppCompatActivity {

    List<Vote> lstVote ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voting);

        lstVote = new ArrayList<>();
        lstVote.add(new Vote("Username 1","",R.drawable.halloween_selfie_1));
        lstVote.add(new Vote("Username 2"," ",R.drawable.halloween_selfie_2));
        lstVote.add(new Vote("Username 3"," ",R.drawable.halloween_selfie_3));
        lstVote.add(new Vote("Username 4"," ",R.drawable.halloween_selfie_4));
        lstVote.add(new Vote("Username 5"," ",R.drawable.halloween_selfie_5));
        lstVote.add(new Vote("Username 6"," ",R.drawable.halloween_selfie_6));
        lstVote.add(new Vote("Username 7"," ",R.drawable.halloween_selfie_1));
        lstVote.add(new Vote("Username 8"," ",R.drawable.halloween_selfie_2));
        lstVote.add(new Vote("Username 9"," ",R.drawable.halloween_selfie_3));
        lstVote.add(new Vote("Username 10"," ",R.drawable.halloween_selfie_4));
        lstVote.add(new Vote("Username 11"," ",R.drawable.halloween_selfie_5));
        lstVote.add(new Vote("Username 12"," ",R.drawable.halloween_selfie_6));

        RecyclerView myview = (RecyclerView) findViewById(R.id.voting_id);
        VotingViewAdapter myAdapter = new VotingViewAdapter(this,lstVote);
        myview.setLayoutManager(new GridLayoutManager(this,3));
        myview.setAdapter(myAdapter);


    }
}
