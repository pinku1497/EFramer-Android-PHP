package com.example.e_farmerplace.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.e_farmerplace.AddtocartActivity;
import com.example.e_farmerplace.Model.VieewProductResult;
import com.example.e_farmerplace.R;

import java.util.List;

public class FetchproductAdapter extends BaseAdapter
{
    Context context;
    List<VieewProductResult> productResults;
    LayoutInflater inflater;

    public FetchproductAdapter(Context context, List<VieewProductResult> productResults) {
        this.context=context;
        this.productResults=productResults;
        inflater=(LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return productResults.size();
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
       /* Bitmap bm = null;
        String ba1;
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.PNG, 90, bytes);
        byte[] ba = bytes.toByteArray();
          ba1 = Base64.encodeToString(ba,Base64.DEFAULT);

        byte[] decodedString = Base64.decode(ba1, Base64.DEFAULT);

        ba = Base64.decode(decodedString, Base64.DEFAULT);
        Bitmap decodedImage = BitmapFactory.decodeByteArray(ba, 0, ba.length);

       // Bitmap bitmap = BitmapFactory.decodeByteArray(ba, 0,ba.length);*/

      
        
        
        VieewProductResult vieewProductResult=productResults.get(position);
        Log.d("Detail", vieewProductResult.getFertilizer());
        convertView=inflater.inflate(R.layout.row_product,null);

        TextView textView=(TextView)convertView.findViewById(R.id.row_fertname);
        TextView textView1=(TextView)convertView.findViewById(R.id.row_description);
        ImageView imageView=(ImageView)convertView.findViewById(R.id.row_image);
        TextView textView2=(TextView)convertView.findViewById(R.id.row_rate);
        Button button=(Button)convertView.findViewById(R.id.addtocart);

        //imageView.setImageBitmap(decodedImage);
        imageView.setImageBitmap(vieewProductResult.getImage());
        textView.setText(vieewProductResult.getFertilizer());
        textView2.setText(vieewProductResult.getRate());
        textView1.setText(vieewProductResult.getDescription());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.getContext().startActivity(new Intent(context, AddtocartActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });

        return convertView;
    }
}
