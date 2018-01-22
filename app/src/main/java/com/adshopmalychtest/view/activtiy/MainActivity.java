package com.adshopmalychtest.view.activtiy;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.adshopmalychtest.R;
import com.adshopmalychtest.view.fragment.MainPageFragment;

public class MainActivity extends AppCompatActivity {
    private FragmentManager mainFragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mainFragmentManager = getSupportFragmentManager();

        if (savedInstanceState == null) {
            MainPageFragment mainPageFragment = MainPageFragment.newInstance();
            mainFragmentManager.beginTransaction().replace(R.id.main_container, mainPageFragment, MainPageFragment.tag()).commit();
        }
    }

}
