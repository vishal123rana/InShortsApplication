package com.example.inshortsapplication;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.inshortsapplication.Api.ApiClient;
import com.example.inshortsapplication.Api.ApiInterface;
import com.example.inshortsapplication.Model.Article;
import com.example.inshortsapplication.Model.News;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private VerticalViewPager viewPager;
    private ViewPagerAdapter viewAdapter;
    private List<Article> articles = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewPager1);
        LoadJson();
    }
    public void LoadJson(){
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<News> call;
        String country = "in";
        String API_KEY = "757d82e36f3c456fa1fd7fae577121be";
        call = apiInterface.getNews(country, API_KEY);
        call.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                if(response.isSuccessful()&& response.body().getArticle() != null){
                    if(!articles.isEmpty()){
                        articles.clear();
                    }
                    articles = response.body().getArticle();
                    viewAdapter = new ViewPagerAdapter(getSupportFragmentManager(),1,articles);
                    viewPager.setAdapter(viewAdapter);
                  //  viewAdapter.notifyDataSetChanged();
//                    for(Article article:articles){
//                        Log.e("title",article.getTitle());
//                        Log.e("Description",article.getDescription());
//                        Log.e("url",article.getUrl());
//                        Log.e("ImagetoUrl",article.getUrlToImage());
//                    }
                }
                else{
                    Toast.makeText(getApplicationContext(),"No Data Found!",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {

            }
        });
    }
    public void init(){}

}