package com.challenge_me.challengeme;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.challenge_me.challengeme.model.User;
import com.challenge_me.challengeme.model.adapter.RankingAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;


public class profileStatistics extends Fragment {

	public static int index = -1;
	public static int top = -1;


	private RecyclerView recyclerView;
	private RecyclerView.Adapter adapter;
	private List<User> users;
	private LinearLayoutManager mLayoutManager;


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {

	    //RecyclerView
        View v = inflater.inflate(R.layout.fragment_profile_statistics, container, false);

        mLayoutManager = new LinearLayoutManager(getActivity());

        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
	    recyclerView.setHasFixedSize(true);
	    recyclerView.setLayoutManager(mLayoutManager);
	    users = new ArrayList<User>();

	    User u;
        Random random = new Random();
	    for(int i=0; i<=100; i++){
	        u = new User(i);
			if (i==1)
				u.setUsername("binnat"+i);
			else
				u.setUsername("mesud" +i);

	        u.setRanking(random.nextInt(1000));
			users.add(u);
		}


        Collections.sort(users);
	    adapter = new RankingAdapter(users, getActivity());
        recyclerView.setAdapter(adapter);

		// Inflate the layout for this fragment
		return v;
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
