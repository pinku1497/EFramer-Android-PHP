package com.example.e_farmerplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.e_farmerplace.ApiHandler.Apihandler;
import com.example.e_farmerplace.Model.FrRegistrationModel;
import com.example.e_farmerplace.Seller.Seller_Registration;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.mime.TypedByteArray;

public class RegistrationActivity extends AppCompatActivity {
    EditText fname,faddress, femail, fpassword, fcpassword;
    Button sumbit;
    TextView account, login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        fname = (EditText) findViewById(R.id.fname);
        femail = (EditText) findViewById(R.id.femail);
        faddress = (EditText) findViewById(R.id.faddress);
        fpassword = (EditText) findViewById(R.id.fpassword);
        fcpassword = (EditText) findViewById(R.id.fcpassword);
        login = (TextView) findViewById(R.id.login);

        sumbit = (Button) findViewById(R.id.submit);
        sumbit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                {
                    if (fname.getText().toString().equals(""))
                    {
                        fname.setError("Please Enter Your Password");
                    }
                    else if (femail.getText().toString().equals(""))
                    {
                        femail.setError("Please Enter Your Email");
                    }
                    else if (fpassword.getText().toString().equals(""))
                    {
                        fpassword.setError("Please Enter Your Password");
                    }
                    else if (fcpassword.getText().toString().equals(""))
                    {
                        fcpassword.setError("Enter Confirm Password");
                    }

                    else
                    {
                        getApiService(fname.getText().toString(),femail.getText().toString(),fpassword.getText().toString(),fcpassword.getText().toString());
                        Intent i = new Intent(RegistrationActivity.this, LoginActivity.class);
                        startActivity(i);
                    }


                }
            }
        });
    }

    private void getApiService(String fname, String femail, String fpassword, String fcpassword)
    {
        Apihandler.getApiService().registraion(fname, femail, fpassword, fcpassword, new Callback<FrRegistrationModel>() {
            @Override
            public void success(FrRegistrationModel frRegistrationModel, Response response) {
                Toast.makeText(getApplicationContext(),"Done",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void failure(RetrofitError error)
            {
                Toast.makeText(getApplicationContext(),"Fail",Toast.LENGTH_SHORT).show();
            }
        });
    }
}

