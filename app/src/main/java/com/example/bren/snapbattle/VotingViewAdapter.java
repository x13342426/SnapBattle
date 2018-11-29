package com.example.bren.snapbattle;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class VotingViewAdapter extends RecyclerView.Adapter<VotingViewAdapter.MyViewHolder> {


    private Context mContext ;
    private List<Vote_Basic> mVotes;

    public VotingViewAdapter(Context mContext, List<Vote_Basic> mVotes) {
        this.mContext = mContext;
        this.mVotes = mVotes;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_item_selfie,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {

        myViewHolder.selfie_vote_title.setText(mVotes.get(i).getTitle());
        myViewHolder.selfie_thumnail.setImageResource((mVotes.get(i).getThumbnail()));

        //Set click listener

        myViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,Vote_Basic_Activity.class);

                // passing data to the vote_basic_activity
                intent.putExtra("Title",mVotes.get(i).getTitle());
                intent.putExtra("Score",mVotes.get(i).getScore());
                intent.putExtra("Thumbnail",mVotes.get(i).getThumbnail());
                // start the activity
                mContext.startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return mVotes.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView selfie_vote_title;
        ImageView selfie_thumnail;
        CardView cardView ;

        public MyViewHolder(View itemView) {
            super(itemView);

            selfie_vote_title = (TextView) itemView.findViewById(R.id.vote_title_id) ;
            selfie_thumnail = (ImageView) itemView.findViewById(R.id.vote_image_id);
            cardView = (CardView) itemView.findViewById(R.id.cardview_id);
        }
    }
}
