package com.example.prajw.ritcourse.Weeks;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.prajw.ritcourse.MainActivity;
import com.example.prajw.ritcourse.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Questions extends AppCompatActivity {
    RadioGroup rg1,rg2,rg3,rg4,rg5;
    RadioButton r1,r2,r3,r4,r5,r6,r7,r8,r9,r10,r11,r12,r13,r14,r15,r16,r17,r18,r19,r20,rbut;
    TextView tv,tv1,tv2,tv3,tv4,tv5;
    int index;
    Button submit;
    String[] name;
    private DatabaseReference mUserDatabase,mUser;
    static int points=0;
    int id,id1,id2,id3,id4;
    private FirebaseAuth mFirebaseAuth;
    final ArrayList<String> answer = new ArrayList<>() ;
    String coursenames,current_user_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        rg1=(RadioGroup)findViewById(R.id.radioGroup1);
        rg2=(RadioGroup)findViewById(R.id.radioGroup2);
        rg4=(RadioGroup)findViewById(R.id.radioGroup4);
        rg5=(RadioGroup)findViewById(R.id.radioGroup5);
        rg3=(RadioGroup)findViewById(R.id.radioGroup3);
        r1=(RadioButton)findViewById(R.id.radioButton);
        r2=(RadioButton)findViewById(R.id.radioButton2);
        r3=(RadioButton)findViewById(R.id.radioButton3);
        r4=(RadioButton)findViewById(R.id.radioButton4);
        r5=(RadioButton)findViewById(R.id.radioButton5);
        r6=(RadioButton)findViewById(R.id.radioButton6);
        r7=(RadioButton)findViewById(R.id.radioButton7);
        r8=(RadioButton)findViewById(R.id.radioButton8);
        r9=(RadioButton)findViewById(R.id.radioButton10);
        r10=(RadioButton)findViewById(R.id.radioButton11);
        r11=(RadioButton)findViewById(R.id.radioButton12);
        r12=(RadioButton)findViewById(R.id.radioButton13);
        r13=(RadioButton)findViewById(R.id.radioButton14);
        r14=(RadioButton)findViewById(R.id.radioButton15);
        r15=(RadioButton)findViewById(R.id.radioButton16);
        r16=(RadioButton)findViewById(R.id.radioButton17);
        r17=(RadioButton)findViewById(R.id.radioButton18);
        r18=(RadioButton)findViewById(R.id.radioButton19);
        r19=(RadioButton)findViewById(R.id.radioButton20);
        r20=(RadioButton)findViewById(R.id.radioButton21);
        tv=(TextView)findViewById(R.id.textView);
        tv1=(TextView)findViewById(R.id.textView1);
        tv2=(TextView)findViewById(R.id.textView2);
        tv3=(TextView)findViewById(R.id.textView9);
        tv4=(TextView)findViewById(R.id.textView4);
        tv5=(TextView)findViewById(R.id.textView5);
        mFirebaseAuth = FirebaseAuth.getInstance();
        current_user_id = mFirebaseAuth.getCurrentUser().getUid();
        submit=(Button)findViewById(R.id.button4);
        mUserDatabase = FirebaseDatabase.getInstance().getReference().child("Questions");
        mUser = FirebaseDatabase.getInstance().getReference().child("Users");
        Intent myIntent = this.getIntent();
        final String strdata = myIntent.getExtras().getString("lec");
        if (myIntent != null) {
            assert strdata != null;
            if (strdata.equals("PYT1")) {
                coursenames="PYT1";
                tv.setText("Python Week 1");
                //DatabaseReference pyt;
                final DatabaseReference pyt,pyt2;
                final ArrayList<String> question = new ArrayList<>() ;

                pyt=mUserDatabase.child("Python").child("Week1");
                pyt.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {


                        // Result will be holded Here
                        for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                            question.add(dsp.getKey());//add result into array list
                        }
                            r1.setText("(123, 'john', 123, 'john')");
                            r2.setText("(123, 'john') * 2");
                            r3.setText("Error");
                            r4.setText("None of the above.");
                            r5.setText("repr(x)");
                            r6.setText("eval(str)");
                            r7.setText("tuple(s)");
                            r8.setText("list(s)");
                            r9.setText("isupper()");
                            r10.setText("join(seq)");
                            r11.setText("len(string)");
                            r12.setText("ljust(width[, fillchar])");
                            r13.setText("lower()");
                            r14.setText("lstrip()");
                            r15.setText("max(str)");
                            r16.setText("min(str)");
                            r17.setText("Python is a high-level, interpreted, interactive and object-oriented scripting language.");
                            r18.setText("Python is designed to be highly readable.");
                            r19.setText("It uses English keywords frequently where as other languages use punctuation, and it has fewer syntactical constructions than other languages.");
                            r20.setText("All of the above.");
                        tv1.setText(question.get(0));
                        tv2.setText(question.get(1));
                        tv3.setText(question.get(2));
                        tv4.setText(question.get(3));
                        tv5.setText(question.get(4));

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });


            }
            if (strdata.equals("PYT2")) {
                coursenames="PYT2";
                tv.setText("Python Week 2");
                //DatabaseReference pyt;
                final DatabaseReference pyt,pyt2;
                final ArrayList<String> question = new ArrayList<>() ;

                pyt=mUserDatabase.child("Python").child("Week2");
                pyt.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {


                        // Result will be holded Here
                        for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                            question.add(dsp.getKey());//add result into array list
                        }
                        r1.setText("Client");
                        r2.setText("Docstring");
                        r3.setText("Interface");
                        r4.setText("Modularity");
                        r5.setText("infile.read(2)");
                        r6.setText("infile.read()");
                        r7.setText("infile.readline()");
                        r8.setText("infile.readlines()");
                        r9.setText("The namespace of imported module becomes part of importing module");
                        r10.setText("This form of import prevents name clash");
                        r11.setText("The namespace of imported module becomes available to importing module");
                        r12.setText("The identifiers in module are accessed as: modulename.identifier");
                        r13.setText("d = {}");
                        r14.setText("d = {“john”:40, “peter”:45}");
                        r15.setText("d = {40:”john”, 45:”peter”}");
                        r16.setText("All of the mentioned");
                        r17.setText("True");
                        r18.setText("False");
                        r19.setText("Error");
                        r20.setText("None");
                        tv1.setText(question.get(0));
                        tv2.setText(question.get(1));
                        tv3.setText(question.get(2));
                        tv4.setText(question.get(3));
                        tv5.setText(question.get(4));

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
            if (strdata.equals("PYT3")) {
                coursenames="PYT3";
                tv.setText("Python Week 3");
                //DatabaseReference pyt;
                final DatabaseReference pyt,pyt2;
                final ArrayList<String> question = new ArrayList<>() ;

                pyt=mUserDatabase.child("Python").child("Week3");
                pyt.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {


                        // Result will be holded Here
                        for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                            question.add(dsp.getKey());//add result into array list
                        }
                        r1.setText("zero");
                        r2.setText("one");
                        r3.setText("more than one");
                        r4.setText("more than zero");
                        r5.setText("[‘A’,’B’,’C’].");
                        r6.setText("[‘B’,’C’,’A’].");
                        r7.setText("[5,7,9]");
                        r8.setText("[9,5,7]");
                        r9.setText("Dictionary comprehension doesn’t exist");
                        r10.setText("{0: 0, 1: 1, 2: 4, 3: 9, 4: 16, 5: 25, 6:36}");
                        r11.setText("{0: 0, 1: 1, 4: 4, 9: 9, 16: 16, 25: 25}");
                        r12.setText("{0: 0, 1: 1, 2: 4, 3: 9, 4: 16, 5: 25}");
                        r13.setText("8");
                        r14.setText("1");
                        r15.setText("2");
                        r16.setText("4");
                        r17.setText("8");
                        r18.setText("4");
                        r19.setText("2");
                        r20.setText("1");
                        tv1.setText(question.get(0));
                        tv2.setText(question.get(1));
                        tv3.setText(question.get(2));
                        tv4.setText(question.get(3));
                        tv5.setText(question.get(4));

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });


            }
            if (strdata.equals("AAD1")) {
                coursenames="AAD1";
                tv.setText("Android App Development Week 1");
                //DatabaseReference pyt;
                final DatabaseReference pyt,pyt2;
                final ArrayList<String> question = new ArrayList<>() ;

                pyt=mUserDatabase.child("Android App Development").child("Week1");
                pyt.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {


                        // Result will be holded Here
                        for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                            question.add(dsp.getKey());//add result into array list
                        }
                        r1.setText("onStop()");
                        r2.setText("onStart()");
                        r3.setText("onCreate()");
                        r4.setText("onRestore()");
                        r5.setText("findViewByReference(int id);");
                        r6.setText("findViewById(int id)");
                        r7.setText("retrieveResourceById(int id)");
                        r8.setText("findViewById(String id)");
                        r9.setText("Layout file");
                        r10.setText("Property file");
                        r11.setText("Java source file");
                        r12.setText("Manifest file");
                        r13.setText("Activate and Activity");
                        r14.setText("Activate a Service");
                        r15.setText("Activate a Broadcast receiver");
                        r16.setText("Activate a SQLite DB Connection.");
                        r17.setText("Service");
                        r18.setText("Activity");
                        r19.setText("Layout");
                        r20.setText("Content Provider");
                        tv1.setText(question.get(0));
                        tv2.setText(question.get(1));
                        tv3.setText(question.get(2));
                        tv4.setText(question.get(3));
                        tv5.setText(question.get(4));

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });


            }
            if (strdata.equals("AAD2")) {
                coursenames="AAD2";
                tv.setText("Android App Development Week 2");
                //DatabaseReference pyt;
                final DatabaseReference pyt,pyt2;
                final ArrayList<String> question = new ArrayList<>() ;

                pyt=mUserDatabase.child("Android App Development").child("Week2");
                pyt.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {


                        // Result will be holded Here
                        for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                            question.add(dsp.getKey());//add result into array list
                        }
                        r1.setText("JSON");
                        r2.setText("Peace of Activity");
                        r3.setText("Layout");
                        r4.setText("None of the above");
                        r5.setText("It is necessary to use ListView as a set with ListActivity.");
                        r6.setText("You cannot use a ListView when there is no information to be displayed.");
                        r7.setText("When displaying a list of Strings using an ArrayAdapter class save the value in an ArrayList");
                        r8.setText("ListView has a function to display a list of uniquely defined Views other than TextView.");
                        r9.setText("You cannot set a custom layout for a Toast.");
                        r10.setText("A Toast can only create by an Activity class");
                        r11.setText("There is no need to close or hide a Toast, since it closes automatically.");
                        r12.setText("A Toast is displayed for only one of the following periods short and long");
                        r13.setText("onPreExecute()");
                        r14.setText("onPostExecute()");
                        r15.setText("publishProgress()");
                        r16.setText("onProgressUpdate()");
                        r17.setText("Intent intent = new Intent(this,new Activity2()); startActivity(intent);startActivity(intent);");
                        r19.setText("Intent intent = new Intent (Activity1.class,Activity2.class); startActivity(intent);");
                        r20.setText("Intent intent = new Intent(this,Activity2.class);startActivity(intent);");
                        tv1.setText(question.get(0));
                        tv2.setText(question.get(1));
                        tv3.setText(question.get(2));
                        tv4.setText(question.get(3));
                        tv5.setText(question.get(4));

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }
            if (strdata.equals("AAD3")) {
                coursenames="AAD3";
                tv.setText("Android App Development Week 3");
                //DatabaseReference pyt;
                final DatabaseReference pyt,pyt2;
                final ArrayList<String> question = new ArrayList<>() ;

                pyt=mUserDatabase.child("Android App Development").child("Week1");
                pyt.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {


                        // Result will be holded Here
                        for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                            question.add(dsp.getKey());//add result into array list
                        }
                        r1.setText("onStop()");
                        r2.setText("onStart()");
                        r3.setText("onCreate()");
                        r4.setText("onRestore()");
                        r5.setText("findViewByReference(int id);");
                        r6.setText("findViewById(int id)");
                        r7.setText("retrieveResourceById(int id)");
                        r8.setText("findViewById(String id)");
                        r9.setText("Layout file");
                        r10.setText("Property file");
                        r11.setText("Java source file");
                        r12.setText("Manifest file");
                        r13.setText("Activate and Activity");
                        r14.setText("Activate a Service");
                        r15.setText("Activate a Broadcast receiver");
                        r16.setText("Activate a SQLite DB Connection.");
                        r17.setText("Service");
                        r18.setText("Activity");
                        r19.setText("Layout");
                        r20.setText("Content Provider");
                        tv1.setText(question.get(0));
                        tv2.setText(question.get(1));
                        tv3.setText(question.get(2));
                        tv4.setText(question.get(3));
                        tv5.setText(question.get(4));

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
            if (strdata.equals("CP1")) {
            }
            if (strdata.equals("CP2")) {
            }
            if (strdata.equals("CP3")) {
            }
            if (strdata.equals("JAV1")) {
            }
            if (strdata.equals("JAV2")) {
            }
            if (strdata.equals("JAV3")) {
            }
            if (strdata.equals("ECO1")) {
            }
            if (strdata.equals("ECO2")) {
            }
            if (strdata.equals("ECO3")) {
            }
            if (strdata.equals("ICD1")) {
            }
            if (strdata.equals("ICD2")) {
            }
            if (strdata.equals("ICD3")) {
            }
            if (strdata.equals("ICC1")) {
            }
            if (strdata.equals("ICC2")) {
            }
            if (strdata.equals("ICC3")) {
            }
            if (strdata.equals("J1")) {
            }
            if (strdata.equals("J2")) {
            }
            if (strdata.equals("J3")) {
            }
            if (strdata.equals("PHY1")) {
            }
            if (strdata.equals("PHY2")) {
            }
            if (strdata.equals("PHY3")) {
            }
        }

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (coursenames.equals("PYT1")){
                    id = rg1.getCheckedRadioButtonId();
                    id1= rg2.getCheckedRadioButtonId();
                    id2= rg3.getCheckedRadioButtonId();
                    id3= rg4.getCheckedRadioButtonId();
                    id4= rg5.getCheckedRadioButtonId();
                        if(id == r1.getId()){
                          points++;
                        }
                         if(id1 == r7.getId()){
                            points++;
                        }
                         if(id2 == r11.getId()){
                            points++;
                        }
                         if(id3 == r15.getId()){
                            points++;
                        }
                         if(id4 == r20.getId()){
                            points++;
                        }


                    final ArrayList<String> temp = new ArrayList<>() ;
                   // boolean checked = ((RadioButton) view).isChecked();
                    mUser.child(current_user_id).child("Courses").addListenerForSingleValueEvent(new ValueEventListener(){
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for (DataSnapshot ds : dataSnapshot.getChildren()) {
                                answer.add((String) ds.getValue());
                                temp.add(ds.getKey());
                             }
                            if(answer.contains("Introduction To Python")){
                                Map messageMap = new HashMap();
                                messageMap.put("Score", points);
                                mUser.child(current_user_id).child("Scores").child("Introduction To Python").child("Week1").updateChildren(messageMap, new DatabaseReference.CompletionListener() {
                                    @Override
                                    public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {

                                        if (databaseError != null) {

                                            Log.d("CHAT_LOG", databaseError.getMessage().toString());

                                        }
                                        else {
                                            new AlertDialog.Builder(Questions.this)
                                                    .setTitle("Score")
                                                    .setMessage("You scored "+points+" points")
                                                    .setCancelable(false)
                                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                        @Override
                                                        public void onClick(DialogInterface dialog, int which) {
                                                            // Whatever...
                                                            Intent intent=new Intent(Questions.this,MainActivity.class);
                                                            startActivity(intent);
                                                        }
                                                    }).show();
                                        }

                                    }
                                });

                            }


                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }

                    });

                    }
                if (coursenames.equals("PYT2")){
                    id = rg1.getCheckedRadioButtonId();
                    id1= rg2.getCheckedRadioButtonId();
                    id2= rg3.getCheckedRadioButtonId();
                    id3= rg4.getCheckedRadioButtonId();
                    id4= rg5.getCheckedRadioButtonId();
                    if(id == r1.getId()){
                        points++;
                    }
                    if(id1 == r5.getId()){
                        points++;
                    }
                    if(id2 == r9.getId()){
                        points++;
                    }
                    if(id3 == r16.getId()){
                        points++;
                    }
                    if(id4 == r19.getId()){
                        points++;
                    }


                    final ArrayList<String> temp = new ArrayList<>() ;
                    // boolean checked = ((RadioButton) view).isChecked();
                    mUser.child(current_user_id).child("Courses").addListenerForSingleValueEvent(new ValueEventListener(){
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for (DataSnapshot ds : dataSnapshot.getChildren()) {
                                answer.add((String) ds.getValue());
                                temp.add(ds.getKey());
                            }
                            if(answer.contains("Introduction To Python")){
                                Map messageMap = new HashMap();
                                messageMap.put("Score", points);
                                mUser.child(current_user_id).child("Scores").child("Introduction To Python").child("Week2").updateChildren(messageMap, new DatabaseReference.CompletionListener() {
                                    @Override
                                    public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {

                                        if (databaseError != null) {

                                            Log.d("CHAT_LOG", databaseError.getMessage().toString());

                                        }
                                        else {
                                            new AlertDialog.Builder(Questions.this)
                                                    .setTitle("Score")
                                                    .setMessage("You scored "+points+" points")
                                                    .setCancelable(false)
                                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                        @Override
                                                        public void onClick(DialogInterface dialog, int which) {
                                                            // Whatever...
                                                            Intent intent=new Intent(Questions.this,MainActivity.class);
                                                            startActivity(intent);
                                                        }
                                                    }).show();
                                        }

                                    }
                                });

                            }


                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }

                    });

                }
                if (coursenames.equals("PYT3")){
                    id = rg1.getCheckedRadioButtonId();
                    id1= rg2.getCheckedRadioButtonId();
                    id2= rg3.getCheckedRadioButtonId();
                    id3= rg4.getCheckedRadioButtonId();
                    id4= rg5.getCheckedRadioButtonId();
                    if(id == r4.getId()){
                        points++;
                    }
                    if(id1 == r5.getId()){
                        points++;
                    }
                    if(id2 == r12.getId()){
                        points++;
                    }
                    if(id3 == r16.getId()){
                        points++;
                    }
                    if(id4 == r17.getId()){
                        points++;
                    }


                    final ArrayList<String> temp = new ArrayList<>() ;
                    // boolean checked = ((RadioButton) view).isChecked();
                    mUser.child(current_user_id).child("Courses").addListenerForSingleValueEvent(new ValueEventListener(){
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for (DataSnapshot ds : dataSnapshot.getChildren()) {
                                answer.add((String) ds.getValue());
                                temp.add(ds.getKey());
                            }
                            if(answer.contains("Introduction To Python")){
                                Map messageMap = new HashMap();
                                messageMap.put("Score", points);
                                mUser.child(current_user_id).child("Scores").child("Introduction To Python").child("Week3").updateChildren(messageMap, new DatabaseReference.CompletionListener() {
                                    @Override
                                    public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {

                                        if (databaseError != null) {

                                            Log.d("CHAT_LOG", databaseError.getMessage().toString());

                                        }
                                        else {
                                            new AlertDialog.Builder(Questions.this)
                                                    .setTitle("Score")
                                                    .setMessage("You scored "+points+" points")
                                                    .setCancelable(false)
                                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                        @Override
                                                        public void onClick(DialogInterface dialog, int which) {
                                                            // Whatever...
                                                            Intent intent=new Intent(Questions.this,MainActivity.class);
                                                            startActivity(intent);
                                                        }
                                                    }).show();
                                        }

                                    }
                                });

                            }


                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }

                    });

                }
                if (coursenames.equals("AAD1")){
                    id = rg1.getCheckedRadioButtonId();
                    id1= rg2.getCheckedRadioButtonId();
                    id2= rg3.getCheckedRadioButtonId();
                    id3= rg4.getCheckedRadioButtonId();
                    id4= rg5.getCheckedRadioButtonId();
                    if(id == r3.getId()){
                        points++;
                    }
                    if(id1 == r6.getId()){
                        points++;
                    }
                    if(id2 == r12.getId()){
                        points++;
                    }
                    if(id3 == r16.getId()){
                        points++;
                    }
                    if(id4 == r19.getId()){
                        points++;
                    }


                    final ArrayList<String> temp = new ArrayList<>() ;
                    // boolean checked = ((RadioButton) view).isChecked();
                    mUser.child(current_user_id).child("Courses").addListenerForSingleValueEvent(new ValueEventListener(){
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for (DataSnapshot ds : dataSnapshot.getChildren()) {
                                answer.add((String) ds.getValue());
                                temp.add(ds.getKey());
                            }
                            if(answer.contains("Android App Development")){
                                Map messageMap = new HashMap();
                                messageMap.put("Score", points);
                                mUser.child(current_user_id).child("Scores").child("Android App Development").child("Week1").updateChildren(messageMap, new DatabaseReference.CompletionListener() {
                                    @Override
                                    public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {

                                        if (databaseError != null) {

                                            Log.d("CHAT_LOG", databaseError.getMessage().toString());

                                        }
                                        else {
                                            new AlertDialog.Builder(Questions.this)
                                                    .setTitle("Score")
                                                    .setMessage("You scored "+points+" points")
                                                    .setCancelable(false)
                                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                        @Override
                                                        public void onClick(DialogInterface dialog, int which) {
                                                            // Whatever...
                                                            Intent intent=new Intent(Questions.this,MainActivity.class);
                                                            startActivity(intent);
                                                        }
                                                    }).show();
                                        }

                                    }
                                });

                            }


                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }

                    });

                }
                if (coursenames.equals("AAD2")){
                    id = rg1.getCheckedRadioButtonId();
                    id1= rg2.getCheckedRadioButtonId();
                    id2= rg3.getCheckedRadioButtonId();
                    id3= rg4.getCheckedRadioButtonId();
                    id4= rg5.getCheckedRadioButtonId();
                    if(id == r2.getId()){
                        points++;
                    }
                    if(id1 == r8.getId()){
                        points++;
                    }
                    if(id2 == r10.getId()){
                        points++;
                    }
                    if(id3 == r15.getId()){
                        points++;
                    }
                    if(id4 == r20.getId()){
                        points++;
                    }


                    final ArrayList<String> temp = new ArrayList<>() ;
                    // boolean checked = ((RadioButton) view).isChecked();
                    mUser.child(current_user_id).child("Courses").addListenerForSingleValueEvent(new ValueEventListener(){
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for (DataSnapshot ds : dataSnapshot.getChildren()) {
                                answer.add((String) ds.getValue());
                                temp.add(ds.getKey());
                            }
                            if(answer.contains("Android App Development")){
                                Map messageMap = new HashMap();
                                messageMap.put("Score", points);
                                mUser.child(current_user_id).child("Scores").child("Android App Development").child("Week2").updateChildren(messageMap, new DatabaseReference.CompletionListener() {
                                    @Override
                                    public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {

                                        if (databaseError != null) {

                                            Log.d("CHAT_LOG", databaseError.getMessage().toString());

                                        }
                                        else {
                                            new AlertDialog.Builder(Questions.this)
                                                    .setTitle("Score")
                                                    .setMessage("You scored "+points+" points")
                                                    .setCancelable(false)
                                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                        @Override
                                                        public void onClick(DialogInterface dialog, int which) {
                                                            // Whatever...
                                                            Intent intent=new Intent(Questions.this,MainActivity.class);
                                                            startActivity(intent);
                                                        }
                                                    }).show();
                                        }

                                    }
                                });

                            }


                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }

                    });

                }
                if (coursenames.equals("AAD3")){
                    id = rg1.getCheckedRadioButtonId();
                    id1= rg2.getCheckedRadioButtonId();
                    id2= rg3.getCheckedRadioButtonId();
                    id3= rg4.getCheckedRadioButtonId();
                    id4= rg5.getCheckedRadioButtonId();
                    if(id == r2.getId()){
                        points++;
                    }
                    if(id1 == r8.getId()){
                        points++;
                    }
                    if(id2 == r10.getId()){
                        points++;
                    }
                    if(id3 == r15.getId()){
                        points++;
                    }
                    if(id4 == r20.getId()){
                        points++;
                    }


                    final ArrayList<String> temp = new ArrayList<>() ;
                    // boolean checked = ((RadioButton) view).isChecked();
                    mUser.child(current_user_id).child("Courses").addListenerForSingleValueEvent(new ValueEventListener(){
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for (DataSnapshot ds : dataSnapshot.getChildren()) {
                                answer.add((String) ds.getValue());
                                temp.add(ds.getKey());
                            }
                            if(answer.contains("Android App Development")){
                                Map messageMap = new HashMap();
                                messageMap.put("Score", points);
                                mUser.child(current_user_id).child("Scores").child("Android App Development").child("Week3").updateChildren(messageMap, new DatabaseReference.CompletionListener() {
                                    @Override
                                    public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {

                                        if (databaseError != null) {

                                            Log.d("CHAT_LOG", databaseError.getMessage().toString());

                                        }
                                        else {
                                            new AlertDialog.Builder(Questions.this)
                                                    .setTitle("Score")
                                                    .setMessage("You scored "+points+" points")
                                                    .setCancelable(false)
                                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                        @Override
                                                        public void onClick(DialogInterface dialog, int which) {
                                                            // Whatever...
                                                            Intent intent=new Intent(Questions.this,MainActivity.class);
                                                            startActivity(intent);
                                                        }
                                                    }).show();
                                        }

                                    }
                                });

                            }


                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }

                    });

                }

////
                }


        });
        }
    @Override
    public void onBackPressed()
    {
       points=0;
        super.onBackPressed();  // optional depending on your needs
    }

}
