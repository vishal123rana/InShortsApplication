package com.example.inshortsapplication;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

import java.util.Objects;

public class ChildFragment extends Fragment {
   TextView tvParent,tvChild;
   ImageView image;
   Button bottom;
   public ChildFragment(){

   }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_child,container,false);
       tvParent = view.findViewById(R.id.tvParent);
       tvChild = view.findViewById(R.id.tvChild);
       image = view.findViewById(R.id.imageView);
       bottom = view.findViewById(R.id.bottom1);
       Bundle bundle = getArguments();
       assert bundle != null;
       Glide.with(this).load(bundle.getString("Image")).into(image);
       tvParent.setText( bundle.getString("parent"));
       tvChild.setText(bundle.getString("Child"));
       String text = "Tap to Know More";
       bottom.setText(text);
       String url = bundle.getString("url");
       bottom.setOnClickListener(view1 -> {
           try{
              Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
              startActivity(intent);
           }catch (ActivityNotFoundException e){
              Log.e("No Request Handle",e.getMessage());
           }
       });
       return view;
    }
}
