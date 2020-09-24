package com.example.inshortsapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
public class ChildFragment extends Fragment {
   TextView tvParent,tvChild;
   public ChildFragment(){

   }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_child,container,false);
       tvParent = (TextView)view.findViewById(R.id.tvParent);
       tvChild = (TextView)view.findViewById(R.id.tvChild);
       Bundle bundle = getArguments();
        assert bundle != null;
        tvParent.setText(String.format("Parent%s", bundle.getString("parent")));
       tvChild.setText(String.format("Child%s", bundle.getString("Child")));
        return view;
    }
}
