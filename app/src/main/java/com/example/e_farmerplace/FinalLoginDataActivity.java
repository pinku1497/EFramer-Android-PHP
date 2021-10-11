package com.example.e_farmerplace;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.e_farmerplace.ApiHandler.Apihandler;
import com.example.e_farmerplace.Model.FrRegistrationModel;
import com.example.e_farmerplace.Model.LoginModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class FinalLoginDataActivity extends AppCompatActivity {
    EditText  femail, fpassword;
    Button sumbit;
    TextView login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_login_data);


        femail = (EditText) findViewById(R.id.email);
        fpassword = (EditText) findViewById(R.id.password);

        login = (TextView) findViewById(R.id.login);

        sumbit=(Button)findViewById(R.id.submit);
        sumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (femail.getText().toString().equals(""))
                {
                    femail.setError("Please Enter Your Email");
                }
                else if (fpassword.getText().toString().equals(""))
                {
                    fpassword.setError("Please Enter Your Password");
                }
                else
                {
                    getApiServices(femail.getText().toString(),fpassword.getText().toString());
                    Intent i=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(i);
                }
            }
        });
    }

    private void getApiServices(String femail, String fpassword)
    {
        Apihandler.getApiService().per(femail, fpassword, new Callback<LoginModel>()
        {
            @Override
            public void success(LoginModel loginModel, Response response)
            {
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
