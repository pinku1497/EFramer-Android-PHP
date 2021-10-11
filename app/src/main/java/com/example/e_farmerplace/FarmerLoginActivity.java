package com.example.e_farmerplace;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
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

public class FarmerLoginActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "FirebaseEmailPassword";

    private TextView txtStatus;

    private EditText edtEmail;
    private EditText edtPassword;

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_login);
        txtStatus = (TextView) findViewById(R.id.status);

        edtEmail = (EditText) findViewById(R.id.email);
        edtPassword = (EditText) findViewById(R.id.password);

        findViewById(R.id.btn_email_sign_in).setOnClickListener(this);
        findViewById(R.id.btn_email_create_account).setOnClickListener(this);
        findViewById(R.id.btn_sign_out).setOnClickListener(this);
        findViewById(R.id.btn_verify_email).setOnClickListener(this);

        findViewById(R.id.btn_forgot_password).setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();
    }
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    public void onClick(View view)
    {
        int i = view.getId();

        if (i == R.id.btn_email_create_account) {
            createAccount(edtEmail.getText().toString(), edtPassword.getText().toString());
        } else if (i == R.id.btn_email_sign_in) {
            signIn(edtEmail.getText().toString(), edtPassword.getText().toString());
        } else if (i == R.id.btn_sign_out) {
            signOut();
        } else if (i == R.id.btn_verify_email) {
            sendEmailVerification();
        } else if (i == R.id.btn_forgot_password)
        {
           // startActivity(new Intent(FarmerLoginActivity.this, ResetPasswordActivity.class));
        }
    }

    private void createAccount(String edtEmail, String edtPassword)
    {
        Apihandler.getApiService().per(edtEmail, edtPassword, new Callback<LoginModel>() {
            @Override
            public void success(LoginModel loginModel, Response response)
            {

                Log.e(TAG, "createAccount: Success!");
            }

            @Override
            public void failure(RetrofitError error)
            {

            }
        });
        Log.e(TAG, "createAccount:" + edtEmail);
        if (!validateForm(edtEmail, edtPassword)) {
            return;
        }

        mAuth.createUserWithEmailAndPassword(edtEmail, edtPassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {
                            Log.e(TAG, "createAccount: Success!");

                            // update UI with the signed-in user's information
                            FirebaseUser currentUser = mAuth.getCurrentUser();
                            updateUI(currentUser);
                        }
                        else
                            {
                            Log.e(TAG, "createAccount: Fail!", task.getException());

                            Toast.makeText(getApplicationContext(), "Authentication failed!", Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
    }

    private void signIn(final String edtEmail, String edtPassword) {
        Log.e(TAG, "signIn:" + edtEmail);
        if (!validateForm(edtEmail, edtPassword)) {
            return;
        }

        mAuth.signInWithEmailAndPassword(edtEmail, edtPassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {

                            Log.e(TAG, "signIn: Success!");

                            // update UI with the signed-in user's information
                            FirebaseUser currentUser = mAuth.getCurrentUser();
                            updateUI(currentUser);
                        }
                        else
                            {
                            Log.e(TAG, "signIn: Fail!", task.getException());
                            Toast.makeText(getApplicationContext(), "Authentication failed!", Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                        if (!task.isSuccessful())
                        {
                            txtStatus.setText("Authentication failed!");
                        }
                    }
                });
    }

    private void signOut() {
        mAuth.signOut();
        updateUI(null);
    }

    private void sendEmailVerification() {
        // Disable Verify Email button
        findViewById(R.id.btn_verify_email).setEnabled(false);

        final FirebaseUser currentUser = mAuth.getCurrentUser();
        currentUser.sendEmailVerification()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        // Re-enable Verify Email button
                        findViewById(R.id.btn_verify_email).setEnabled(true);

                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Verification email sent to " + currentUser.getEmail(), Toast.LENGTH_SHORT).show();
                        } else {
                            Log.e(TAG, "sendEmailVerification failed!", task.getException());
                            Toast.makeText(getApplicationContext(), "Failed to send verification email.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private boolean validateForm(String edtEmail, String edtPassword) {

        if (TextUtils.isEmpty(edtEmail))
        {
            Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (TextUtils.isEmpty(edtPassword))
        {
            Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (edtPassword.length() < 6)
        {
            Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private void updateUI(FirebaseUser currentUser) {
        if (currentUser != null) {
            txtStatus.setText("User Email: " + currentUser.getEmail() + "(verified: " + currentUser.isEmailVerified() + ")");


            findViewById(R.id.email_password_buttons).setVisibility(View.GONE);
            findViewById(R.id.email_password_fields).setVisibility(View.GONE);
            findViewById(R.id.layout_signed_in_buttons).setVisibility(View.VISIBLE);

            findViewById(R.id.btn_verify_email).setEnabled(!currentUser.isEmailVerified());

            findViewById(R.id.layout_forgot_password).setVisibility(View.GONE);
        } else
            {
            txtStatus.setText("Signed Out");


            findViewById(R.id.email_password_buttons).setVisibility(View.VISIBLE);
            findViewById(R.id.email_password_fields).setVisibility(View.VISIBLE);
            findViewById(R.id.layout_signed_in_buttons).setVisibility(View.GONE);

            findViewById(R.id.layout_forgot_password).setVisibility(View.VISIBLE);
        }
    }
}
