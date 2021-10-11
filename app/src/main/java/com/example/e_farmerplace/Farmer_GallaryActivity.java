package com.example.e_farmerplace;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.e_farmerplace.Seller.ui.gallery.ProductFragment;
import com.example.e_farmerplace.Seller.ui.home.HomeFragment;

public class Farmer_GallaryActivity extends AppCompatActivity {

    ImageView imageView;
    Button button;
    private static final int RESULT_LOAD_IMAGE = 11;
    private static final int PERMISSION_CODE = 110;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer__gallary);

        if (savedInstanceState == null)
        {
            // During initial setup, plug in the details fragment.
            HomeFragment details = new HomeFragment();
            details.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(android.R.id.content, details).commit();
            imageView = findViewById(R.id.gallaryimage);
            button = findViewById(R.id.choose);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(i, RESULT_LOAD_IMAGE);
                }
            });
        }

    }
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMAGE  && resultCode == Activity.RESULT_OK)
        {
            Farmer_GallaryActivity activity=(Farmer_GallaryActivity)this.getApplicationContext();
            //MainActivity activity = (MainActivity)getActivity();
            Bitmap bitmap = getBitmapFromCameraData(data,activity);
            imageView.setImageBitmap(bitmap);
        }
        else
        {
            Log.d("<>","message");
        }
    }
    private Bitmap getBitmapFromCameraData(Intent data, Farmer_GallaryActivity activity)
    {
        Uri selectedImage = data.getData();
        String[] filePathColumn = { MediaStore.Images.Media.DATA };
        Cursor cursor = activity.getContentResolver().query(selectedImage,filePathColumn, null, null, null);
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
        String picturePath = cursor.getString(columnIndex);
        cursor.close();
        return BitmapFactory.decodeFile(picturePath);
    }

}
