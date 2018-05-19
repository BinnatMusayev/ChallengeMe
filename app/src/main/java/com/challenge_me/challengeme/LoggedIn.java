package com.challenge_me.challengeme;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TabHost;
import android.widget.TextView;

import java.lang.reflect.Field;

public class LoggedIn extends AppCompatActivity {

	private TextView mTextMessage;
	private ProfileFragment profileFragment;
	private NotificationFragment notificationFragment;
	private SearchFragment searchFragment;
	private SettingsFragment settingsFragment;
	private DashboardFragment dashboardFragment;
	//fragement
	private FragmentManager fragmentManager;
	private FragmentTransaction fragmentTransaction;

	private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
			= new BottomNavigationView.OnNavigationItemSelectedListener() {

		@Override
		public boolean onNavigationItemSelected(@NonNull MenuItem item) {
			switch (item.getItemId()) {
				case R.id.navigation_profile:
					changeMainFragment(profileFragment);
					mTextMessage.setText(R.string.title_profile);
					return true;
				case R.id.navigation_dashboard:
					mTextMessage.setText(R.string.title_dashboard);
					changeMainFragment(dashboardFragment);
					return true;
				case R.id.navigation_notifications:
					changeMainFragment(notificationFragment);
					mTextMessage.setText(R.string.title_notifications);
					return true;
				case R.id.navigation_search:
					mTextMessage.setText(R.string.title_search);
					changeMainFragment(searchFragment);
					return true;
				case R.id.navigation_settings:
					mTextMessage.setText(R.string.title_settings);
					changeMainFragment(settingsFragment);
					return true;

			}
			return false;
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_logged_in);

		//change title of Action Bar and set color
//		getSupportActionBar().setTitle("ChallengeMe");
//        getSupportActionBar().setBackgroundDraw able(new ColorDrawable(Color.parseColor("#FAD1B2")));
        //layout of actionbar
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_layout);
        TextView textViewTitle = (TextView) findViewById(R.id.title);
        textViewTitle.setText(R.string.title);




		mTextMessage = (TextView) findViewById(R.id.message);
		BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
		navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
		// disable shifting animation
		BottomNavigationViewHelper.disableShiftMode(navigation);

		//initialize fragements
		profileFragment = new ProfileFragment();
		notificationFragment = new NotificationFragment();
		searchFragment = new SearchFragment();
		settingsFragment = new SettingsFragment();
		dashboardFragment = new DashboardFragment();

		fragmentManager = getSupportFragmentManager();
		changeMainFragment(profileFragment);
//		fragmentTransaction = fragmentManager.beginTransaction();
//
//		fragmentTransaction.replace(R.id.mainFragment, profileFragment);
//
//		fragmentTransaction.commit();


	}

	public void changeMainFragment(Fragment fragment){
		fragmentTransaction = fragmentManager.beginTransaction();

		fragmentTransaction.replace(R.id.mainFragment, fragment);

		fragmentTransaction.commit();
	}


	public  void changeViewToList(View view){
		profileFragment.changeViewToList();
	}

//	public  void changeViewToGrid(View view){
//		profileFragment.changeViewToGrid();
//	}

	public  void changeViewToStats(View view){
		profileFragment.changeViewToStats();
	}

    public void signOut(View v){
        startActivity(new Intent(LoggedIn.this, SignIn.class));
    }

    public void openFollowings(View v){
        startActivity(new Intent(LoggedIn.this, Following.class));
    }

	public void openFollowers(View v){
		startActivity(new Intent(LoggedIn.this, Followers.class));
	}

	//create new challenge
	public void createNewChallenge(View view){
		startActivity(new Intent(LoggedIn.this, CreateChallenge.class).putExtra("sessionId", getIntent().getStringExtra("sessionId")));
	}

	//invite to challenge
	public void inviteToChallenge(View view){
		startActivity(new Intent(LoggedIn.this, InviteToChallenge.class));
	}

	public void goToProfile(View view){
		startActivity(new Intent(LoggedIn.this, ProfileActivity.class));
	}



}
