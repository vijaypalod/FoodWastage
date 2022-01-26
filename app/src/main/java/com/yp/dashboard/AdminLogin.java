package com.yp.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class AdminLogin extends AppCompatActivity {

    TextInputLayout email,password;
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        email = (TextInputLayout) findViewById(R.id.adEmail);
        password = (TextInputLayout) findViewById(R.id.adPassword);
        loginBtn = (Button) findViewById(R.id.loginBtn2);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String aEmail = email.getEditText().getText().toString();
                String aPassword = password.getEditText().getText().toString();
                String AdminEmail = "admin@gmail.com";
                String AdminPassword = "admin";

                if(aEmail.equals("")||aPassword.equals("")){
                    Toast.makeText(AdminLogin.this, "Please Enter All Fields", Toast.LENGTH_SHORT).show();
                }else {
                    if(aEmail.equals(AdminEmail)||aPassword.equals(AdminPassword)){
                        Toast.makeText(AdminLogin.this, "Sign-in Success", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(AdminLogin.this,AdminButton.class);
                        startActivity(intent);
                        finish();
                    }else{
                        Toast.makeText(AdminLogin.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}