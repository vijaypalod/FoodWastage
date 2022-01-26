package com.yp.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class Register extends AppCompatActivity {

    TextInputLayout name,email,password,cPassword,mobile;
    Button registerBtn,loginBtn;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = (TextInputLayout) findViewById(R.id.name);
        email = (TextInputLayout) findViewById(R.id.email);
        password = (TextInputLayout) findViewById(R.id.password);
        cPassword = (TextInputLayout) findViewById(R.id.cPassword);
        mobile = (TextInputLayout) findViewById(R.id.mobile);
        registerBtn = (Button) findViewById(R.id.registerBtn);
        loginBtn = (Button) findViewById(R.id.loginBtn);
        DB = new DBHelper(this);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uName = name.getEditText().getText().toString();
                String uEmail = email.getEditText().getText().toString();
                String uPassword = password.getEditText().getText().toString();
                String uCPassword = cPassword.getEditText().getText().toString();
                String uMobile = mobile.getEditText().getText().toString();

                if(uName.equals("")||uEmail.equals("")||uPassword.equals("")||uCPassword.equals("")||uMobile.equals("")){
                    Toast.makeText(Register.this, "Please Enter all the Fields", Toast.LENGTH_SHORT).show();
                }else{
                    if(uPassword.equals(uCPassword)){
                        Boolean checkUser = DB.checkUserEmail(uEmail);
                        if(checkUser == false){
                            Boolean insert = DB.insertData(uName, uEmail, uPassword, uMobile);
                            if(insert == true){
                                Toast.makeText(Register.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Register.this,Login.class);
                                startActivity(intent);
                                finish();
                            }else {
                                Toast.makeText(Register.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(Register.this, "User Already Exists! Please Sign-in", Toast.LENGTH_SHORT).show();
                        }

                    }else {
                        Toast.makeText(Register.this, "Password Not Matching", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this,Login.class);
                startActivity(intent);
            }
        });
    }
}