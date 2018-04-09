package com.challenge_me.challengeme;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.challenge_me.challengeme.model.ProfileChallenge;

import java.util.List;


public class ProfileFragment extends Fragment {

	private Fragment childFragment;
	private FragmentTransaction transaction;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {



		//recycler example
		//view also usedto inflate fragment
		View v = inflater.inflate(R.layout.fragment_profile, container, false);

		childFragment = new profilePostsList();
		transaction = getChildFragmentManager().beginTransaction();
		transaction.replace(R.id.profileContentFragment, childFragment);
		transaction.commit();



		// Inflate the layout for this fragment

		return v;

	}


	public  void changeViewToList(){
		childFragment = new profilePostsList();
		transaction = getChildFragmentManager().beginTransaction();
		transaction.replace(R.id.profileContentFragment, childFragment);
		transaction.commit();


		//changing color of buttons
//		getActivity().findViewById(R.id.gridViewButton).setBackgroundColor(Color.parseColor("#fcf2ea"));
		getActivity().findViewById(R.id.statsViewButton).setBackgroundColor(Color.parseColor("#fcf2ea"));
		getActivity().findViewById(R.id.listViewButton).setBackgroundColor(Color.parseColor("#fffae4d3"));
	}

//	public  void changeViewToGrid(){
//		childFragment = new profilePostsGrid();
//		transaction = getChildFragmentManager().beginTransaction();
//		transaction.replace(R.id.profileContentFragment, childFragment);
//		transaction.commit();
//
//		//changing color of buttons
//		getActivity().findViewById(R.id.listViewButton).setBackgroundColor(Color.parseColor("#fcf2ea"));
//		getActivity().findViewById(R.id.statsViewButton).setBackgroundColor(Color.parseColor("#fcf2ea"));
//		getActivity().findViewById(R.id.gridViewButton).setBackgroundColor(Color.parseColor("#fffae4d3"));
//
//	}

	public  void changeViewToStats(){
		if(!this.getChildFragmentManager().getFragments().get(0).equals(profileStatistics.class)){
			childFragment = new profileStatistics();
			transaction = getChildFragmentManager().beginTransaction();
			transaction.replace(R.id.profileContentFragment, childFragment);
			transaction.commit();
		}

		//changing color of buttons
//		getActivity().findViewById(R.id.gridViewButton).setBackgroundColor(Color.parseColor("#fcf2ea"));
		getActivity().findViewById(R.id.listViewButton).setBackgroundColor(Color.parseColor("#fcf2ea"));
		getActivity().findViewById(R.id.statsViewButton).setBackgroundColor(Color.parseColor("#fffae4d3"));
	}



}
