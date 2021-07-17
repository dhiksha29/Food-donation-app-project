package com.example.donatepage;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void NgoAgent(View v){
        Intent ngoIntent = new Intent(MainActivity.this, NgoAgent.class);
        startActivity(ngoIntent);
    }

    public void NeedFood(View v){
        Intent needFoodIntent = new Intent(MainActivity.this, NeedFood.class);
        startActivity(needFoodIntent);
    }

    public void NgoPage(View v){
        Intent ngoInfoIntent = new Intent(MainActivity.this, NgoPage.class);
        startActivity(ngoInfoIntent);
    }

    public void DonatePage(View v){
        Intent donatePageIntent = new Intent(MainActivity.this, DonatePage.class);
        startActivity(donatePageIntent);
    }
}