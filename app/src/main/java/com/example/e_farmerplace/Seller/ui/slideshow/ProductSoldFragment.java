package com.example.e_farmerplace.Seller.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.e_farmerplace.Adapter.FetchproductAdapter;
import com.example.e_farmerplace.ApiHandler.Apihandler;
import com.example.e_farmerplace.Model.VieewProductResult;
import com.example.e_farmerplace.Model.ViewProductModel;
import com.example.e_farmerplace.R;
import com.example.e_farmerplace.ViewProductDataActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class ProductSoldFragment extends Fragment
{

    ListView listView;
    List<VieewProductResult> productResults;
    private ProductSoldViewModel productSoldViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState)
    {
        productSoldViewModel =
                ViewModelProviders.of(this).get(ProductSoldViewModel.class);
        View root = inflater.inflate(R.layout.activity_view_product_data, container, false);
        final TextView textView = root.findViewById(R.id.productdetail);
       listView=root.findViewById(R.id.listproduct);
        productResults=new ArrayList<>();
        Apihandler.getApiService().fetch_product(new Callback<ViewProductModel>()
        {
            @Override
            public void success(ViewProductModel viewProductModel, Response response)
            {
                Toast.makeText(getActivity(),"Done",Toast.LENGTH_SHORT).show();

                // Log.d("<>",viewProductModel.getResults().toString());

                productResults=viewProductModel.getResults();


                FetchproductAdapter fetchproductAdapter=new FetchproductAdapter(getContext(),productResults);
                listView.setAdapter(fetchproductAdapter);
            }

            @Override
            public void failure(RetrofitError error)
            {
                Toast.makeText(getActivity(),"Faill",Toast.LENGTH_SHORT).show();
            }
        });

        productSoldViewModel.getText().observe(this, new Observer<String>()
        {
            @Override
            public void onChanged(@Nullable String s)
            {
                textView.setText(s);
            }
        });
        return root;
    }
}