package com.example.e_farmerplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.e_farmerplace.Utility.AppPreference;

import java.math.BigDecimal;

public class Farmer_BuyProductActivity extends AppCompatActivity
{


    Button cart_buy;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_product);
        cart_buy=(Button)findViewById(R.id.cart_buy);

        cart_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(Farmer_BuyProductActivity.this,PaymentActivity.class);
                startActivity(i);
            }
        });


    }
}
