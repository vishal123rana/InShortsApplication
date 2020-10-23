package com.example.inshortsapplication;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.inshortsapplication.Api.ApiClient;
import com.example.inshortsapplication.Api.ApiInterface;
import com.example.inshortsapplication.Model.Article;
import com.example.inshortsapplication.Model.News;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private VerticalViewPager viewPager;
    private ViewPagerAdapter viewAdapter;
    private String API_KEY = "757d82e36f3c456fa1fd7fae577121be";
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
        String country = "us";
        call = apiInterface.getNews(country,API_KEY);
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
                    for(Article article:articles){
                        Log.e("title",article.getTitle());
                        Log.e("Description",article.getDescription());
                        Log.e("url",article.getUrl());
                        Log.e("ImagetoUrl",article.getUrlToImage());
                    }
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
//    public  void fetchData(){
////        try {
////            String BASE_URL = "http://newsapi.org/v2/everything?q=apple&from=2020-10-20&to=2020-10-20&sortBy=popularity&apiKey=757d82e36f3c456fa1fd7fae577121be";
////            RestTemplate restTemplate = new RestTemplate();
////            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
////            news = restTemplate.getForObject(BASE_URL,News.class);
////            if(news==null){
////               Log.d("","news is empty");
////            }
////            return news.getArticles();
////        }catch (Exception exception){
////            Log.d("",exception.getMessage());
////        }
//        RequestQueue requestQueue = Volley.newRequestQueue(this);
//        String apiUrl = "https://newsapi.org/v2/top-headlines?country=us&apiKey=757d82e36f3c456fa1fd7fae577121be";
//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
//                apiUrl, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                Log.e("Rest Response ", response.toString());
//                try {
//                    JSONArray jsonArray = response.getJSONArray("articles");
//                    for (int i = 0; i < jsonArray.length(); i++) {
//                        JSONObject jsonObject = jsonArray.getJSONObject(i);
//                        News news = new News(jsonObject.getString("urlToImage"),
//                                jsonObject.getString("title"),
//                                jsonObject.getString("description"),
//                                jsonObject.getString("content"));
//                        list.add(news);
////                    Log.e("title",jsonObject.getString("title"));
////                    Log.e("description",jsonObject.getString("description"));
////                    Log.e("content",jsonObject.getString("content"));
//                    }
//                    ///   Log.e("Article Size",String.valueOf(newsList.size()));
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, error -> {
//            Log.e("Rest Response",error.toString());
//        });
//        requestQueue.add(jsonObjectRequest);
//    }
}