package com.example.e_farmerplace.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.e_farmerplace.BuyProduct_Activity;
import com.example.e_farmerplace.DTO.BuyProduct_DTO;
import com.example.e_farmerplace.Farmer_BuyProductActivity;
import com.example.e_farmerplace.R;

import java.util.ArrayList;

public class BuyProductAdapter extends BaseAdapter
{
    Context context;
    ArrayList<BuyProduct_DTO> arrayList;
    LayoutInflater inflater;


    public BuyProductAdapter(BuyProduct_Activity buyProduct_activity, ArrayList<BuyProduct_DTO> arrayList)
    {
        this.context=buyProduct_activity;
        this.arrayList=arrayList;
        inflater=(LayoutInflater.from(context));
    }

    public BuyProductAdapter(Context applicationContext, int row_buyproduct, ArrayList<BuyProduct_DTO> arrayList)
    {
        this.context=applicationContext;
        this.arrayList=arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        convertView=inflater.inflate(R.layout.row_buyproduct,null);
        ImageView imageView=(ImageView)convertView.findViewById(R.id.productimg);
        TextView textView=(TextView)convertView.findViewById(R.id.prname);
        TextView textView1=(TextView)convertView.findViewById(R.id.prrate);
        Button button=(Button)convertView.findViewById(R.id.prbuy);


        BuyProduct_DTO buyProduct_dto=arrayList.get(position);
        textView.setText(buyProduct_dto.name);
        textView1.setText(buyProduct_dto.rate1);
        imageView.setImageResource(buyProduct_dto.image);


        return convertView;
    }
}
