package com.example.penangapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;

public class MainRental extends AppCompatActivity {

    ImageView imageView5;
    CardView rent, zzirent, wsrent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_rental);


        imageView5 = findViewById(R.id.imageView5);
        rent = findViewById(R.id.rent);
        zzirent = findViewById(R.id.zzirent);
        wsrent = findViewById(R.id.wsrent);

        imageView5.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainRental.this, MainActivity.class);

//                Pair[] pairs = new Pair[1];
//                pairs[0] = new Pair<View, String>(imageView, "background_image_transition");
//
//                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainRental.this, pairs);
//                startActivity(intent, options.toBundle());
                finish();
            }
        });

        rent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent secondActivity = new Intent(MainRental.this, inforental.class);
                startActivity(secondActivity);
            }
        });
        zzirent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent secondActivity = new Intent(MainRental.this, zzirental.class);
                startActivity(secondActivity);
            }
        });
        wsrent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent secondActivity = new Intent(MainRental.this, wsrental.class);
                startActivity(secondActivity);
            }
        });
    }
}