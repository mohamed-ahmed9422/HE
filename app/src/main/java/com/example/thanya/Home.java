package com.example.thanya;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.startapp.android.publish.adsCommon.StartAppAd;
import com.startapp.android.publish.adsCommon.StartAppSDK;

public class Home extends AppCompatActivity {
    private StartAppAd startAppAd = new StartAppAd(Home.this);
    TabLayout tablayoutHome;

    ViewPager viewpagerHome;
    ViewPagerWithFragmentAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        viewpagerHome = (ViewPager)findViewById(R.id.viewpager);
        tablayoutHome = (TabLayout) findViewById(R.id.tablayout_home);
        viewpagerHome.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayoutHome));
        adapter = new ViewPagerWithFragmentAdapter(getSupportFragmentManager());
        adapter.addPager(new SportsFragment() , getString(R.string.sport));
        adapter.addPager(new PoliticsFragment(), getString(R.string.politics));
        adapter.addPager(new NatureFragment(), getString(R.string.nature));
        viewpagerHome.setAdapter(adapter);
        tablayoutHome.setupWithViewPager(viewpagerHome);
        StartAppSDK.init(this, 	"210566800", true);



    }
    @Override
    public void onBackPressed() {
        StartAppAd.onBackPressed(this);
        super.onBackPressed();
    }
}
