package com.example.trial;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener,
        emergencyFragment.OnFragmentInteractionListener,
        getHelp.OnFragmentInteractionListener,
        editProfile.OnFragmentInteractionListener,
        ReportCrimes.OnFragmentInteractionListener,
        logOut.OnFragmentInteractionListener
{

    private AppBarConfiguration mAppBarConfiguration;
    DrawerLayout drawer ;
    NavigationView navigationView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
         navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_emergency, R.id.nav_getHelp, R.id.nav_reportCrime,
                R.id.nav_editProfile, R.id.nav_logOut)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId())
        {
            case R.id.login:
                // call login activity
            case R.id.contacts:

        }
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id= menuItem.getItemId();
        if(id==R.id.nav_emergency)
        {
            FragmentTransaction ft= getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flMain,new emergencyFragment());
            ft.commit();
        }
        else if(id==R.id.nav_getHelp)
        {

            FragmentTransaction ft= getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flMain,new getHelp());
            ft.commit();
                   }
        else if(id==R.id.nav_reportCrime)
        {

            FragmentTransaction ft= getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flMain,new ReportCrimes());
            ft.commit();
        }
        else if(id==R.id.nav_editProfile)
        {

            FragmentTransaction ft= getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flMain,new editProfile());
           ft.commit();
        }
        else if(id==R.id.nav_logOut)
        {
                            FragmentTransaction ft= getSupportFragmentManager().beginTransaction();
                            ft.replace(R.id.flMain,new logOut());
                            ft.commit();
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void helpFn(View view)
    {
        Intent intent =  new Intent(getApplicationContext(), MapsActivity.class);
        startActivity(intent);
    }

    public void onFragmentInteraction(Uri uri)
    {

    }

}
