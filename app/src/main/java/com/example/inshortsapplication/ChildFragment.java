package com.example.inshortsapplication;

import android.content.ActivityNotFoundException;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

import java.net.URI;
import java.util.Objects;

public class ChildFragment extends Fragment {
   TextView tvParent,tvChild;
   ImageView image,image2;
   public ChildFragment(){

   }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_child,container,false);
       tvParent = view.findViewById(R.id.tvParent);
       tvChild = view.findViewById(R.id.tvChild);
       image = view.findViewById(R.id.imageView);
       image2 = view.findViewById(R.id.imageview2);
       Bundle bundle = getArguments();
       assert bundle != null;
       Glide.with(this).load(bundle.getString("Image")).into(image);
       tvParent.setText( bundle.getString("parent"));
       tvChild.setText(bundle.getString("Child"));
       String text = "Tap to Know More";
       Glide.with(this).load(bundle.getString("Image")).into(image2);
       String url = bundle.getString("url");
       image2.setOnClickListener(view1 -> {
          try {
             CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
             builder.setToolbarColor(Color.parseColor("#FF0000"));  // Light Red
             CustomTabsIntent customTabsIntent = builder.build();
             customTabsIntent.launchUrl(Objects.requireNonNull(getContext()), Uri.parse(url));

          }catch (ActivityNotFoundException e){
             Log.e("No Request Handle",e.getMessage());
          }
       });
       return view;
    }
}
