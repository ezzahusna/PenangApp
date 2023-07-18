package com.example.penangapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.TargetApi;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Mainhotel extends AppCompatActivity {

    ImageView imageView5;
    CardView cardView, cardView2, cardView3, cardView4, cardView5, cardView6, cardView7, cardView8, cardView9, cardView10;
    TextView hardrocktxt, angsanatxt, lexistxt, shangrilatxt, seventxt, ghoteltxt, malihomtxt, edisontxt, losttxt;

    Animation anim_from_button, anim_from_top, anim_from_left;

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainhotel);

        imageView5 = findViewById(R.id.imageView5);
        cardView = findViewById(R.id.cardView);
        cardView2 = findViewById(R.id.cardView2);
        cardView3 = findViewById(R.id.cardView3);
        cardView4 = findViewById(R.id.cardView4);
        cardView5 = findViewById(R.id.cardView5);
        cardView6 = findViewById(R.id.cardView6);
        cardView7 = findViewById(R.id.cardView7);
        cardView8 = findViewById(R.id.cardView8);
        cardView9 = findViewById(R.id.cardView9);
        cardView10 = findViewById(R.id.cardView10);

        hardrocktxt = findViewById(R.id.hardrock);
        angsanatxt = findViewById(R.id.angsana);
        lexistxt = findViewById(R.id.lexis);
        shangrilatxt = findViewById(R.id.shangrila);
        seventxt = findViewById(R.id.seven);
        ghoteltxt = findViewById(R.id.ghotel);
        malihomtxt = findViewById(R.id.malihom);
        edisontxt = findViewById(R.id.edison);
        losttxt = findViewById(R.id.lost);

        anim_from_button = AnimationUtils.loadAnimation(this, R.anim.anim_from_bottom);
        anim_from_top = AnimationUtils.loadAnimation(this, R.anim.anim_from_top);
        anim_from_left = AnimationUtils.loadAnimation(this, R.anim.anim_from_left);

        cardView.setAnimation(anim_from_button);
        cardView2.setAnimation(anim_from_button);
        cardView3.setAnimation(anim_from_button);
        cardView4.setAnimation(anim_from_button);
        cardView5.setAnimation(anim_from_button);
        cardView6.setAnimation(anim_from_button);
        cardView7.setAnimation(anim_from_button);
        cardView8.setAnimation(anim_from_button);
        cardView9.setAnimation(anim_from_button);
        cardView10.setAnimation(anim_from_button);

        hardrocktxt.setAnimation(anim_from_top);
        angsanatxt.setAnimation(anim_from_top);
        lexistxt.setAnimation(anim_from_top);
        shangrilatxt.setAnimation(anim_from_top);
        seventxt.setAnimation(anim_from_top);
        ghoteltxt.setAnimation(anim_from_top);
        malihomtxt.setAnimation(anim_from_top);
        edisontxt.setAnimation(anim_from_top);
        losttxt.setAnimation(anim_from_top);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent secondActivity = new Intent(Mainhotel.this, detailpager.class);
                startActivity(secondActivity);
            }
        });
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent secondActivity = new Intent(Mainhotel.this, angsanapager.class);
                startActivity(secondActivity);
            }
        });


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

        imageView5.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(Mainhotel.this, MainActivity.class);
//
//
//
//                Pair[] pairs = new Pair[1];
//                pairs[0] = new Pair<View, String>(imageView, "background_image_transition");
//
//                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Mainhotel.this, pairs);
//                startActivity(intent, options.toBundle());

                finish();

            }
        });


    }
}