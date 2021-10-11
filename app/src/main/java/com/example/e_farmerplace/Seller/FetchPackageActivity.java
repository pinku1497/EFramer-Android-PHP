package com.example.e_farmerplace.Seller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.e_farmerplace.Adapter.PackageAdapter;
import com.example.e_farmerplace.ApiHandler.Apihandler;
import com.example.e_farmerplace.Model.ViewPackageModel;
import com.example.e_farmerplace.Model.ViewPackageResult;
import com.example.e_farmerplace.R;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class FetchPackageActivity extends AppCompatActivity {

    ListView listView;
    List<ViewPackageResult> packageResults;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpackage);

        listView=(ListView)findViewById(R.id.packagelist);
        packageResults=new ArrayList<>();

        Apihandler.getApiService().fetch_package(new Callback<ViewPackageModel>() {
            @Override
            public void success(ViewPackageModel viewPackageModel, Response response)
            {
                Toast.makeText(getApplicationContext(),"Done",Toast.LENGTH_SHORT).show();

                packageResults=viewPackageModel.getResults();

                PackageAdapter packageAdapter=new PackageAdapter(getApplicationContext(),packageResults);
                listView.setAdapter(packageAdapter);
            }

            @Override
            public void failure(RetrofitError error)
            {
                Toast.makeText(getApplicationContext(),"Fail",Toast.LENGTH_SHORT).show();

            }
        });
    }
}
