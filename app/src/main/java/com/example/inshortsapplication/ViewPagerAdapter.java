package com.example.inshortsapplication;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import androidx.fragment.app.FragmentManager;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.example.inshortsapplication.Model.Article;
import java.util.List;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
//    int[] arr = {R.drawable.img4,R.drawable.img5,
//            R.drawable.img9,R.drawable.img8,
////            R.drawable.img2,R.drawable.img6,
////            R.drawable.img7,R.drawable.img4,
////            R.drawable.img3,R.drawable.img10
//            };

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
//    private final List<News> articleList = new ArrayList<>();
//      public void fetchData(Context context){
//             RequestQueue requestQueue = Volley.newRequestQueue(context);
//             String apiUrl = "https://newsapi.org/v2/top-headlines?country=us&apiKey=757d82e36f3c456fa1fd7fae577121be";
//             JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
//              apiUrl, null, response -> {
//        Log.e("Rest Response ",response.toString());
//        try {
//            JSONArray jsonArray = response.getJSONArray("articles");
//            for(int i = 0 ; i < jsonArray.length(); i++){
//                JSONObject jsonObject = jsonArray.getJSONObject(i);
//                News news = new News(jsonObject.getString("urlToImage"),
//                        jsonObject.getString("title"),
//                        jsonObject.getString("description"),
//                        jsonObject.getString("content"));
//                articleList.add(news);
//            }
//            Log.e("Article Size",String.valueOf(articleList.size()));
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }, error -> {
//        Log.e("Rest Response",error.toString());
//    });
//    requestQueue.add(jsonObjectRequest);
//
//}
    List<Article> articles;
    public ViewPagerAdapter(@NonNull FragmentManager fm, int b,List<Article> articles) {
        super(fm,b);
        this.articles = articles;
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        ChildFragment childFragment = new ChildFragment();
        Bundle bundle = new Bundle();
        Article article = articles.get(position);
        bundle.putString("Image",article.getUrlToImage());
        bundle.putString("parent",article.getTitle());
        bundle.putString("Child",article.getDescription());
        bundle.putString("Bottom",article.getAuthor());
         childFragment.setArguments(bundle);
         return childFragment;
    }
    @Override
    public int getCount() {
        return articles.size();
    }

}
