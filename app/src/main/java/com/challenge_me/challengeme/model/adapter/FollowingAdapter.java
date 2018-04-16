package com.challenge_me.challengeme.model.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.challenge_me.challengeme.R;
import com.challenge_me.challengeme.model.User;

import java.util.List;
import java.util.zip.Inflater;

public class FollowingAdapter extends RecyclerView.Adapter<FollowingAdapter.ViewHolder> {

    private List<User> followings;
    private Context context;

    public FollowingAdapter(List<User> followings, Context context){
        this.followings = followings;
        this.context = context;
    }

    @NonNull
    @Override
    public FollowingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.follow_card_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FollowingAdapter.ViewHolder holder, int position) {
        User user = followings.get(position);

        int creatorImageResId =  context.getResources().getIdentifier(user.getProfile_photo(), "drawable", context.getPackageName());
        Drawable image = context.getResources().getDrawable(creatorImageResId );
        holder.followingImage.setImageDrawable(image);

        holder.followingUsername.setText(user.getUsername());
    }

    @Override
    public int getItemCount() {
        return followings.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView followingImage;
        public TextView followingUsername;

        public ViewHolder(View itemView) {
            super(itemView);

            followingImage = (ImageView) itemView.findViewById(R.id.followingPhoto);
            followingUsername = (TextView) itemView.findViewById(R.id.followingUsername);

        }
    }

}
