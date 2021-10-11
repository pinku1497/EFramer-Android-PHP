package com.example.e_farmerplace.Seller;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.e_farmerplace.Farmer_BuyProductActivity;
import com.example.e_farmerplace.R;
import com.example.e_farmerplace.Seller.ui.gallery.ProductFragment;
import com.example.e_farmerplace.ui.gallery.GalleryFragment;
import com.example.e_farmerplace.ui.slideshow.SlideshowFragment;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class Seller_ProductActivity extends AppCompatActivity {
    Button psubmit, pbrowse;
    EditText pname, prate,des;
    ImageView imageView;
    String ba1;
    private static int RESULT_LOAD_IMAGE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_);

        pname = (EditText) findViewById(R.id.pname);
        prate = (EditText) findViewById(R.id.prate);
        des=(EditText)findViewById(R.id.description);
        imageView=(ImageView)findViewById(R.id.primage);
        psubmit = (Button) findViewById(R.id.psubmit);

        pbrowse = (Button) findViewById(R.id.pbrowse);

        pbrowse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(
                        Intent.ACTION_PICK,

                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });
        psubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Seller_ProductActivity.this, "Insert Successfully..", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(Seller_ProductActivity.this, Farmer_BuyProductActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode ==RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};


            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();

            Bitmap bm = null;
            if (data != null)
            {
                try
                {
                    bm = MediaStore.Images.Media.getBitmap
                            (getApplicationContext().getContentResolver(), data.getData());
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }

            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            bm.compress(Bitmap.CompressFormat.JPEG, 90, bytes);
            byte[] ba = bytes.toByteArray();
            ba1 = Base64.encodeToString(ba,Base64.DEFAULT);
            ba= Base64.decode(ba1, Base64.DEFAULT);
            Bitmap decodedImage = BitmapFactory.decodeByteArray(ba, 0, ba.length);
            imageView.setImageBitmap(decodedImage);

            File destination = new File(Environment.getExternalStorageDirectory(),
                    "img1" + ".jpg");
            String nm = destination.toString() + "" + "aaaaa";
            Log.e("FIle name from gallary", nm);

            imageView.setImageBitmap(bm);

            // ImageView imageView = (ImageView)findViewById(R.id.primage);
            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));

        }
    }
    }

