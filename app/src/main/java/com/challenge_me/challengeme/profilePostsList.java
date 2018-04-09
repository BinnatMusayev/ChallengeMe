package com.challenge_me.challengeme;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.challenge_me.challengeme.model.Challenge;
import com.challenge_me.challengeme.model.User;
import com.challenge_me.challengeme.model.adapter.ChallengeAdapter;

import java.util.ArrayList;
import java.util.List;


public class profilePostsList extends Fragment {


	public static int index = -1;
	public static int top = -1;

	//recycler example
	private RecyclerView recyclerView;
	private RecyclerView.Adapter adapter;
	private List<Challenge> challenges;
	private LinearLayoutManager mLayoutManager;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {

		//recycler example
		//view also usedto inflate fragment
		View v = inflater.inflate(R.layout.fragment_profile_posts_list, container, false);

		mLayoutManager = new LinearLayoutManager(getActivity());

		recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
		recyclerView.setHasFixedSize(true);

		recyclerView.setLayoutManager(mLayoutManager);
		challenges = new ArrayList<Challenge>();

		Challenge c;
		for(int i=2; i<=200; i++){
			c = new Challenge(i);
			c.setCreator_id(i);
			c.setChallenger_id(i);


			User u1 = new User(i);
			User u2 = new User(i);
			u1.setUsername("binnet94");
			u2.setUsername("mesud_abdulla");
			c.setCreator(u1);
			c.setChallenger(u2);
//			c.getCreator().setUsername("jnfksd");
//			c.getChallenger().setUsername("abisdnjk");

			c.setCreator_photo("cowboy_pic");
			c.setChallenger_photo("mesud");
			challenges.add(c);
		}

		adapter = new ChallengeAdapter(challenges, this.getContext());
		recyclerView.setAdapter(adapter);
		//end of recyclerview example





		// Inflate the layout for this fragment
		return v;
	}


	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onResume() {
		super.onResume();
		//set recyclerview position
		if(index != -1)
		{
			mLayoutManager.scrollToPositionWithOffset( index, top);
		}
	}

	@Override
	public void onPause() {
		super.onPause();
		//read current recyclerview position
		index = mLayoutManager.findFirstVisibleItemPosition();
		View v = recyclerView.getChildAt(0);
		top = (v == null) ? 0 : (v.getTop() - recyclerView.getPaddingTop());
	}
}
