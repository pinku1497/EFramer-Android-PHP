package com.example.e_farmerplace;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.e_farmerplace.Adapter.FetchproductAdapter;
import com.example.e_farmerplace.ApiHandler.Apihandler;
import com.example.e_farmerplace.Model.VieewProductResult;
import com.example.e_farmerplace.Model.ViewProductModel;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ViewProductDataActivity extends AppCompatActivity {

ListView listView;
List<VieewProductResult> productResults;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_product_data);

        listView=(ListView)findViewById(R.id.listproduct);
        productResults=new ArrayList<>();

      Apihandler.getApiService().fetch_product(new Callback<ViewProductModel>() {
          @Override
          public void success(ViewProductModel viewProductModel, Response response)
          {
              Toast.makeText(ViewProductDataActivity.this,"Done",Toast.LENGTH_SHORT).show();

            // Log.d("<>",viewProductModel.getResults().toString());

              productResults=viewProductModel.getResults();


              FetchproductAdapter fetchproductAdapter=new FetchproductAdapter(getApplicationContext(),productResults);
              listView.setAdapter(fetchproductAdapter);
          }

          @Override
          public void failure(RetrofitError error)
          {
              Toast.makeText(ViewProductDataActivity.this,"Faill",Toast.LENGTH_SHORT).show();
          }
      });

    }
}
