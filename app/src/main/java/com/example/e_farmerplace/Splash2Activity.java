package com.example.e_farmerplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Splash2Activity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash2);
		
		
        Thread background =new Thread()
        {
            @Override
            public void run() {
                try
                {
                    sleep(3*1000);
                    Intent i=new Intent(Splash2Activity.this,Main_Home_Activity.class);
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

