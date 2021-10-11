package com.example.e_farmerplace.Seller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.e_farmerplace.ApiHandler.Apihandler;
import com.example.e_farmerplace.Model.SrLoginModel;
import com.example.e_farmerplace.R;


import org.w3c.dom.Text;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class Seller_Login_Activity extends AppCompatActivity{
    private static final String TAG = "FirebaseEmailPassword";
    EditText sremail, srpassword;
    TextView ssignup;
    Button slogin;

    private TextView txtStatus;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller__login_);
        sremail = (EditText) findViewById(R.id.sremail);
        srpassword = (EditText) findViewById(R.id.srpassword);
        txtStatus = (TextView) findViewById(R.id.txtStatus);
        ssignup = (TextView) findViewById(R.id.ssignup);
        slogin = (Button) findViewById(R.id.slogin);
        ssignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Seller_Login_Activity.this,Seller_Registration.class);
                startActivity(i);
            }
        });

        slogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(sremail.getText().toString().equals(""))
                {
                    sremail.setError("Please Enter Your Email");
                }
                else if(srpassword.getText().toString().equals(""))
                {
                    srpassword.setError("Please Enter Your PAssword");
                }
                else
                {
                    getApiService(sremail.getText().toString(),srpassword.getText().toString());
                    Intent i=new Intent(Seller_Login_Activity.this,Seller_Activity_final.class);
                    startActivity(i);
                }
            }
        });

    }

    private void getApiService(String sremail, String srpassword)
    {
        Apihandler.getApiService().srlogin(sremail, srpassword, new Callback<SrLoginModel>() {
            @Override
            public void success(SrLoginModel srLoginModel, Response response)
            {
                Toast.makeText(Seller_Login_Activity.this,"Done",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(Seller_Login_Activity.this, "Fail", Toast.LENGTH_SHORT).show();
            }
        });


    }



}


