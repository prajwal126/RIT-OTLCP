package com.example.prajw.ritcourse;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.prajw.ritcourse.Weeks.Quiz;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class coursereg extends AppCompatActivity {
    TextView tv;
    ImageView img;
    private DatabaseReference mUserDatabase;
    private String coursename, count;
    private TextView tv1, tv2, tv3,tv4;
    static int counter = 1;
    int flag;
    private FirebaseAuth mAuth;
    int counters;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coursereg);
        tv = (TextView) findViewById(R.id.textView40);
        tv1 = (TextView) findViewById(R.id.textView35);
        tv2 = (TextView) findViewById(R.id.textView39);
        tv3 = (TextView) findViewById(R.id.textView38);
        tv4 = (TextView) findViewById(R.id.textView37);
        img = (ImageView) findViewById(R.id.imageView20);
        Intent myIntent = this.getIntent();
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = pref.edit();

        editor.putInt("counter2", counter);
        mUserDatabase = FirebaseDatabase.getInstance().getReference().child("Users");
        mAuth = FirebaseAuth.getInstance();
        if (myIntent != null) {
            String strdata = myIntent.getExtras().getString("ID");
            if (strdata.equals("Aircraft Maintenance")) {
                tv.setText("Aircraft Maintenance");
                coursename = "Aircraft Maintenance";
            }
            if (strdata.equals("Graph Theory")) {
                tv.setText("Advanced Graph Theory");
                coursename = "Advanced Graph Theory";
            }
            if (strdata.equals("AI constraint")) {
                tv.setText("AI:Constraint Satisfaction");
                coursename = "AI:Constraint Satisfaction";
            }
            if (strdata.equals("Python")) {
                tv.setText("Introduction To Python");
                coursename = "Introduction To Python";
            }
            if (strdata.equals("Android")) {
                tv.setText("Android App Development");

                coursename = "Android App Development";
            }
            if (strdata.equals("C prog")) {
                tv.setText("Introduction To C");
                coursename = "Introduction To C";
            }
            if (strdata.equals("Java")) {
                tv.setText("Introduction To Java");
                coursename = "Introduction To Java";
            }
            if (strdata.equals("microeconomics")) {
                tv.setText("Introduction To Microeconomics");
                coursename = "Introduction To Microeconomics";
            }
            if (strdata.equals("Analog IC Design")) {
                tv.setText("Analog IC Design");
                coursename = "Analog IC Design";
            }
            if (strdata.equals("Analog IC Circuit")) {
                tv.setText("Analog IC Circuit");
                coursename = "Analog IC Circuit";
            }
            if (strdata.equals("Journalism")) {
                tv.setText("Introduction To Journalism");
                coursename = "Introduction To Journalism";
            }
            if (strdata.equals("physics")) {
                tv.setText("Advanced Condensed Matter Physics");
                coursename = "Advanced Condensed Matter Physics";
            }
        }
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag=0;
                final ArrayList<String> question = new ArrayList<>() ;
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
                //counter++;
                final SharedPreferences.Editor editor = pref.edit();
                editor.putString("CourseName", coursename);
                counter=pref.getInt("Counts",counter);
                counter++;
                editor.apply();
                count = String.valueOf(counter);
                final String current_user_id = mAuth.getCurrentUser().getUid();
                mUserDatabase.child(current_user_id).child("Courses").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // Result will be holded Here
                        for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                            question.add(dsp.getValue(String.class));//add result into array list
                        }
                        if(question.contains(coursename)){
                            new AlertDialog.Builder(coursereg.this)
                                    .setTitle("ALERT")
                                    .setMessage("Course Already Registered")
                                    .setCancelable(false)
                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            // Whatever...
                                            Intent intent=new Intent(coursereg.this,MainActivity.class);
                                            startActivity(intent);
                                        }
                                    }).show();

                        }
                        else{
                            new AlertDialog.Builder(coursereg.this)
                                    .setTitle("RIT OTLCP")
                                    .setMessage("Course Successfully Registered")
                                    .setCancelable(true)
                                    .show();

                            Map messageMap = new HashMap();
                            messageMap.put(count, coursename);
                            mUserDatabase.child(current_user_id).child("Courses").updateChildren(messageMap, new DatabaseReference.CompletionListener() {
                                @Override
                                public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {

                                    if (databaseError != null) {

                                        Log.d("CHAT_LOG", databaseError.getMessage().toString());

                                    }

                                }
                            });

                        }
                    }

                        @Override
                        public void onCancelled (DatabaseError databaseError){
                        }
                    });


            }
        });
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(coursereg.this, Quiz.class);
                myIntent.putExtra("Week", "Week 1");
                myIntent.putExtra("2", coursename);
                coursereg.this.startActivity(myIntent);

            }
        });
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(coursereg.this, Quiz.class);
                myIntent.putExtra("Week", "Week 2");
                myIntent.putExtra("2", coursename);
                coursereg.this.startActivity(myIntent);

            }
        });
        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(coursereg.this, Quiz.class);
                myIntent.putExtra("Week", "Week 3");
                myIntent.putExtra("2", coursename);
                coursereg.this.startActivity(myIntent);

            }
        });
        tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(coursereg.this, Exam.class);
                myIntent.putExtra("2", coursename);
                coursereg.this.startActivity(myIntent);

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        String current_user_id = mAuth.getCurrentUser().getUid();
        mUserDatabase.child(current_user_id).child("Courses").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                 counter = (int) dataSnapshot.getChildrenCount();
                    SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putInt("counts",counter);
                    editor.commit();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });
    }
}
