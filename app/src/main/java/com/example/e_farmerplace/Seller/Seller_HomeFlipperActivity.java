package com.example.e_farmerplace.Seller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.example.e_farmerplace.R;

public class Seller_HomeFlipperActivity extends AppCompatActivity {

    ViewFlipper v_flipper;
    Button productbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller__home_flipper);
        int images[] ={R.drawable.splash2,R.drawable.fertilizer,R.drawable.fermer,R.drawable.fert2};

        v_flipper=(ViewFlipper)findViewById(R.id.v_flipper);

        productbtn=(Button)findViewById(R.id.productbtn);

        productbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        for(int i=0;i<images.length;i++)
        {
            flipperImages(images[i]);
        }
    }


    public void flipperImages(int image)
    {
        ImageView imageView=new ImageView(Seller_HomeFlipperActivity.this);
        imageView.setBackgroundResource(image);
        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(1000); //1 sec
        v_flipper.setAutoStart(true);
        //  v_flipper.showNext();

        //Animation
        v_flipper.setInAnimation(Seller_HomeFlipperActivity.this,android.R.anim.slide_in_left);
        //  v_flipper.setOutAnimation(Demo_Home.this,android.R.anim.slide_out_right);

    }

}
