package com.example.e_farmerplace.Seller.ui.home;

import android.Manifest;
import android.Manifest.permission;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.e_farmerplace.DemoCameraGallaryActivity;
import com.example.e_farmerplace.Farmer_GallaryActivity;
import com.example.e_farmerplace.MainActivity;
import com.example.e_farmerplace.R;


public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    ImageView imageView;
    Button button,productbtn;
    private static final int RESULT_LOAD_IMAGE = 11;
    private static final int PERMISSION_CODE = 110;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.activity_seller__home_flipper, container, false);
        final TextView textView = root.findViewById(R.id.txtdemo);
        Button productbtn=root.findViewById(R.id.productbtn);
        productbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(getActivity(), DemoCameraGallaryActivity.class);
                startActivity(i);
            }
        });
        return root;
    }
}