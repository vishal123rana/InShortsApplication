package com.example.inshortsapplication;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private VerticalViewPager viewPager;
    private ViewPagerAdapter viewAdapter;
    private News news;
    private List<Article> articleList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewPager);
        articleList = fetchData();
    //    new HTTPReqTask().execute();
        viewAdapter = new ViewPagerAdapter(getSupportFragmentManager(),1,articleList);
        viewPager.setAdapter(viewAdapter);
    }
    public List<Article> fetchData(){
        try {
            String BASE_URL = "http://newsapi.org/v2/everything?q=apple&from=2020-10-20&to=2020-10-20&sortBy=popularity&apiKey=757d82e36f3c456fa1fd7fae577121be";
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            news = restTemplate.getForObject(BASE_URL,News.class);
            if(news==null){
               Log.d("","news is empty");
            }
            return news.getArticles();
        }catch (Exception exception){
            Log.d("",exception.getMessage());
        }
        return null;
    }
}