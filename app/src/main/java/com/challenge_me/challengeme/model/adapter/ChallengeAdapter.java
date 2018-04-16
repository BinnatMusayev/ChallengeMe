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
import com.challenge_me.challengeme.model.Challenge;

import java.util.List;
import java.util.Random;

public class ChallengeAdapter extends RecyclerView.Adapter<ChallengeAdapter.ViewHolder> {

	private List<Challenge> challanges;
	private Context context;
	//random post types
	private Challenge challenge;
//	Random rand;
//	int r;
	public ChallengeAdapter(List<Challenge> challanges, Context context) {
		this.challanges = challanges;
		this.context = context;


	}

	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		//delete later
//		rand = new Random();
//		r = rand.nextInt(3)+1;

//		final View view = LayoutInflater.from(parent.getContext())
//				.inflate(R.layout.fragment_dashboard, parent, false);
//		final ViewHolder holder = new ViewHolder(view);
//		Challenge challenge = challanges.get(holder.getAdapterPosition());

		// 1-waiting for challenger
		//2- challenge going on
		//3-finished challenge
		View v;
		switch (viewType){
			case 1:
				v = LayoutInflater.from(parent.getContext()).inflate(R.layout.waiting_for_challenger, parent, false);
				break;
			case 2:
				v = LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_posts_list, parent, false);
				break;
			case 3:
				v = LayoutInflater.from(parent.getContext()).inflate(R.layout.finished_challenge, parent, false);
				break;
			default:
				v = null;

		}

		return new ViewHolder(v);
	}

	@Override
	public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
		challenge = challanges.get(position);
//		Challenge challenge; //initialized in switch case

		//custom things
		int creatorImageResId, chalengerImageResId;
		Drawable image, image_two;

		//delete random shit later after using backend
		switch (challenge.getType()){
			case 1:

//				challenge = challanges.get(position);

				holder.creator_username.setText(challenge.getCreator().getUsername() + challenge.getCreator_id());

				//burda drawable papkasini deyishe bilerem esas shekillerin (challenge-lering) oldugu yere
				creatorImageResId =  context.getResources().getIdentifier(challenge.getCreator_photo(), "drawable", context.getPackageName());
				image = context.getResources().getDrawable(creatorImageResId );
				holder.creator_photo.setImageDrawable(image);

				break;
			case 2:

//				challenge = challanges.get(position);

				holder.creator_username.setText(challenge.getCreator().getUsername() + challenge.getCreator_id());
				holder.challenger_username.setText(challenge.getChallenger().getUsername() + challenge.getCreator_id());


				//sonra deyish Challende classinda Vote instance yarat
//				if(!holder.creator_votes.getText().equals(null) && !holder.challenger_votes.getText().equals(null)) {
				if(!(holder.creator_votes == null) && ! (holder.challenger_votes == null )) {
					holder.creator_votes.setText(String.valueOf("173"));
					holder.challenger_votes.setText(String.valueOf("37"));
				}

				//burda drawable papkasini deyishe bilerem esas shekillerin (challenge-lering) oldugu yere
				creatorImageResId =  context.getResources().getIdentifier(challenge.getCreator_photo(), "drawable", context.getPackageName());
				image = context.getResources().getDrawable(creatorImageResId );
				holder.creator_photo.setImageDrawable(image);

				chalengerImageResId =  context.getResources().getIdentifier(challenge.getChallenger_photo(), "drawable", context.getPackageName());
				image_two = context.getResources().getDrawable(chalengerImageResId );
				holder.challenger_photo.setImageDrawable(image_two);
				break;
			case 3:

//				challenge = challanges.get(position);

				holder.creator_username.setText(challenge.getCreator().getUsername() + challenge.getCreator_id());
				holder.challenger_username.setText(challenge.getChallenger().getUsername() + challenge.getCreator_id());


				//sonra deyish Challende classinda Vote instance yarat
				if(!(holder.creator_votes == null) && ! (holder.challenger_votes == null )) {
					holder.creator_votes.setText(String.valueOf("173"));
					holder.challenger_votes.setText(String.valueOf("37"));
				}

				//burda drawable papkasini deyishe bilerem esas shekillerin (challenge-lering) oldugu yere
				creatorImageResId =  context.getResources().getIdentifier(challenge.getCreator_photo(), "drawable", context.getPackageName());
				image = context.getResources().getDrawable(creatorImageResId );
				holder.creator_photo.setImageDrawable(image);

				chalengerImageResId =  context.getResources().getIdentifier(challenge.getChallenger_photo(), "drawable", context.getPackageName());
				image_two = context.getResources().getDrawable(chalengerImageResId );
				holder.challenger_photo.setImageDrawable(image_two);
				break;
			default:

//				challenge = challanges.get(position);

				holder.creator_username.setText(challenge.getCreator().getUsername() + challenge.getCreator_id());
				holder.challenger_username.setText(challenge.getChallenger().getUsername() + challenge.getCreator_id());


				//sonra deyish Challende classinda Vote instance yarat
				//original
//				holder.creator_votes.setText("173");
//				holder.challenger_votes.setText("37");
				if(!(holder.creator_votes == null) && ! (holder.challenger_votes == null )) {
					holder.creator_votes.setText(String.valueOf("173"));
					holder.challenger_votes.setText(String.valueOf("37"));
				}

				//burda drawable papkasini deyishe bilerem esas shekillerin (challenge-lering) oldugu yere
				creatorImageResId =  context.getResources().getIdentifier(challenge.getCreator_photo(), "drawable", context.getPackageName());
				image = context.getResources().getDrawable(creatorImageResId );
				holder.creator_photo.setImageDrawable(image);

				chalengerImageResId =  context.getResources().getIdentifier(challenge.getChallenger_photo(), "drawable", context.getPackageName());
				image_two = context.getResources().getDrawable(chalengerImageResId );
				holder.challenger_photo.setImageDrawable(image_two);
		}

		//ORIGINAL VERSION
