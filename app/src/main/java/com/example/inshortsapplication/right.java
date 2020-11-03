package com.example.inshortsapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import java.util.Objects;

import static java.security.AccessController.getContext;
import static java.util.Objects.requireNonNull;

public class right extends AppCompatActivity {
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        builder.setToolbarColor(Color.parseColor("#FF0000"));
        CustomTabsIntent customTabsIntent = builder.build();
        customTabsIntent.launchUrl(this, Uri.parse(url));
    }
}