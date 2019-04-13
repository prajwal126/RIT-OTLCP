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

public class ElectricalFrag  extends android.support.v4.app.Fragment{
    private ImageView img,img2;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.frag_elec,null);
        img = (ImageView) view.findViewById(R.id.imageView11);
        img2 = (ImageView) view.findViewById(R.id.imageView);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getActivity(), coursereg.class);
                myIntent.putExtra("ID","Analog IC Design");
                ElectricalFrag.this.startActivity(myIntent);
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getActivity(), coursereg.class);
                myIntent.putExtra("ID","Analog IC Circuit");
                ElectricalFrag.this.startActivity(myIntent);
            }
        });
        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
