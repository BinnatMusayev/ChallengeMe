package com.challenge_me.challengeme;

import android.app.ActionBar;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private profilePostsList profilePostsList;
    private profileStatistics profileStatistics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_profile);


        //actionbar
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_layout);
        TextView textViewTitle = (TextView) findViewById(R.id.title);
        textViewTitle.setText(R.string.title);

        //back button enable
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //initiate fragments
        profilePostsList = new profilePostsList();
        profileStatistics = new profileStatistics();

        //assign list view
        fragmentManager = getSupportFragmentManager();
        changeContentFragment(profilePostsList);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                this.finish();
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void changeContentFragment(Fragment fragment){
        fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.profileContentFragment, fragment);

        fragmentTransaction.commit();
    }


    public  void changeViewToList(View view){

        changeContentFragment(profilePostsList);
        findViewById(R.id.statsViewButton).setBackgroundColor(Color.parseColor("#fcf2ea"));
        findViewById(R.id.listViewButton).setBackgroundColor(Color.parseColor("#fffae4d3"));
    }

//	public  void changeViewToGrid(View view){
//		profileFragment.changeViewToGrid();
//	}

    public  void changeViewToStats(View view){
        changeContentFragment(profileStatistics);
        findViewById(R.id.statsViewButton).setBackgroundColor(Color.parseColor("#fffae4d3"));
        findViewById(R.id.listViewButton).setBackgroundColor(Color.parseColor("#fcf2ea"));
    }

}
