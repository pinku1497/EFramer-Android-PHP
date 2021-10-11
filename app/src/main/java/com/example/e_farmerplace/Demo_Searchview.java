package com.example.e_farmerplace;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import java.util.ArrayList;

public class Demo_Searchview extends AppCompatActivity {

    SearchView searchView;
    ListView listView;
    ArrayList<String> list;
    ArrayAdapter<String > adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo__searchview);
        searchView=(SearchView)findViewById(R.id.search);
        listView = (ListView) findViewById(R.id.list);

        list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Pineapple");
        list.add("Orange");
        list.add("Lychee");
        list.add("Gavava");
        list.add("Peech");
        list.add("Melon");
        list.add("Watermelon");
        list.add("Papaya");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);

       searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
           @Override
           public boolean onQueryTextSubmit(String query)
           {

               if(list.contains(query))
               {
                   adapter.getFilter().filter(query);
               }
               else
                   {
                       Intent i=new Intent(Demo_Searchview.this,Main_Home_Activity.class);
                       startActivity(i);
                         Toast.makeText(Demo_Searchview.this, "No Match found",Toast.LENGTH_LONG).show();
                  }
               return false;
           }

           @Override
           public boolean onQueryTextChange(String newText)
           {
               adapter.getFilter().filter(newText);
               return false;
           }
       });
    }
}
