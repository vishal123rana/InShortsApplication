package com.example.inshortsapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm,int b) {
        super(fm,b);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        ChildFragment childFragment = new ChildFragment();
        Bundle bundle = new Bundle();
        bundle.putString("parent",String.valueOf(position));
        childFragment.setArguments(bundle);
        return childFragment;
    }

    @Override
    public int getCount() {
        return 10;
    }
}
