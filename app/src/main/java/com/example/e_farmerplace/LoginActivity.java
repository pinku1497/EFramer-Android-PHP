package com.example.e_farmerplace;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.e_farmerplace.ApiHandler.Apihandler;
import com.example.e_farmerplace.Model.LoginModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class LoginActivity extends AppCompatActivity {
    EditText email;
    EditText password;
    TextView signup, txtstatus;
    Button login;

    //private FirebaseAuth mAuth;

    private static final String TAG = "FirebaseEmailPassword";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        signup = (TextView) findViewById(R.id.signup);
        txtstatus = (TextView) findViewById(R.id.txtStatus);
        login = (Button) findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email.getText().toString().equals(""))
                {
                    email.setError("Please Enter Your Email");
                }
                else if (password.getText().toString().equals(""))
                {
                    password.setError("Please Enter Your Password");
                }
               else
                {
                    getApiServices(email.getText().toString(),password.getText().toString());
                    Intent i=new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(i);
                }
            }
        });
        signup.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),RegistrationActivity.class);
                startActivity(i);
            }
        });
    }
    private void getApiServices(String email, String password)
    {
        Apihandler.getApiService().per(email, password, new Callback<LoginModel>() {
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






