package com.example.e_farmerplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class Mail_Activity extends AppCompatActivity {
EditText edtmail,edtnum,edtotp;
Button mail,btn,login;
Random random;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail_);
        edtmail=(EditText)findViewById(R.id.edtmail);
        mail=(Button)findViewById(R.id.mail);
        edtnum=(EditText)findViewById(R.id.edtnum);
        btn=(Button)findViewById(R.id.btn);
        edtotp=(EditText)findViewById(R.id.otp);
        login=(Button)findViewById(R.id.login);

        Random random=new Random();
        final String otp = String.format("%04d",random.nextInt(1000));
        mail.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                String message=edtmail.getText().toString();

               Intent email = new Intent(Intent.ACTION_SEND);
               email.putExtra(Intent.EXTRA_EMAIL,new String[]{"jeelraval2411@gmail.com"});
              email.putExtra(Intent.EXTRA_SUBJECT,"Add your Subject");
               email.putExtra(Intent.EXTRA_TEXT,message);


                startActivity(Intent.createChooser(email ,"Send Email :"));
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number=edtnum.getText().toString();

                SmsManager smsManager=SmsManager.getDefault();
                smsManager.sendTextMessage(number,null,otp,null,null);
                Toast.makeText(Mail_Activity.this,"Sent SUccessully..",Toast.LENGTH_SHORT).show();
                edtotp.setVisibility(View.VISIBLE);
                edtotp.setText(otp);

                btn.setVisibility(View.INVISIBLE);
                login.setVisibility(View.VISIBLE);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtotp.getText().toString().equals(otp))
                {
                    Intent i=new Intent(Mail_Activity.this,MainActivity.class);
                    startActivity(i);
                }
                else
                {
                    Intent i=new Intent(Mail_Activity.this,Mail_Activity.class);
                    startActivity(i);
                }
            }
        });
    }
}
