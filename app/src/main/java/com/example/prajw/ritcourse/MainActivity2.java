package com.example.prajw.ritcourse;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity2 extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser mFirebaseUser;
    DatabaseReference mUserDatabase;
    GoogleApiClient mGoogleApiClient;
    Button but,youtube,save;
    EditText edt,edt2;
    String link,Message,week,Title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        verificaUsuarioLogado();
        setContentView(R.layout.activity_main2);
        Spinner dropdown = (Spinner) findViewById(R.id.spinner1);
        Spinner dropdown2 = (Spinner) findViewById(R.id.spinner);
        String[] items = new String[]{"Introduction To Python", "Introduction To Java", "Introduction To C","Android App Development"};
        String[] weeks = new String[]{"Week 1","Week 2","Week 3"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, weeks);
        dropdown2.setAdapter(adapter2);
        but=(Button)findViewById(R.id.button6);
        edt=(EditText) findViewById(R.id.editText5);
        edt2=(EditText) findViewById(R.id.editText2);
        youtube=(Button)findViewById(R.id.button2);
        save=(Button)findViewById(R.id.button5);
        mFirebaseAuth = FirebaseAuth.getInstance();

        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                 link = (String) parent.getItemAtPosition(position);
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        dropdown2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                week = (String) parent.getItemAtPosition(position);
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

         //link = dropdown.getSelectedItem().toString();
        // week = dropdown2.getSelectedItem().toString();



        mUserDatabase = FirebaseDatabase.getInstance().getReference().child("LectureVideos");
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popup = new PopupMenu(MainActivity2.this, but);
                popup.setOnMenuItemClickListener(MainActivity2.this);
                popup.inflate(R.menu.main);
                popup.show();
            }
        });
        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                try {
                    PackageManager packageManager= getPackageManager();
                    Intent LaunchIntent = packageManager.getLaunchIntentForPackage("com.google.android.youtube");
                    startActivity(LaunchIntent);
                } catch (Exception e) {
                    e.printStackTrace();
                }     }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Message= edt.getText().toString();
                Title=  edt2.getText().toString();
                Map messageMap = new HashMap();
                messageMap.put(Title, Message);
                mUserDatabase.child(link).child(week).updateChildren(messageMap, new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {

                        if (databaseError != null) {

                            Log.d("CHAT_LOG", databaseError.getMessage().toString());
                            Toast.makeText(getApplicationContext(),Title,Toast.LENGTH_SHORT).show();
                            Toast.makeText(getApplicationContext(),Message,Toast.LENGTH_SHORT).show();

                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Successfully Submitted",Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }
        });

    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {

            //noinspection SimplifiableIfStatement
            case R.id.action_profile: {
                Intent myIntent = new Intent(MainActivity2.this, Profile.class);
                MainActivity2.this.startActivity(myIntent);
                return true;
            }
            case R.id.action_logout: {
                new AlertDialog.Builder(MainActivity2.this)
                        .setTitle("RIT OTLCP")
                        .setMessage("Do you want to log out?")
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Whatever...
                                signOut();

                            }
                        }).show();
                return true;
            }
            default:
                return false;
        }
    }


    private void verificaUsuarioLogado(){
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();
        if (mFirebaseUser == null){
            startActivity(new Intent(this, Home.class));
            finish();
        }else{

        }
    }

    private void signOut() {
        Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(
                new ResultCallback<Status>() {
                    @Override
                    public void onResult(Status status) {
                        SharedPreferences preferences =getSharedPreferences("MyPref", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.clear();
                        editor.commit();
                        finish();
                        // ...
                        Intent intent=new Intent(MainActivity2.this,Home.class);
                        startActivity(intent);
                    }
                });
    }
    protected void onStart() {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
        mGoogleApiClient.connect();
        super.onStart();
    }

}
