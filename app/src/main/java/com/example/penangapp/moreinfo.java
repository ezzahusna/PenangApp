package com.example.penangapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;

public class moreinfo extends AppCompatActivity {

    ImageView down_arrow;

    ScrollView third_scrollview;

    Animation from_bottom;

    Button hotel;


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moreinfo);

        hotel = findViewById(R.id.roadmap_button);
        down_arrow = findViewById(R.id.down_arrow);
        third_scrollview = findViewById(R.id.third_scrillview);

        from_bottom = AnimationUtils.loadAnimation(this, R.anim.anim_from_bottom);

        down_arrow.setAnimation(from_bottom);
        third_scrollview.setAnimation(from_bottom);



        //Hide status bar and navigation bar at the bottom
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );

        this.getWindow().getDecorView().setSystemUiVisibility(

                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        );

        hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goLink("https://www.hardrockhotels.com/penang/");
            }
        });


        down_arrow.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(moreinfo.this, detailpager.class);

//                Pair[] pairs = new Pair[1];
//                pairs[0] = new Pair<View, String>(down_arrow, "background_image_transition");
//
//                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(moreinfo.this, pairs);
//                startActivity(intent, options.toBundle());
                finish();
            }
        });




    }

    private void goLink(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}