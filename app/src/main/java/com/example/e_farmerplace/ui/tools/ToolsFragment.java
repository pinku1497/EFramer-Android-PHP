package com.example.e_farmerplace.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.e_farmerplace.AddtocartActivity;
import com.example.e_farmerplace.BuyProduct_Activity;
import com.example.e_farmerplace.Farmer_BuyProductActivity;
import com.example.e_farmerplace.R;
import com.example.e_farmerplace.Seller.Seller_HomeFlipperActivity;
import com.example.e_farmerplace.ViewProductDataActivity;

public class ToolsFragment extends Fragment {

    private ToolsViewModel toolsViewModel;
ViewFlipper v_flipper;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        toolsViewModel =
                ViewModelProviders.of(this).get(ToolsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_tools, container, false);
        final TextView textView = root.findViewById(R.id.text_tools);
        Button button = root.findViewById(R.id.buyproduct);
        int images[] = {R.drawable.splash2, R.drawable.fertilizer, R.drawable.fermer, R.drawable.fert2};
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(), ViewProductDataActivity.class);
                startActivity(i);
            }
        });
        toolsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        v_flipper = (ViewFlipper) root.findViewById(R.id.v_flipper);

        for (int i = 0; i < images.length; i++) {
            flipperImages(images[i]);
        }
        return root;
    }


    public void flipperImages(int image)
    {
        ImageView imageView=new ImageView(getActivity());
        imageView.setBackgroundResource(image);
        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(3000); //1 sec
        v_flipper.setAutoStart(true);
        //  v_flipper.showNext();

        //Animation
        v_flipper.setInAnimation(getActivity(),android.R.anim.slide_out_right);
        //  v_flipper.setOutAnimation(Demo_Home.this,android.R.anim.slide_out_right);

    }

}