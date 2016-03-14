package com.wordpress.jonyonandroidcraftsmanship.modulardesign;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;


public class MainActivity extends Activity implements FirstFragment.Communicator{
    private Fragment firstFragment;
    private Fragment secondFragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getFragmentManager();
        firstFragment = fragmentManager.findFragmentById(R.id.fragTitles);
        ((FirstFragment)firstFragment).setCommunicator(this);
    }

    @Override
    public void respond(int index) {
        secondFragment= fragmentManager.findFragmentById(R.id.fragDescriptions);
        if (secondFragment!=null && secondFragment.isVisible()){
            ((SecondFragment)secondFragment).changeData(index);
        }else{
            Intent intent=new Intent(this,AnotherActivity.class);
            intent.putExtra("index",index);
            startActivity(intent);
        }
    }
}
