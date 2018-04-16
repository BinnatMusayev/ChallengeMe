package com.challenge_me.challengeme;

import android.app.ActionBar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.TextView;

import com.challenge_me.challengeme.model.User;
import com.challenge_me.challengeme.model.adapter.FollowingAdapter;

import java.util.ArrayList;
import java.util.List;

public class Following extends AppCompatActivity {

    private TextView header;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<User> followings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.follows);

        header = (TextView) findViewById(R.id.header);
        header.setText("Following");


        //actionbar
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_layout);
        TextView textViewTitle = (TextView) findViewById(R.id.title);
        textViewTitle.setText(R.string.title);

        //back button enable
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //ReccyclerView
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        followings = new ArrayList<User>();

        User u;
        for(int i=0; i<=20; i++){
            u = new User(i);

            u.setUsername("ramal_"+i);
            u.setProfile_photo("cowboy_pic");
            followings.add(u);
        }

        adapter = new FollowingAdapter(followings, this);
        recyclerView.setAdapter(adapter);

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
}
