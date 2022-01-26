package com.yp.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminButton extends AppCompatActivity {

    Button users,donationReq,logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_button);

        users = (Button) findViewById(R.id.userDetails);
        donationReq = (Button) findViewById(R.id.donateDetails);
        logout = (Button) findViewById(R.id.logout);

        users.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminButton.this,AdminHome.class);
                startActivity(intent);
            }
        });

        donationReq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminButton.this,DonateDetails.class);
                startActivity(intent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminButton.this,AdminLogin.class);
                startActivity(intent);
                finish();
            }
        });

    }
}