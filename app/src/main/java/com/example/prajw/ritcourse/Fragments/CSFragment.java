package com.example.prajw.ritcourse.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.prajw.ritcourse.R;
import com.example.prajw.ritcourse.coursereg;

/**
 * Created by prajw on 2/27/2018.
 */

public class CSFragment extends android.support.v4.app.Fragment{
    private ImageView img,img1,img2,img3,img4,img5;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.frag_cs,null);
        img = (ImageView) view.findViewById(R.id.imageView11);
        img1 = (ImageView) view.findViewById(R.id.imageView);
        img2 = (ImageView) view.findViewById(R.id.imageView10);
        img3 = (ImageView) view.findViewById(R.id.imageView4);
        img4 = (ImageView) view.findViewById(R.id.imageView6);
        img5 = (ImageView) view.findViewById(R.id.imageView7);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getActivity(), coursereg.class);
                myIntent.putExtra("ID","Graph Theory");
                CSFragment.this.startActivity(myIntent);
            }
        });
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getActivity(), coursereg.class);
                myIntent.putExtra("ID","AI constraint");
                CSFragment.this.startActivity(myIntent);
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getActivity(), coursereg.class);
                myIntent.putExtra("ID","Python");
                CSFragment.this.startActivity(myIntent);
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getActivity(), coursereg.class);
                myIntent.putExtra("ID","Android");
                CSFragment.this.startActivity(myIntent);
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getActivity(), coursereg.class);
                myIntent.putExtra("ID","C prog");
                CSFragment.this.startActivity(myIntent);
            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getActivity(), coursereg.class);
                myIntent.putExtra("ID","Java");
                CSFragment.this.startActivity(myIntent);
            }
        });
        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
