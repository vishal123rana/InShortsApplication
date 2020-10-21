package com.example.inshortsapplication;


import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    int[] arr = {R.drawable.img4,R.drawable.img5,
            R.drawable.img9,R.drawable.img8,
//            R.drawable.img2,R.drawable.img6,
//            R.drawable.img7,R.drawable.img4,
//            R.drawable.img3,R.drawable.img10
            };

//    String[] headLine = {"Government extends IBC suspension by 3 more months",
//            "Harley-Davidson stops sales and manufacturing in india, lays off 70",
//            "Global labour income fell $3.5 tn in the first 9 months of 2020:ILO",
//            "Uday Kotak's term as IL&FS Chairman extended by one year"
//    };
//
//    String[] paragraph = { "Finance Minister Nirmala Sitharaman has said that the suspension of section 7,9,10 of the insolvency and Bankruptcy Code(IBC) has been extended for three more months, effective from September 25. Until the time that IBC remains suspended, no insolvency proceedings can  be initiated against any borrower for defaults arising on or after March 25,2020",
//            "Harley-Davidson on Thursday announced that it is discountinuing its sales and manufacturing operations in india, which will lead to 70  employees being laid off. The US motorcycle maker, which began operation in india in 2009, has an assembly facility in Haryana's Bawal. Harley-Davidson sold just 2,470 units in 2019-20 compared to 3413 units in 2018-2019.",
//       "The international Labour Organization (ILO) said that global labour income is estimated to  have declined by 10.7% or $3.5 trillion in the first three quarter of 2020 due to the COVID-19 pandemic. Labour income fell hardest at 15.1% in lower-middle income countries. Latin America and the Caribbean and Southern Asia were the worst hit at 19.3% and 17.6% respectively.",
//    "Kotak Mahindra Bank Managing Director Uday Kotak's term as Chairman of bankrupt infra lender IL&FS has been extended by one year by the government. Kotak was appointed as Chairman in 2018 to help the debt-ridden company's resolution after the government took control and appointed a new board. The IL&FS Group had a debt of around 1 Lakh crore"
//    };
//
//    String[] bottomText = {"Parliament cleared IBC amendments on Sept 21",
//            "Harley expects $169M in 2020 restructuring costs",
//            "Figure excludes government income support: ILO",
//            "Only 18% of debt has been resolved"
//    };
   private List<News> news;
    public ViewPagerAdapter(@NonNull FragmentManager fm, int b,List<News> news) {
        super(fm,b);
        this.news = news;
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        ChildFragment childFragment = new ChildFragment();
        Bundle bundle = new Bundle();
//        bundle.putString("Image",String.valueOf(arr[position]));
//        bundle.putString("parent",headLine[position]);
//        bundle.putString("Child",paragraph[position]);
//        bundle.putString("Bottom",bottomText[position]);
//        bundle.putString("Image", news.get(position).getImageUrl());
//        bundle.putString("Title",news.get(position).getTitle());
//        bundle.putString("Description",news.get(position).getDescription());
//        bundle.putString("Bottom",news.get(position).getBottom());
         bundle.putString("Image",news.get(position).getUrlToImage());
         bundle.putString("parent",news.get(position).getTitle());
         bundle.putString("Child",news.get(position).getDescription());
         bundle.putString("Bottom",news.get(position).getContent());
         childFragment.setArguments(bundle);
         return childFragment;
    }
    @Override
    public int getCount() {
        return news.size();
    }

}
