package com.example.e_farmerplace;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.e_farmerplace.R;
import com.example.e_farmerplace.Seller.Seller_Login_Activity;


import java.util.ArrayList;

public class Main_Home_Activity extends AppCompatActivity {
    ImageView imgfarmer,imgseller;
        Spinner spin1;
        Button vegetable,fruite,crop,button;
      ArrayList<String> list;
       // ArrayList<String> list1;

         @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sellor__main_);

        imgfarmer=(ImageView)findViewById(R.id.imgfarmer);
        imgseller=(ImageView)findViewById(R.id.imgseller);
     spin1=(Spinner)findViewById(R.id.spin1);
     button=(Button)findViewById(R.id.btnsubmit);
     //  spin2=(Spinner)findViewById(R.id.spin2);


             imgseller.setOnClickListener(new View.OnClickListener()
             {
                 @Override
                 public void onClick(View v)
                 {
                     Intent i=new Intent(Main_Home_Activity.this, Seller_Login_Activity.class);
                     startActivity(i);
                 }
             });
             imgfarmer.setOnClickListener(new View.OnClickListener()
             {
                 @Override
                 public void onClick(View v)
                 {
                     Intent intent=new Intent(Main_Home_Activity.this,LoginActivity.class);
                     startActivity(intent);
                 }
             });
       /*search.setOnClickListener(new View.OnClickListener()
       {
           @Override
           public void onClick(View v)
           {
               Intent i=new Intent(Main_Home_Activity.this,.class);
               startActivity(i);
           }
       });*/
    list=new ArrayList<String>();

       list.add("Organic"); 
       list.add("Chemical");


             final ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,list);
             spin1.setAdapter(arrayAdapter);
             spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                 @Override
                 public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                      spin1.getItemAtPosition(position);
                      // spin1.setSelection(position);

                       button.setOnClickListener(new View.OnClickListener()
                       {
                           @Override
                           public void onClick(View v)
                           {

                                   Intent i = new Intent(Main_Home_Activity.this, SearchProductFruite.class);
                                   startActivity(i);

                                  // Intent i1=new Intent(getApplicationContext(),SearchProductActivity.class);
                                  // startActivity(i1);
                           }
                       });
                      //  String veg=spin1.getItemAtPosition(list).toString();

                       // Intent i=new Intent(Main_Home_Activity.this,SearchProductFruite.class);
                        //startActivity(i);

                      //Toast.makeText(Main_Home_Activity.this,veg,Toast.LENGTH_SHORT).show();
                 }

                 @Override
                 public void onNothingSelected(AdapterView<?> parent)
                 {

                 }
             });


        /*list1=new ArrayList<String>();

        list1.add("Tometo");
        list1.add("Poteto");
        list1.add("Ladies Fingure");
        list1.add("Cabage");
        list1.add("Cucumber");
        list1.add("Onion");
        list1.add("Broccoli");
        list1.add("Brinjal");




        final ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,list1);
        spin2.setAdapter(adapter);

             spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {

                //String string=spin2.getSelectedItem().toString();
               // Toast.makeText(Main_Home_Activity.this,string,Toast.LENGTH_SHORT).show();
            /*     if(position==0)
             {
                 spin2.setAdapter(adapter);

             }*/
            }


          /*  public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });
        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                spin2.getSelectedItem().toString();
                spin2.setSelection(position);

               // spin1.setSelection(position);
               // spin1.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });*/



}
