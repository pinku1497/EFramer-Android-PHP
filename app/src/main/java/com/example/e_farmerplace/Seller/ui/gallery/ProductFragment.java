package com.example.e_farmerplace.Seller.ui.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.e_farmerplace.R;
import com.example.e_farmerplace.Seller.FetchPackageActivity;


public class ProductFragment extends Fragment {


    private ProductViewModel productViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState)
    {
        productViewModel =
                ViewModelProviders.of(this).get(ProductViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        final TextView textView = root.findViewById(R.id.txtproduct);
        Button button=(Button)root.findViewById(R.id.btnpackage);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(getActivity(), FetchPackageActivity.class);
                startActivity(i);
            }
        });

        productViewModel.getText().observe(this, new Observer<String>()
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

