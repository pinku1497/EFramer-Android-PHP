package com.example.e_farmerplace.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.e_farmerplace.Adapter.BuyProductAdapter;
import com.example.e_farmerplace.BuyProduct_Activity;
import com.example.e_farmerplace.DTO.BuyProduct_DTO;
import com.example.e_farmerplace.R;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {


    private GalleryViewModel galleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
            final TextView textView = root.findViewById(R.id.text_slideshow);

            return root;


        }
    }