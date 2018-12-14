package com.example.bren.snapbattle;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Voting extends MainActivity {


    List<Vote_Basic> LstVote;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.voting);


        LstVote = new ArrayList<>();
        LstVote.add(new Vote_Basic(R.drawable.halloween_selfie_1,"Username",0));
        LstVote.add(new Vote_Basic(R.drawable.halloween_selfie_2,"Username",0));
        LstVote.add(new Vote_Basic(R.drawable.halloween_selfie_3,"Username",0));
        LstVote.add(new Vote_Basic(R.drawable.halloween_selfie_4,"Username",0));
        LstVote.add(new Vote_Basic(R.drawable.halloween_selfie_5,"Username",0));
        LstVote.add(new Vote_Basic(R.drawable.halloween_selfie_6,"Username",0));
        LstVote.add(new Vote_Basic(R.drawable.halloween_selfie_1,"Username",0));
        LstVote.add(new Vote_Basic(R.drawable.halloween_selfie_2,"Username",0));
        LstVote.add(new Vote_Basic(R.drawable.halloween_selfie_3,"Username",0));
        LstVote.add(new Vote_Basic(R.drawable.halloween_selfie_4,"Username",0));
        LstVote.add(new Vote_Basic(R.drawable.halloween_selfie_5,"Username",0));
        LstVote.add(new Vote_Basic(R.drawable.halloween_selfie_6,"Username",0));

        RecyclerView myview = (RecyclerView) findViewById(R.id.votepage_title_id);
        VotingViewAdapter myAdapter = new VotingViewAdapter(this,LstVote);
        myview.setLayoutManager(new GridLayoutManager(this, 3));
        myview.setAdapter(myAdapter);

    }



}