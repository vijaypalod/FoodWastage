package com.yp.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {

    TextInputLayout email, password;
    Button loginBtn;
    TextView regBtn, adminLogin;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = (TextInputLayout) findViewById(R.id.email1);
        password = (TextInputLayout) findViewById(R.id.password1);
        loginBtn = (Button) findViewById(R.id.loginBtn1);
        regBtn = (TextView) findViewById(R.id.registerBtn1);
        adminLogin = (TextView) findViewById(R.id.adminLogin);
        DB = new DBHelper(this);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uEmail = email.getEditText().getText().toString();
                String uPassword = password.getEditText().getText().toString();

                if (uEmail.equals("") || uPassword.equals("")) {
                    Toast.makeText(Login.this, "Please Enter All Fields", Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        Boolean checkEmailPass = DB.checkEmailPassword(uEmail, uPassword);
                        if (checkEmailPass) {
                            Toast.makeText(Login.this, "Sign-in Success", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Login.this, MainActivity.class);
                            intent.putExtra("msg_key", uEmail);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(Login.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception e) {
                        Toast.makeText(Login.this, "Table does not exist", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });
        adminLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, AdminLogin.class);
                startActivity(intent);
            }
        });
    }

}