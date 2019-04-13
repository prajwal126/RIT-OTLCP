package com.example.prajw.ritcourse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
   public void courseinf(View view){
       EditText ed1= (EditText) findViewById(R.id.editText3);
       Intent myIntent = new Intent(Home.this, courseinf.class);
       Home.this.startActivity(myIntent);
   }




}
