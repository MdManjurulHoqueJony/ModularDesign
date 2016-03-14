package com.wordpress.jonyonandroidcraftsmanship.modulardesign;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SecondFragment extends Fragment {

    private TextView tvDescription;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        tvDescription= (TextView) view.findViewById(R.id.tvDescription);
        return view;
    }

    public void changeData(int index){
        String[] descriptions=getResources().getStringArray(R.array.descriptions);
        tvDescription.setText(descriptions[index]);
    }
}
