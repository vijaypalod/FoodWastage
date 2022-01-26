package com.yp.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class Splash extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        imageView = findViewById(R.id.imageView);

        imageView.animate()
            .alpha(1f)
            .scaleX(1f)
            .scaleY(1f)
            .rotation(360)
            .setDuration(2000);

        Thread thread = new Thread(
            new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(3000);
                        startActivity(new Intent(Splash.this, Login.class));
                        finish();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        );
        thread.start();
    }
}