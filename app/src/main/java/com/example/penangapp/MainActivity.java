package com.example.penangapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;


import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    CardView cardhotel, cardView9, cardView4,cardView8;
    ImageView hotelimage, vehicleimage, entopia, escape, darkmansion, penanghill, thetop, streetart;
    TextView phone,full,email;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar); //Ignore red line errors
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav,
                R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }


        setContentView(R.layout.activity_main);
        streetart = findViewById(R.id.streetart);
        escape = findViewById(R.id.escape);
        thetop = findViewById(R.id.thetop);
        entopia = findViewById(R.id.entopia);
        penanghill = findViewById(R.id.penanghill);
        darkmansion = findViewById(R.id.darkmansion);
      phone = findViewById(R.id.phone);
        full = findViewById(R.id.fullname);
        email = findViewById(R.id.email);
        cardhotel = findViewById(R.id.cardhotel);
      hotelimage = findViewById(R.id.hotelimage);
      cardView9 = findViewById(R.id.cardView9);
      cardView4 = findViewById(R.id.cardView4);
      cardView8 = findViewById(R.id.cardView8);
      vehicleimage = findViewById(R.id.vehicleimage);

        showAllUserData();

      cardhotel.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent = new Intent(MainActivity.this,Mainhotel.class);
              startActivity(intent);
          }
      });



      hotelimage.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent = new Intent (MainActivity.this, Mainhotel.class);
              startActivity(intent);
          }
      });

        cardView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MainRental.class);
                startActivity(intent);
            }
        });

        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,mainticket.class);
                startActivity(intent);
            }
        });

        vehicleimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MainRental.class);
                startActivity(intent);
            }
        });

        cardView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MapsActivity.class);
                startActivity(intent);
            }
        });
        entopia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goLink("https://www.entopia.com/");
            }
        });
        escape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goLink("https://www.escape.my/");
            }
        });

        darkmansion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goLink("https://www.facebook.com/darkmansionpenang/");
            }
        });

        penanghill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goLink("https://penanghill.gov.my/index.php/en/");
            }
        });

        thetop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goLink("https://thetop.com.my/");
            }
        });

        streetart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goLink("https://streetartpenang.com/");
            }
        });
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.nav_about:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AboutFragment()).commit();
                break;
            case R.id.nav_logout:
                Toast.makeText(this, "Logout!", Toast.LENGTH_SHORT).show();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.nav_menu, menu);

        return true;
    }

    public void showAllUserData(){
        Intent intent = getIntent();
        String phoneUser = intent.getStringExtra("phone");
        String fullnameUser = intent.getStringExtra("fullname");
        String emailUser = intent.getStringExtra("email");


        phone.setText(phoneUser);
        full.setText(fullnameUser);
        email.setText(emailUser);




    }
    private void goLink(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}