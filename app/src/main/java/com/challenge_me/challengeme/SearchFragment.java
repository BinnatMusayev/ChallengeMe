package com.challenge_me.challengeme;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SearchFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        //recycler example
        //view also usedto inflate fragment
        View v = inflater.inflate(R.layout.coming_soon, container, false);



        // Inflate the layout for this fragment

        return v;

    }
}
