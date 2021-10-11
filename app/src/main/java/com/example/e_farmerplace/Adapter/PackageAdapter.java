package com.example.e_farmerplace.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.e_farmerplace.AddtocartActivity;
import com.example.e_farmerplace.ApiHandler.Apihandler;
import com.example.e_farmerplace.Model.VieewProductResult;
import com.example.e_farmerplace.Model.ViewPackageResult;
import com.example.e_farmerplace.PaymentActivity;
import com.example.e_farmerplace.R;

import java.util.List;

public class PackageAdapter extends BaseAdapter  {
    Context context;
    List<ViewPackageResult> packageResults;
    LayoutInflater inflater;
    public PackageAdapter(Context context, List<ViewPackageResult> packageResults)
    {
        this.context=context;
        this.packageResults=packageResults;
        inflater=(LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return packageResults.size();
    }

    @Override
    public Object getItem(int position) {
        return packageResults.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewPackageResult viewPackageResult=packageResults.get(position);

        Log.d("Detail",viewPackageResult.getPpackage());

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=inflater.inflate(R.layout.row_package,null);
        TextView textView=(TextView)convertView.findViewById(R.id.packagename);
        TextView textView2=(TextView)convertView.findViewById(R.id.duration);
        TextView textView3=(TextView)convertView.findViewById(R.id.rate);
        TextView textView4=(TextView)convertView.findViewById(R.id.description);
        Button button=(Button)convertView.findViewById(R.id.buy);;

        textView.setText(viewPackageResult.getPpackage());
        textView2.setText(viewPackageResult.getDuration());
        textView3.setText(viewPackageResult.getRate());
        textView4.setText(viewPackageResult.getDescription());
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                v.getContext().startActivity(new Intent(context,PaymentActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });
        return convertView;
    }


}