//		holder.creator_username.setText(challenge.getCreator().getUsername() + challenge.getCreator_id());
//		holder.challenger_username.setText(challenge.getChallenger().getUsername() + challenge.getChallenger_id());
//
////		holder.creator_username.setText("binntsfdsf");
////		holder.challenger_username.setText("mesfbsjfj");
//
//		//sonra deyish Challende classinda Vote instance yarat
//		holder.creator_votes.setText("173");
//		holder.challenger_votes.setText("37");
//
//		//burda drawable papkasini deyishe bilerem esas shekillerin (challenge-lering) oldugu yere
//		int creatorImageResId =  context.getResources().getIdentifier(challenge.getCreator_photo(), "drawable", context.getPackageName());
//		Drawable image = context.getResources().getDrawable(creatorImageResId );
//		holder.creator_photo.setImageDrawable(image);
//
//		int chalengerImageResId =  context.getResources().getIdentifier(challenge.getChallenger_photo(), "drawable", context.getPackageName());
//		Drawable image_two = context.getResources().getDrawable(chalengerImageResId );
//		holder.challenger_photo.setImageDrawable(image_two);



	}

	@Override
	public int getItemCount() {
		return challanges.size();
	}

	@Override
	public int getItemViewType(int position) {
		//Implement your logic here
		Challenge challenge = challanges.get(position);
		return challenge.getType();
	}

	public class ViewHolder extends RecyclerView.ViewHolder{

		public TextView creator_username, challenger_username, creator_votes, challenger_votes;
		public ImageView creator_photo, challenger_photo;

		public ViewHolder(View itemView) {
			super(itemView);

			creator_username = (TextView) itemView.findViewById(R.id.creator_username);
			challenger_username = (TextView) itemView.findViewById(R.id.challenger_username);
			creator_votes = (TextView) itemView.findViewById(R.id.creator_votes);
			challenger_votes = (TextView) itemView.findViewById(R.id.challenger_votes);
			creator_photo = (ImageView) itemView.findViewById(R.id.creator_photo);
			challenger_photo = (ImageView) itemView.findViewById(R.id.challenger_photo);
		}
	}


}
