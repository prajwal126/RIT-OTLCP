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

public class AeroFrag  extends android.support.v4.app.Fragment{
    private ImageView img;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.frag_aero,null);
        img = (ImageView) view.findViewById(R.id.imageView11);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getActivity(), coursereg.class);
                myIntent.putExtra("ID","Aircraft Maintenance");
                AeroFrag.this.startActivity(myIntent);
            }
        });
        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
