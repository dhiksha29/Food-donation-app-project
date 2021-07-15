package com.example.android.fud;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    Toolbar toolbar;
    NavigationView navigationView;
    ImageView btnRobot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TO hide the status bar (which contains charging ana all)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        // For Vibrations
        Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        navigationView = findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.drawer);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setElevation(0);
        toolbar.setTitle("");
        toolbar.setSubtitle("");
        setSupportActionBar(toolbar);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if(savedInstanceState==null){
            loadFragment(new DashBoardFragment());
        }

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                Fragment fragment = null;
                switch (id){
                    case R.id.home:
                        fragment = new DashBoardFragment();
                        loadFragment(fragment);
                        break;
                    case R.id.locateNGO:
                        fragment = new LocateNGOFragment();
                        loadFragment(fragment);
                        break;
                    case R.id.coupons:
                        fragment = new CouponsFragment();
                        loadFragment(fragment);
                        break;
                    case R.id.donations:
                        fragment = new YourDonationsFragment();
                        loadFragment(fragment);
                        break;
                    case R.id.aboutUs:
                        fragment = new AboutUsFragment();
                        loadFragment(fragment);
                        break;
                    case R.id.settings:
                        fragment = new UserSettingsFragment();
                        loadFragment(fragment);
                        break;
                    default:
                        return true;
                }
                return true;
            }
        });

        // Robot Work
        btnRobot = findViewById(R.id.robot_btn);
        btnRobot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibe.vibrate(80);
                Intent intent  = new Intent(MainActivity.this, NeedFoodActivity.class);
                startActivity(intent);
            }
        });
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction  = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment).commit();
        drawerLayout.closeDrawer(GravityCompat.START);
        fragmentTransaction.addToBackStack(null);
    }
}