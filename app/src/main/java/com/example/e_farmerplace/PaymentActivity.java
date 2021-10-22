package com.example.e_farmerplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.e_farmerplace.ApiHandler.Apihandler;
import com.example.e_farmerplace.Model.PaymentModel;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class PaymentActivity extends AppCompatActivity {

EditText name,mob;
Button pay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        name=(EditText)findViewById(R.id.name);
        mob=(EditText)findViewById(R.id.mob);
         pay=(Button)findViewById(R.id.pay);

         pay.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if (name.getText().toString().equals(""))
                 {
                     name.setError("Please Enter Your Name");
                 }
                else if (mob.getText().toString().equals(""))
                 {
                     mob.setError("Please Enter Your Mobile Number");
                 }
                 else
                 {
                     getUserAPI(name.getText().toString(),mob.getText().toString());
                     //String url = "https://www.paypal.com/in/home";
                     //Intent i = new Intent(Intent.ACTION_VIEW);
                     //i.setData(Uri.parse(url));
                     //startActivity(i);
                 }
             }
         });
    }

    private void getUserAPI(String name, String mob)
    {
        Apihandler.getApiService().pay(name,mob, new Callback<PaymentModel>() {
            @Override
            public void success(PaymentModel paymentModel, Response response)
            {
                Toast.makeText(PaymentActivity.this,"Done",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void failure(RetrofitError error)
            {
                Toast.makeText(PaymentActivity.this,"Fail",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
