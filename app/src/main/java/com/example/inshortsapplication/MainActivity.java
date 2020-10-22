package com.example.inshortsapplication;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private VerticalViewPager viewPager;
    private ViewPagerAdapter viewAdapter;
    List<News> newsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewPager);
        newsList = new ArrayList<>();
        fetchData();
    //    new HTTPReqTask().execute();
        viewAdapter = new ViewPagerAdapter(getSupportFragmentManager(),1,newsList);
        viewPager.setAdapter(viewAdapter);
    }
    public void fetchData(){
//        try {
//            String BASE_URL = "http://newsapi.org/v2/everything?q=apple&from=2020-10-20&to=2020-10-20&sortBy=popularity&apiKey=757d82e36f3c456fa1fd7fae577121be";
//            RestTemplate restTemplate = new RestTemplate();
//            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
//            news = restTemplate.getForObject(BASE_URL,News.class);
//            if(news==null){
//               Log.d("","news is empty");
//            }
//            return news.getArticles();
//        }catch (Exception exception){
//            Log.d("",exception.getMessage());
//        }
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String apiUrl = "https://newsapi.org/v2/top-headlines?country=us&apiKey=757d82e36f3c456fa1fd7fae577121be";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                apiUrl, null, response -> {
              Log.e("Rest Response ",response.toString());
            try {
                JSONArray jsonArray = response.getJSONArray("articles");
                for(int i = 0 ; i < jsonArray.length(); i++){
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    News news = new News(jsonObject.getString("urlToImage"),
                            jsonObject.getString("title"),
                            jsonObject.getString("description"),
                            jsonObject.getString("content"));
                    newsList.add(news);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }, error -> {
            Log.e("Rest Response",error.toString());
        });
        requestQueue.add(jsonObjectRequest);

    }
}