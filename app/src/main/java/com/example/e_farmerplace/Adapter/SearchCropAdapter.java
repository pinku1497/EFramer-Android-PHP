package com.example.e_farmerplace.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.e_farmerplace.DTO.Crop_DTO;
import com.example.e_farmerplace.DTO.Search_DTO;
import com.example.e_farmerplace.R;

import java.util.ArrayList;

public class SearchCropAdapter extends BaseAdapter
{
    Context context;
    ArrayList<Crop_DTO> arrayList;
    LayoutInflater inflater;
    public SearchCropAdapter(Context context, ArrayList<Crop_DTO> arrayList)
    {
        this.context=context;
        this.arrayList=arrayList;
        inflater=(LayoutInflater.from(context));
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
        convertView=inflater.inflate(R.layout.row_searchcrop,null);
        ImageView imageView=(ImageView)convertView.findViewById(R.id.pimage);
        TextView textView=(TextView)convertView.findViewById(R.id.name);
        TextView textView1=(TextView)convertView.findViewById(R.id.desc);


        Crop_DTO crop_dto=arrayList.get(position);
        textView.setText(crop_dto.name);
        textView1.setText(crop_dto.desc);
        imageView.setImageResource(crop_dto.image);

        return convertView;
    }
}
