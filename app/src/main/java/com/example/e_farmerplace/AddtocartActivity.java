package com.example.e_farmerplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.e_farmerplace.DTO.BuyProduct_DTO;
import com.example.e_farmerplace.DTO.Cart_DTO;

import java.util.ArrayList;

public class AddtocartActivity extends AppCompatActivity {
  ImageView image;
  Button cart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtocart);
        image=(ImageView)findViewById(R.id.image);




        cart=(Button)findViewById(R.id.cart);

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(AddtocartActivity.this,PaymentActivity.class);
                startActivity(i);
            }
        });









    }
}
