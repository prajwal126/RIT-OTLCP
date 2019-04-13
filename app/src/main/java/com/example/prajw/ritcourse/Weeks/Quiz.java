package com.example.prajw.ritcourse.Weeks;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.example.prajw.ritcourse.R;

public class Quiz extends AppCompatActivity {
    private LinearLayout layout1,layout2;Intent myIntent;
    String coursename,strdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        layout1=(LinearLayout)findViewById(R.id.linearLayout);
        layout2=(LinearLayout)findViewById(R.id.linearLayout4);
        myIntent = this.getIntent();
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        coursename=myIntent.getExtras().getString("2");
        SharedPreferences.Editor editor = pref.edit();
        strdata = myIntent.getExtras().getString("Week");

        layout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(myIntent !=null) {
                    assert strdata != null;
                    switch (strdata) {
                        case "Week 1":
                            switch (coursename) {
                                case "Introduction To Python": {
                                    Intent ii = new Intent(Quiz.this, LectureMaterial2.class);
                                    ii.putExtra("lec", "PYT1");
                                    startActivity(ii);
                                    break;
                                }
                                case "Android App Development": {
                                    Intent ii = new Intent(Quiz.this, LectureMaterial2.class);
                                    ii.putExtra("lec", "AAD1");
                                    startActivity(ii);
                                    break;
                                }
                                case "Introduction To C": {
                                    Intent ii = new Intent(Quiz.this, LectureMaterial2.class);
                                    ii.putExtra("lec", "CP1");
                                    startActivity(ii);
                                    break;
                                }
                                case "Introduction To Java": {
                                    Intent ii = new Intent(Quiz.this, LectureMaterial2.class);
                                    ii.putExtra("lec", "JAV1");
                                    startActivity(ii);
                                    break;
                                }
                                case "Introduction To Microeconomics": {
                                    Intent ii = new Intent(Quiz.this, LectureMaterial2.class);
                                    ii.putExtra("lec", "ECO1");
                                    startActivity(ii);
                                    break;
                                }
                                case "Analog IC Design": {
                                    Intent ii = new Intent(Quiz.this, LectureMaterial2.class);
                                    ii.putExtra("lec", "ICD1");
                                    startActivity(ii);
                                    break;
                                }
                                case "Analog IC Circuit": {
                                    Intent ii = new Intent(Quiz.this, LectureMaterial2.class);
                                    ii.putExtra("lec", "ICC1");
                                    startActivity(ii);
                                    break;
                                }
                                case "Introduction To Journalism": {

                                    Intent ii = new Intent(Quiz.this, LectureMaterial2.class);
                                    ii.putExtra("lec", "J1");
                                    startActivity(ii);
                                    break;
                                }
                                case "Advanced Condensed Matter Physics": {
                                    Intent ii = new Intent(Quiz.this, LectureMaterial2.class);
                                    ii.putExtra("lec", "PHY1");
                                    startActivity(ii);
                                    break;
                                }
                            }
                            break;
                        case "Week 2":
                            switch (coursename) {
                                case "Introduction To Python": {
                                    Intent i = new Intent(Quiz.this, LectureMaterial2.class);
                                    i.putExtra("lec", "PYT2");
                                    startActivity(i);
                                    break;
                                }
                                case "Android App Development": {
                                    Intent i = new Intent(Quiz.this, LectureMaterial2.class);
                                    i.putExtra("lec", "AAD2");
                                    startActivity(i);
                                    break;
                                }
                                case "Introduction To C": {
                                    Intent ii = new Intent(Quiz.this, LectureMaterial2.class);
                                    ii.putExtra("lec", "CP2");
                                    startActivity(ii);
                                    break;
                                }
                                case "Introduction To Java": {
                                    Intent ii = new Intent(Quiz.this, LectureMaterial2.class);
                                    ii.putExtra("lec", "JAV2");
                                    startActivity(ii);
                                    break;
                                }
                                case "Introduction To Microeconomics": {
                                    Intent ii = new Intent(Quiz.this, LectureMaterial2.class);
                                    ii.putExtra("lec", "ECO2");
                                    startActivity(ii);
                                    break;
                                }
                                case "Analog IC Design": {
                                    Intent ii = new Intent(Quiz.this, LectureMaterial2.class);
                                    ii.putExtra("lec", "ICD2");
                                    startActivity(ii);
                                    break;
                                }
                                case "Analog IC Circuit": {
                                    Intent ii = new Intent(Quiz.this, LectureMaterial2.class);
                                    ii.putExtra("lec", "ICC2");
                                    startActivity(ii);
                                    break;
                                }
                                case "Introduction To Journalism": {

                                    Intent ii = new Intent(Quiz.this, LectureMaterial2.class);
                                    ii.putExtra("lec", "J2");
                                    startActivity(ii);
                                    break;
                                }
                                case "Advanced Condensed Matter Physics": {
                                    Intent ii = new Intent(Quiz.this, LectureMaterial2.class);
                                    ii.putExtra("lec", "PHY2");
                                    startActivity(ii);
                                    break;
                                }
                            }
                            break;
                        default:
                            switch (coursename) {
                                case "Introduction To Python": {
                                    Intent i = new Intent(Quiz.this, LectureMaterial2.class);
                                    i.putExtra("lec", "PYT3");
                                    startActivity(i);
                                    break;
                                }
                                case "Android App Development": {
                                    Intent i = new Intent(Quiz.this, LectureMaterial2.class);
                                    i.putExtra("lec", "AAD3");
                                    startActivity(i);
                                    break;
                                }
                                case "Introduction To C": {
                                    Intent ii = new Intent(Quiz.this, LectureMaterial2.class);
                                    ii.putExtra("lec", "CP3");
                                    startActivity(ii);
                                    break;
                                }
                                case "Introduction To Java": {
                                    Intent ii = new Intent(Quiz.this, LectureMaterial2.class);
                                    ii.putExtra("lec", "JAV3");
                                    startActivity(ii);
                                    break;
                                }
                                case "Introduction To Microeconomics": {
                                    Intent ii = new Intent(Quiz.this, LectureMaterial2.class);
                                    ii.putExtra("lec", "ECO3");
                                    startActivity(ii);
                                    break;
                                }
                                case "Analog IC Design": {
                                    Intent ii = new Intent(Quiz.this, LectureMaterial2.class);
                                    ii.putExtra("lec", "ICD3");
                                    startActivity(ii);
                                    break;
                                }
                                case "Analog IC Circuit": {
                                    Intent ii = new Intent(Quiz.this, LectureMaterial2.class);
                                    ii.putExtra("lec", "ICC3");
                                    startActivity(ii);
                                    break;
                                }
                                case "Introduction To Journalism": {

                                    Intent ii = new Intent(Quiz.this, LectureMaterial2.class);
                                    ii.putExtra("lec", "J3");
                                    startActivity(ii);
                                    break;
                                }
                                case "Advanced Condensed Matter Physics": {
                                    Intent ii = new Intent(Quiz.this, LectureMaterial2.class);
                                    ii.putExtra("lec", "PHY3");
                                    startActivity(ii);
                                    break;
                                }
                            }
                            break;
                    }
                }
            }
        });
        layout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(myIntent !=null) {
                    //strdata = myIntent.getExtras().getString("Week");
                    assert strdata != null;
                    switch (strdata) {
                        case "Week 1":
                            switch (coursename) {
                                case "Introduction To Python": {
                                    Intent i = new Intent(Quiz.this, Questions.class);
                                    i.putExtra("lec", "PYT1");
                                    startActivity(i);
                                    break;
                                }
                                case "Android App Development": {
                                    Intent  i = new Intent(Quiz.this, Questions.class);
                                    i.putExtra("lec", "AAD1");
                                    startActivity(i);
                                    break;
                                }
                                case "Introduction To C": {
                                    Intent ii = new Intent(Quiz.this, Questions.class);
                                    ii.putExtra("lec", "CP1");
                                    startActivity(ii);
                                    break;
                                }
                                case "Introduction To Java": {
                                    Intent ii = new Intent(Quiz.this, Questions.class);
                                    ii.putExtra("lec", "JAV1");
                                    startActivity(ii);
                                    break;
                                }
                                case "Introduction To Microeconomics": {
                                    Intent ii = new Intent(Quiz.this, Questions.class);
                                    ii.putExtra("lec", "ECO1");
                                    startActivity(ii);
                                    break;
                                }
                                case "Analog IC Design": {
                                    Intent ii = new Intent(Quiz.this, Questions.class);
                                    ii.putExtra("lec", "ICD1");
                                    startActivity(ii);
                                    break;
                                }
                                case "Analog IC Circuit": {
                                    Intent ii = new Intent(Quiz.this, Questions.class);
                                    ii.putExtra("lec", "ICC1");
                                    startActivity(ii);
                                    break;
                                }
                                case "Introduction To Journalism": {

                                    Intent ii = new Intent(Quiz.this, Questions.class);
                                    ii.putExtra("lec", "J1");
                                    startActivity(ii);
                                    break;
                                }
                                case "Advanced Condensed Matter Physics": {
                                    Intent ii = new Intent(Quiz.this, Questions.class);
                                    ii.putExtra("lec", "PHY1");
                                    startActivity(ii);
                                    break;
                                }
                            }
                            break;
                        case "Week 2":
                            switch (coursename) {
                                case "Introduction To Python": {
                                    Intent i = new Intent(Quiz.this, Questions.class);
                                    i.putExtra("lec", "PYT2");
                                    startActivity(i);
                                    break;
                                }
                                case "Android App Development": {
                                    Intent i = new Intent(Quiz.this, Questions.class);
                                    i.putExtra("lec", "AAD2");
                                    startActivity(i);
                                    break;
                                }
                                case "Introduction To C": {
                                    Intent ii = new Intent(Quiz.this, Questions.class);
                                    ii.putExtra("lec", "CP2");
                                    startActivity(ii);
                                    break;
                                }
                                case "Introduction To Java": {
                                    Intent ii = new Intent(Quiz.this, Questions.class);
                                    ii.putExtra("lec", "JAV2");
                                    startActivity(ii);
                                    break;
                                }
                                case "Introduction To Microeconomics": {
                                    Intent ii = new Intent(Quiz.this, Questions.class);
                                    ii.putExtra("lec", "ECO2");
                                    startActivity(ii);
                                    break;
                                }
                                case "Analog IC Design": {
                                    Intent ii = new Intent(Quiz.this, Questions.class);
                                    ii.putExtra("lec", "ICD2");
                                    startActivity(ii);
                                    break;
                                }
                                case "Analog IC Circuit": {
                                    Intent ii = new Intent(Quiz.this, Questions.class);
                                    ii.putExtra("lec", "ICC2");
                                    startActivity(ii);
                                    break;
                                }
                                case "Introduction To Journalism": {

                                    Intent ii = new Intent(Quiz.this, Questions.class);
                                    ii.putExtra("lec", "J2");
                                    startActivity(ii);
                                    break;
                                }
                                case "Advanced Condensed Matter Physics": {
                                    Intent ii = new Intent(Quiz.this, Questions.class);
                                    ii.putExtra("lec", "PHY2");
                                    startActivity(ii);
                                    break;
                                }
                            }
                            break;
                        default:
                            switch (coursename) {
                                case "Introduction To Python": {
                                    Intent i = new Intent(Quiz.this, Questions.class);
                                    i.putExtra("lec", "PYT3");
                                    startActivity(i);
                                    break;
                                }
                                case "Android App Development": {
                                    Intent i = new Intent(Quiz.this, Questions.class);
                                    i.putExtra("lec", "AAD3");
                                    startActivity(i);
                                    break;
                                }
                                case "Introduction To C": {
                                    Intent ii = new Intent(Quiz.this, Questions.class);
                                    ii.putExtra("lec", "CP3");
                                    startActivity(ii);
                                    break;
                                }
                                case "Introduction To Java": {
                                    Intent ii = new Intent(Quiz.this, Questions.class);
                                    ii.putExtra("lec", "JAV3");
                                    startActivity(ii);
                                    break;
                                }
                                case "Introduction To Microeconomics": {
                                    Intent ii = new Intent(Quiz.this, Questions.class);
                                    ii.putExtra("lec", "ECO3");
                                    startActivity(ii);
                                    break;
                                }
                                case "Analog IC Design": {
                                    Intent ii = new Intent(Quiz.this, Questions.class);
                                    ii.putExtra("lec", "ICD3");
                                    startActivity(ii);
                                    break;
                                }
                                case "Analog IC Circuit": {
                                    Intent ii = new Intent(Quiz.this, Questions.class);
                                    ii.putExtra("lec", "ICC3");
                                    startActivity(ii);
                                    break;
                                }
                                case "Introduction To Journalism": {

                                    Intent ii = new Intent(Quiz.this, Questions.class);
                                    ii.putExtra("lec", "J3");
                                    startActivity(ii);
                                    break;
                                }
                                case "Advanced Condensed Matter Physics": {
                                    Intent ii = new Intent(Quiz.this, Questions.class);
                                    ii.putExtra("lec", "PHY3");
                                    startActivity(ii);
                                    break;
                                }
                            }
                            break;
                    }
                };
            }
        });

        }
}
