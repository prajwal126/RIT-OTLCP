package com.example.prajw.ritcourse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class courseinf extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courseinf);
    }
    public void goglogin(View view){
        //EditText ed1= (EditText) findViewById(R.id.editText3);
        Intent myIntent = new Intent(courseinf.this, LoginActivity.class);
        courseinf.this.startActivity(myIntent);
    }
}
