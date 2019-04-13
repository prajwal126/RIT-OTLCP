package com.example.prajw.ritcourse;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.prajw.ritcourse.Fragments.AeroFrag;
import com.example.prajw.ritcourse.Fragments.CSFragment;
import com.example.prajw.ritcourse.Fragments.EconoFrag;
import com.example.prajw.ritcourse.Fragments.ElectricalFrag;
import com.example.prajw.ritcourse.Fragments.MEfrag;
import com.example.prajw.ritcourse.Fragments.PhyFrag;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG ="SAMPLE" ;
    TextView name, email;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser mFirebaseUser;
    ImageView profile;
    String personName,personEmail,personPhotoUrl,pname,pemail,pdp;
    GoogleApiClient mGoogleApiClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        verificaUsuarioLogado();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,ContactUs.class);
                startActivity(intent);
            }
        });
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        pname=pref.getString("name", null);
        pemail=pref.getString("email", null);
        pdp=pref.getString("dp", null);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View header=navigationView.getHeaderView(0);
        name = (TextView)header.findViewById(R.id.name);
        email = (TextView)header.findViewById(R.id.emailid);
        profile=(ImageView)header.findViewById(R.id.profpic);
        name.setText(pname);
        email.setText(pemail);
        Glide.with(this).load( pdp).into( profile);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();


        }



/*View view=navigationView.inflateHeaderView(R.layout.nav_header_main);*/

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    @Override

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_profile) {
            Intent myIntent = new Intent(MainActivity.this, Profile.class);
            MainActivity.this.startActivity(myIntent);
            return true;
        }
        if (id == R.id.action_logout) {
            new AlertDialog.Builder(MainActivity.this)
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
        if (id == R.id.action_cert) {
            certificate();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void certificate() {
        Intent i=new Intent(getApplicationContext(),certificate.class);
        startActivity(i);
    }

    private void verificaUsuarioLogado(){
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();
        if (mFirebaseUser == null){
            startActivity(new Intent(this, Home.class));
            finish();
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
                        Intent intent=new Intent(MainActivity.this,Home.class);
                        startActivity(intent);

                    }
    });
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Fragment fragment=null;
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_cs) {
         fragment = new CSFragment();


        } else if (id == R.id.nav_me) {
            fragment = new MEfrag();

        } else if (id == R.id.nav_phy) {
            fragment = new PhyFrag();

        } else if (id == R.id.nav_es) {
            fragment = new EconoFrag();

        }
        else if (id == R.id.nav_5) {
            fragment = new ElectricalFrag();

        }
        else if (id == R.id.nav_6) {
            fragment = new AeroFrag();

        }
        if (fragment != null) {
            //FragmentManager fragmentManager=getSupportFragmentManager();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.screen_area, fragment);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
