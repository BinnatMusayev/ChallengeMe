package com.challenge_me.challengeme.model.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.challenge_me.challengeme.R;
import com.challenge_me.challengeme.model.User;

import java.util.List;

public class RankingAdapter extends RecyclerView.Adapter<RankingAdapter.ViewHolder> {

    private List<User> users;
    private Context context;

    public RankingAdapter(List<User> users, Context context) {
        this.users = users;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_statistics,parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User user = users.get(position);
        holder.setIsRecyclable(false);
        holder.rankingUser.setText(user.getUsername() );
        holder.rankingRating.setText(String.valueOf(user.getRanking() ));

        //differentiate current profile
        if(user.getUser_id() == 1){
            holder.rankingUser.setBackgroundColor(Color.parseColor("#FFF4CDCD"));
            holder.rankingRating.setBackgroundColor(Color.parseColor("#FFF4CDCD"));
        }


    }

    @Override
    public int getItemCount() {
        return users.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView rankingUser, rankingRating;

        public ViewHolder(View itemView) {
            super(itemView);

            rankingUser = (TextView) itemView.findViewById(R.id.rankingListUser);
            rankingRating = (TextView) itemView.findViewById(R.id.rankingListRating);

        }
    }

}
