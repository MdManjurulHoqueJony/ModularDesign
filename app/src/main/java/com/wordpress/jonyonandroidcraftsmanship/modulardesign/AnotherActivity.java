package com.wordpress.jonyonandroidcraftsmanship.modulardesign;

import android.app.Activity;
import android.os.Bundle;

public class AnotherActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);

        int index=getIntent().getExtras().getInt("index",0);
        SecondFragment secondFragment= (SecondFragment) getFragmentManager().findFragmentById(R.id.fragDescriptions);
        if (secondFragment!=null){
            secondFragment.changeData(index);
        }
    }
}
