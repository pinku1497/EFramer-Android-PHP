package com.example.e_farmerplace.Seller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.e_farmerplace.ApiHandler.Apihandler;
import com.example.e_farmerplace.LoginActivity;
import com.example.e_farmerplace.Model.SrRegistrationModel;
import com.example.e_farmerplace.R;
import com.example.e_farmerplace.RegistrationActivity;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class Seller_Registration extends AppCompatActivity {

    EditText srname,sremail,srpass,srcpass;
    Button srsignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller__registration);

        srname=(EditText)findViewById(R.id.srname);
        sremail=(EditText)findViewById(R.id.sremail);
        srpass=(EditText)findViewById(R.id.srpass);
        srcpass=(EditText)findViewById(R.id.srcpass);

        srsignup=(Button)findViewById(R.id.srsignup);

        srsignup.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (srname.getText().toString().equals(""))
                {
                    srname.setError("Please Enter Your Password");
                }
                else if (sremail.getText().toString().equals(""))
                {
                    sremail.setError("Please Enter Your Email");
                }
                else if (srpass.getText().toString().equals(""))
                {
                    srpass.setError("Please Enter Your Password");
                }
                else if (srcpass.getText().toString().equals(""))
                {
                    srcpass.setError("Please Enter Your Password");
                }

                else
                {
                    getApiService(srname.getText().toString(),sremail.getText().toString(),srpass.getText().toString(),srcpass.getText().toString());
                    Intent i = new Intent(Seller_Registration.this, Seller_Login_Activity.class);
                    startActivity(i);
                }
            }
        });



    }

    private void getApiService(String srname, String sremail, String srpass, String srcpass)
    {
        Apihandler.getApiService().srregistraion(srname, sremail, srpass, srcpass, new Callback<SrRegistrationModel>()
        {
            @Override
            public void success(SrRegistrationModel srRegistrationModel, Response response)
            {
                Toast.makeText(Seller_Registration.this,"Done",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void failure(RetrofitError error)
            {
                Toast.makeText(Seller_Registration.this,"Fail",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
