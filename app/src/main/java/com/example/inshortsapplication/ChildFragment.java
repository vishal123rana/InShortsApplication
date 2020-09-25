package com.example.inshortsapplication;

import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Objects;

public class ChildFragment extends Fragment {
   TextView tvParent,tvChild;
   ImageView image;
   public ChildFragment(){

   }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_child,container,false);
       tvParent = (TextView)view.findViewById(R.id.tvParent);
       tvChild = (TextView)view.findViewById(R.id.tvChild);
       image = (ImageView)view.findViewById(R.id.imageView);
       Bundle bundle = getArguments();
       assert bundle != null;
       image.setImageResource(Integer.parseInt(Objects.requireNonNull(bundle.getString("Image"))));
       tvParent.setText( bundle.getString("parent"));
       tvChild.setText(bundle.getString("Child"));
       return view;
    }
}
