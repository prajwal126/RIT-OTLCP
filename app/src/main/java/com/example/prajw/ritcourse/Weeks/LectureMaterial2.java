package com.example.prajw.ritcourse.Weeks;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.prajw.ritcourse.MainActivity;
import com.example.prajw.ritcourse.R;
import com.example.prajw.ritcourse.util.RecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;

public class LectureMaterial2 extends AppCompatActivity {

    private static String TAG = LectureMaterial2.class.getSimpleName();
    private String[] lecnames;
    private String[] episode;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser mFirebaseUser;
    DatabaseReference mUserDatabase;
    RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        final Intent myIntent = this.getIntent();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);
        //to use RecycleView, you need a layout manager. default is LinearLayoutManager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        mFirebaseAuth = FirebaseAuth.getInstance();
        mUserDatabase = FirebaseDatabase.getInstance().getReference().child("LectureVideos");
        //lecnames=new String[3];
        //episode=new String[3];
        final SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        final SharedPreferences.Editor editor = pref.edit();

        if (myIntent != null) {
            String strdata = myIntent.getExtras().getString("lec");
            assert strdata != null;
            final ArrayList<String> question = new ArrayList<>() ;

            switch (strdata) {
                case "PYT1":
                    lecnames = new String[]{"HBxCHonP6Ro", "hnxIRVZ0EyU", "1yUn-ydsgKk"};
                    break;
                case "PYT2":
                    lecnames = new String[]{"BSNFRKG1MfE", "WN4A6iJOUns", "YV6qm6erphk"};
                    break;
                case "PYT3":
                    lecnames = new String[]{"frwqnS9ICxw", "5eO5-w2g1Ik", "avthXghx0a0"};
                    break;
                case "AAD1":
                    mUserDatabase.child("Android App Development").child("Week 1").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for(DataSnapshot ds : dataSnapshot.getChildren()) {
                                    question.add(ds.getValue(String.class));
                                 //   Toast.makeText(getApplicationContext(),episode[i],Toast.LENGTH_SHORT).show();
                            }

                            episode = new String[]{question.get(0),question.get(1),question.get(2)};

                            editor.putString("e1",episode[0]);
                            editor.putString("e2",episode[1]);
                            editor.putString("e3",episode[2]);
                            editor.apply();
                            //Toast.makeText(getApplicationContext(),lecnames[0],Toast.LENGTH_SHORT).show();

                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }

                    });
                  lecnames=new String[]{pref.getString("e1",null),pref.getString("e2",null),pref.getString("e3",null)};
                break;
                case "AAD2":
                    mUserDatabase.child("Android App Development").child("Week 2").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for(DataSnapshot ds : dataSnapshot.getChildren()) {
                                question.add(ds.getValue(String.class));
                                //   Toast.makeText(getApplicationContext(),episode[i],Toast.LENGTH_SHORT).show();
                            }

                            episode = new String[]{question.get(0),question.get(1),question.get(2)};

                            editor.putString("e1",episode[0]);
                            editor.putString("e2",episode[1]);
                            editor.putString("e3",episode[2]);
                            editor.apply();
                            //Toast.makeText(getApplicationContext(),lecnames[0],Toast.LENGTH_SHORT).show();

                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }

                    });
                    lecnames=new String[]{pref.getString("e1",null),pref.getString("e2",null),pref.getString("e3",null)};
                    break;
                case "AAD3":
                    mUserDatabase.child("Android App Development").child("Week 3").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for(DataSnapshot ds : dataSnapshot.getChildren()) {
                                question.add(ds.getValue(String.class));
                                //   Toast.makeText(getApplicationContext(),episode[i],Toast.LENGTH_SHORT).show();
                            }

                            episode = new String[]{question.get(0),question.get(1),question.get(2)};

                            editor.putString("e1",episode[0]);
                            editor.putString("e2",episode[1]);
                            editor.putString("e3",episode[2]);
                            editor.apply();
                            //Toast.makeText(getApplicationContext(),lecnames[0],Toast.LENGTH_SHORT).show();

                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }

                    });
                    lecnames=new String[]{pref.getString("e1",null),pref.getString("e2",null),pref.getString("e3",null)};
                    break;
                case "CP1":
                    lecnames = new String[] {"", "", ""};
                    break;
                case "CP2":
                    lecnames = new String[] {"", "", ""};
                    break;
                case "CP3":
                    lecnames = new String[] {"", "", ""};
                    break;
                case "JAV1":
                    lecnames = new String[]{"HBxCHonP6Ro", "hnxIRVZ0EyU", "1yUn-ydsgKk"};
                    break;
                case "JAV2":
                    lecnames = new String[]{"HBxCHonP6Ro", "hnxIRVZ0EyU", "1yUn-ydsgKk"};
                    break;
                case "JAV3":
                    lecnames = new String[]{"HBxCHonP6Ro", "hnxIRVZ0EyU", "1yUn-ydsgKk"};
                    break;
                case "ECO1":
                    lecnames = new String[]{"HBxCHonP6Ro", "hnxIRVZ0EyU", "1yUn-ydsgKk"};
                    break;
                case "ECO2":
                    lecnames = new String[]{"HBxCHonP6Ro", "hnxIRVZ0EyU", "1yUn-ydsgKk"};
                    break;
                case "ECO3":
                    lecnames = new String[]{"HBxCHonP6Ro", "hnxIRVZ0EyU", "1yUn-ydsgKk"};
                    break;
                case "ICD1":
                    lecnames = new String[]{"HBxCHonP6Ro", "hnxIRVZ0EyU", "1yUn-ydsgKk"};
                    break;
                case "ICD2":
                    lecnames = new String[]{"HBxCHonP6Ro", "hnxIRVZ0EyU", "1yUn-ydsgKk"};
                    break;
                case "ICD3":
                    lecnames = new String[]{"HBxCHonP6Ro", "hnxIRVZ0EyU", "1yUn-ydsgKk"};
                    break;
                case "ICC1":
                    lecnames = new String[]{"HBxCHonP6Ro", "hnxIRVZ0EyU", "1yUn-ydsgKk"};
                    break;
                case "ICC2":
                    lecnames = new String[]{"HBxCHonP6Ro", "hnxIRVZ0EyU", "1yUn-ydsgKk"};
                    break;
                case "ICC3":
                    lecnames = new String[]{"HBxCHonP6Ro", "hnxIRVZ0EyU", "1yUn-ydsgKk"};
                    break;
                case "J1":
                    lecnames = new String[]{"HBxCHonP6Ro", "hnxIRVZ0EyU", "1yUn-ydsgKk"};
                    break;
                case "J2":
                    lecnames = new String[]{"HBxCHonP6Ro", "hnxIRVZ0EyU", "1yUn-ydsgKk"};
                    break;
                case "J3":
                    lecnames = new String[]{"HBxCHonP6Ro", "hnxIRVZ0EyU", "1yUn-ydsgKk"};
                    break;
                case "PHY1":
                    lecnames = new String[]{"HBxCHonP6Ro", "hnxIRVZ0EyU", "1yUn-ydsgKk"};
                    break;
                case "PHY2":
                    lecnames = new String[]{"HBxCHonP6Ro", "hnxIRVZ0EyU", "1yUn-ydsgKk"};
                    break;
                case "PHY3":
                    lecnames = new String[]{"HBxCHonP6Ro", "hnxIRVZ0EyU", "1yUn-ydsgKk"};
                    break;
            }
        }
        if ( Arrays.asList( lecnames ).contains( "" ) ) {
            new AlertDialog.Builder(LectureMaterial2.this)
                    .setTitle("No Videos Uploaded")
                    .setMessage("Check Back Later")
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // Whatever...
                            Intent intent=new Intent(LectureMaterial2.this,MainActivity.class);
                            startActivity(intent);
                        }
                    }).show();
        }


        adapter = new RecyclerAdapter(this, lecnames);
        recyclerView.setAdapter(adapter);

            //adapter.notifyDataSetChanged();
        }
    @Override
    public void onStop() {
        super.onStop();

        //adapter.ReleaseLoaders();
    }

}



