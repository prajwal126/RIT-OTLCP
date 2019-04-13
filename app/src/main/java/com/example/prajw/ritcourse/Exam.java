package com.example.prajw.ritcourse;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.prajw.ritcourse.PayU.PayUMainActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Exam extends AppCompatActivity {
    private DatabaseReference mUserDatabase;
    private FirebaseAuth mAuth;Intent myIntent;
    String coursename;
    String score;
    long sc=0;
    static long counter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);

        mUserDatabase = FirebaseDatabase.getInstance().getReference().child("Users");
        mAuth = FirebaseAuth.getInstance();
        myIntent = this.getIntent();
        TextView tv=(TextView)findViewById(R.id.cname);
        coursename=myIntent.getExtras().getString("2");
        tv.setText(coursename);
        Button but=(Button)findViewById(R.id.button7);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Exam.this, PayUMainActivity.class);
                intent.putExtra("2", coursename);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onStart() {
        counter=0;
        super.onStart();
        String current_user_id = mAuth.getCurrentUser().getUid();
        mUserDatabase.child(current_user_id).child("Scores").child(coursename).child("Week1").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    sc= ds.getValue(Long.class);
                    counter=counter+sc;
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });
        mUserDatabase.child(current_user_id).child("Scores").child(coursename).child("Week2").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    sc= ds.getValue(Long.class);
                    counter=counter+sc;
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });
        mUserDatabase.child(current_user_id).child("Scores").child(coursename).child("Week3").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    sc= ds.getValue(Long.class);
                    counter=counter+sc;
                }
                if(counter<7)  {
                    AlertDialog alertDialog = new AlertDialog.Builder(Exam.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("You are not eligible for the examination");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent myIntent = new Intent(Exam.this, MainActivity.class);
                                    Exam.this.startActivity(myIntent);
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });


    }
    }


