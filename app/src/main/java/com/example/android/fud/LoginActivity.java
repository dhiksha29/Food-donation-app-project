package com.example.android.fud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.fud.LoginAdapter;
import com.example.android.fud.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class LoginActivity extends AppCompatActivity {

    FloatingActionButton fb, google, github;
    float v =0;
    Button loginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // TO hide the status bar (which contains charging ana all)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        fb = findViewById(R.id.fab_facebook);
        google = findViewById(R.id.fab_google);
        github = findViewById(R.id.fab_github);
        tabLayout.setupWithViewPager(viewPager);

        // Creating Adapter Class to switch between Fragments
        //Done

        LoginAdapter adapter = new LoginAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        // Now setting Animations to the buttons and edittext
        fb.setTranslationY(300);
        google.setTranslationY(300);
        github.setTranslationY(300);
        tabLayout.setTranslationY(300);

        fb.setAlpha(v);
        google.setAlpha(v);
        github.setAlpha(v);
        tabLayout.setAlpha(v);

        fb.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
        google.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(600).start();
        github.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(100).start();


        // Now doing same in Login and SignUp Fragment


        // Moving to next Activity
        google = findViewById(R.id.fab_google);
        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}