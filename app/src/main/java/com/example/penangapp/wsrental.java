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
import android.widget.Button;
import android.widget.ImageView;

public class wsrental extends AppCompatActivity {

    ImageView imageView;
    Button car;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wsrental);

        car = findViewById(R.id.roadmap_button);
        imageView = findViewById(R.id.back_arrow);

        imageView.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(wsrental.this, MainRental.class);

//                Pair[] pairs = new Pair[1];
//                pairs[0] = new Pair<View, String>(imageView, "background_image_transition");
//
//                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(inforental.this, pairs);
//                startActivity(intent, options.toBundle());
                finish();
            }
        });

        car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goLink("https://gowstours.blogspot.com/");
            }
        });
    }
    private void goLink(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}