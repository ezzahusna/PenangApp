package com.example.penangapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity {

    TextView fullname, email, phone;
    Button update, backpage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        fullname = findViewById(R.id.fullname);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        update = findViewById(R.id.update);
        backpage = findViewById(R.id.backpage);

        showAllUserData();

        backpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passUserData();
            }
        });
    }
    public void showAllUserData(){
        Intent intent = getIntent();
        String fullnameUser = intent.getStringExtra("fullname");
        String emailUser = intent.getStringExtra("email");
        String phoneUser = intent.getStringExtra("phone");
        fullname.setText(fullnameUser);
        email.setText(emailUser);
        phone.setText(phoneUser);

    }
    public void passUserData(){
        String userFullname = fullname.getText().toString().trim();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUserDatabase = reference.orderByChild("fullname").equalTo(userFullname);
        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    String fullnameFromDB = snapshot.child(userFullname).child("fullname").getValue(String.class);
                    String emailFromDB = snapshot.child(userFullname).child("email").getValue(String.class);
                    String phoneFromDB = snapshot.child(userFullname).child("phone").getValue(String.class);

                    Intent intent = new Intent(ProfileActivity.this, EditProfileActivity.class);

                    intent.putExtra("fullname", fullnameFromDB);
                    intent.putExtra("email", emailFromDB);
                    intent.putExtra("phone", phoneFromDB);
                    startActivity(intent);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
}
