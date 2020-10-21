package com.example.inshortsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.android.volley.Request.*;

public class MainActivity extends AppCompatActivity {
    private VerticalViewPager viewPager;
    private ViewPagerAdapter viewAdapter;
    List<News> news;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewPager);
        fetchData();
        viewAdapter = new ViewPagerAdapter(getSupportFragmentManager(),1,news);
        viewPager.setAdapter(viewAdapter);
    }
    public void fetchData(){
        String url = "http://newsapi.org/v2/everything?q=apple&from=2020-10-20&to=2020-10-20&sortBy=popularity&apiKey=757d82e36f3c456fa1fd7fae577121be";
        news = new ArrayList<>();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                         JSONArray jsonArray =  response.getJSONArray("articles");
                         for(int i = 0 ; i < jsonArray.length(); i++){
                             JSONObject jsonObject = jsonArray.getJSONObject(i);
                             news.add(new News(
                                     String.valueOf(jsonObject.get("title")),
                                     String.valueOf(jsonObject.get("description")),
                                     String.valueOf(jsonObject.get("url")),
                                     String.valueOf(jsonObject.get("urlToImage")),
                                     String.valueOf(jsonObject.get("content"))));
                         }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("",error.getMessage());
                    }
                });
        MySingleton.Companion.getInstance(this).addToRequestQueue(jsonObjectRequest);
    }
}