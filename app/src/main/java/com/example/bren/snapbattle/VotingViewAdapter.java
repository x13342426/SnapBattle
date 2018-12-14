package com.example.bren.snapbattle;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class VotingViewAdapter extends RecyclerView.Adapter<VotingViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Vote> mVote;


    public VotingViewAdapter(Context mContext, List<Vote> mVote) {
        this.mContext = mContext;
        this.mVote = mVote;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_item_vote, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.vote_id.setText(mVote.get(position).getName());
        holder.selfie_thumbnail.setImageResource(mVote.get(position).getThumbnail());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, Vote_Activity.class);

                // passing data to the book activity
                intent.putExtra("Name", mVote.get(position).getName());
                intent.putExtra("Score", mVote.get(position).getScore());
                intent.putExtra("Thumbnail", mVote.get(position).getThumbnail());
                // start the activity
                mContext.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return mVote.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView vote_id;
        ImageView selfie_thumbnail;
        CardView cardView;


        public MyViewHolder(View itemView) {
            super(itemView);

            vote_id = (TextView) itemView.findViewById(R.id.vote_title_id);
            selfie_thumbnail = (ImageView) itemView.findViewById(R.id.vote_image_id);
            cardView = (CardView) itemView.findViewById(R.id.cardview_id);


        }

    }

}