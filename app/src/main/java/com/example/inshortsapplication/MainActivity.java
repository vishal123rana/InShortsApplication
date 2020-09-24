package com.example.inshortsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private VerticalViewPager viewPager;
    private ViewPagerAdapter viewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (VerticalViewPager)findViewById(R.id.viewPager);
        viewAdapter = new ViewPagerAdapter(getSupportFragmentManager(),1);
        viewPager.setAdapter(viewAdapter);
    }
}