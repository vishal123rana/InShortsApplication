package com.example.inshortsapplication;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.inshortsapplication.Model.Article;
import java.util.List;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    List<Article> news;
    float x1,x2;
    int newpostion;
    Context context;
    VerticalViewPager verticalViewPager;
    public ViewPagerAdapter(Context context,@NonNull FragmentManager fm, int b, List<Article> news) {
        super(fm,b);
        this.news= news;
        this.context = context;
    }
    @NonNull
    @Override
    @SuppressLint("ClickableViewAccessibility")
    public Fragment getItem(int position) {
        ChildFragment childFragment = new ChildFragment();
        Bundle bundle = new Bundle();
        Article article = news.get(position);
        bundle.putString("Image",article.getUrlToImage());
        bundle.putString("parent",article.getTitle());
        bundle.putString("Child",article.getDescription());
        bundle.putString("Bottom",article.getContent());
        bundle.putString("url",article.getUrl());
         childFragment.setArguments(bundle);
//         verticalViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//             @Override
//             public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//             }
//
//             @Override
//             public void onPageSelected(int position) {
//                 newpostion = position;
//             }
//
//             @Override
//             public void onPageScrollStateChanged(int state) {
//
//             }
//         });
//         verticalViewPager.setOnTouchListener((v, event) -> {
//             switch (event.getAction()){
//                 case MotionEvent.ACTION_DOWN:
//                     x1 = event.getX();
//                     break;
//                 case MotionEvent.ACTION_UP:
//                     x2 = event.getX();
//                     float deltaX = x1 - x2;
//                     if(deltaX > 300){
//                          Intent intent = new Intent(context,right.class);
//                         intent.putExtra("url",news.get(position).getUrl());
//                         context.startActivity(intent);
//                     }
//                     else{
//                         Intent intent = new Intent(context,right.class);
//                         intent.putExtra("url",news.get(newpostion).getUrl());
//                         context.startActivity(intent);
//                     }
//                     break;
//
//             }
//             return false;
//         });
         return childFragment;
    }
    @Override
    public int getCount() {
        return news.size();
    }

}
