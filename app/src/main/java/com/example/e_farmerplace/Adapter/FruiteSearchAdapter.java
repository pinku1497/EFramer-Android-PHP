package com.example.e_farmerplace.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.e_farmerplace.DTO.Fruite_DTO;
import com.example.e_farmerplace.DTO.Search_DTO;
import com.example.e_farmerplace.R;

import java.util.ArrayList;

public class FruiteSearchAdapter extends BaseAdapter
{
    Context applicationContext;
    ArrayList<Fruite_DTO> arrayList;
    LayoutInflater inflater;

    public FruiteSearchAdapter(Context applicationContext, ArrayList<Fruite_DTO> arrayList) {
        this.applicationContext=applicationContext;
        this.arrayList=arrayList;
        inflater=(LayoutInflater.from(applicationContext));
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
        LayoutInflater inflater=(LayoutInflater)applicationContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        convertView=inflater.inflate(R.layout.row_searchfruite,null);
        ImageView imageView=(ImageView)convertView.findViewById(R.id.pimage);
        TextView textView=(TextView)convertView.findViewById(R.id.name);
         TextView textView1=(TextView)convertView.findViewById(R.id.desc);


        Fruite_DTO fruite_dto=arrayList.get(position);
         textView.setText(fruite_dto.name);
         textView1.setText(fruite_dto.desc);
         imageView.setImageResource(fruite_dto.image);

        return convertView;
    }
}
