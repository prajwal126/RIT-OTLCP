package com.example.prajw.ritcourse;

import android.app.DatePickerDialog;
import android.content.SharedPreferences;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

@RequiresApi(api = Build.VERSION_CODES.N)
public class Profile extends AppCompatActivity {
private String pname,pemail,pdp,date2;
private TextView name,email;
private ImageView profile;
private RadioGroup radioGroup;
private NumberPicker numberPicker;
private RadioButton selectedRadioButton ;
private Button set;private int radiox; private FirebaseAuth mAuth;
private EditText edittext;
private ListView mCourseList;
    private DatabaseReference mUserDatabase;
private ArrayList<String> mCoursename=new ArrayList<>();
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radioButton3:
                if (checked)
                    radiox = 1;
                break;
            case R.id.radioButton4:
                if (checked)
                    radiox = 2;
                break;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        radioGroup = (RadioGroup) findViewById(R.id.rg);
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        pname=pref.getString("name", null);
        pemail=pref.getString("email", null);
        pdp=pref.getString("dp", null);
        name = (TextView)findViewById(R.id.textView22);
        email = (TextView)findViewById(R.id.textView23);
        edittext= (EditText) findViewById(R.id.Birthday);
        mCourseList=(ListView)findViewById(R.id.listView);
        profile=(ImageView)findViewById(R.id.imageView8);
        mAuth = FirebaseAuth.getInstance();
        String current_user_id = mAuth.getCurrentUser().getUid();
        mUserDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child(current_user_id).child("Courses");
        set=(Button)findViewById(R.id.button3);
        name.setText(pname);
        email.setText(pemail);
        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setvalue();
                new AlertDialog.Builder(Profile.this)
                        .setTitle("RIT OTLCP")
                        .setMessage("Saved Details")
                        .setCancelable(true)
                        .show();
            }
        });
        Glide.with(this).load( pdp).into( profile);

        edittext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(Profile.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


        final ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mCoursename);
        mCourseList.setAdapter(arrayAdapter);
        mUserDatabase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String value=dataSnapshot.getValue().toString();
                mCoursename.add(value);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        setvalue();
    }

    Calendar myCalendar = Calendar.getInstance();


    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }

    };

    private void updateLabel() {
        String myFormat = "dd/MM/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat);
        edittext.setText(sdf.format(myCalendar));
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("date", sdf.format(myCalendar));
        editor.commit();
    }

    private void setvalue()
    {
       if(radiox==1){
           radioGroup.check(R.id.radioButton3);
       }
       else {
           radioGroup.check(R.id.radioButton4);
      }
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        date2=pref.getString("date", null);
        edittext.setText(date2);

    }

}
