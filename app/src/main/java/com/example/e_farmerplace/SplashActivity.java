package com.example.e_farmerplace;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread background =new Thread()
        {
            @Override
            public void run() {
                try{

                    sleep(3*1000);
                    Intent i=new Intent(SplashActivity.this,Splash2Activity.class);
                    startActivity(i);
                    finish();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        };
        background.start();
    }
}
