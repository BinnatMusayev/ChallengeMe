package com.challenge_me.challengeme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SettingsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        //recycler example
        //view also usedto inflate fragment
        View v = inflater.inflate(R.layout.settings, container, false);



        // Inflate the layout for this fragment

        return v;

    }

}
