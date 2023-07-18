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
import android.widget.ImageView;

public class mainticket extends AppCompatActivity {

    ImageView entopia, back_arrow, penanghill,escape,thetop,darkmansion,glass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainticket);

        entopia = findViewById(R.id.entopia);
        back_arrow = findViewById(R.id.back_arrow);
        penanghill = findViewById(R.id.penanghill);
        escape = findViewById(R.id.escape);
        thetop = findViewById(R.id.thetop);
        darkmansion = findViewById(R.id.darkmansion);
        glass = findViewById(R.id.glass);

        back_arrow.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mainticket.this, MainActivity.class);

//                Pair[] pairs = new Pair[1];
//                pairs[0] = new Pair<View, String>(back_arrow, "background_image_transition");
//
//                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(mainticket.this, pairs);
//                startActivity(intent, options.toBundle());

                finish();
            }
        });

        entopia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goLink("https://tickets.entopia.com/");
            }
        });
        penanghill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goLink("https://penanghill.gov.my/index.php/en/tickets");
            }
        });
        escape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goLink("https://www.ticket2u.com.my/escape");
            }
        });
        thetop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goLink("https://thetop.com.my/buy-tickets/");
            }
        });

        darkmansion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goLink("https://www.ticket2u.com.my/event/22024/penang-dark-mansion-3d-glow-in-the-dark-museum-ticket");
            }
        });

        glass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goLink("https://www.viator.com/en-MY/tours/George-Town/Glass-Museum-Penang-Admission-Ticket/d51052-38355P714");
            }
        });
    }
    private void goLink(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}