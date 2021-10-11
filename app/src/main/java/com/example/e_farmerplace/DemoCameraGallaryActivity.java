package com.example.e_farmerplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

import com.example.e_farmerplace.ApiHandler.Apihandler;
import com.example.e_farmerplace.Model.SrProductModel;
import com.example.e_farmerplace.Seller.Seller_Activity_final;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class DemoCameraGallaryActivity extends AppCompatActivity {
    private int REQUEST_CAMERA = 0, SELECT_FILE = 1;
    private Button btnSelect,btnSubmit;
    EditText pname,prate,des;
    private ImageView ivImage;
    private String userChoosenTask;
 String ba1;
 String image;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_camera_gallary);

        pname=(EditText)findViewById(R.id.fertname);
        prate=(EditText)findViewById(R.id.rate);
        ivImage=(ImageView)findViewById(R.id.fertimage);
        des=(EditText)findViewById(R.id.description);
        btnSubmit=(Button)findViewById(R.id.psubmit);
        btnSelect = (Button) findViewById(R.id.btnSelectPhoto);
        btnSubmit.setOnClickListener(new View.OnClickListener()
       {
           @Override
           public void onClick(View v)
           {
               Apihandler.getApiService().product(pname.getText().toString(),ba1.getBytes().toString(), prate.getText().toString(), des.getText().toString(), new Callback<SrProductModel>() {

                   @Override
                   public void success(SrProductModel srProductModel, Response response)
                   {
                       Toast.makeText(DemoCameraGallaryActivity.this,"Done",Toast.LENGTH_SHORT).show();

                       Intent i=new Intent(DemoCameraGallaryActivity.this, Seller_Activity_final.class);
                       startActivity(i);
                   }
                   @Override
                   public void failure(RetrofitError error)
                   {
                       Toast.makeText(getApplicationContext(),"Fail",Toast.LENGTH_SHORT).show();
                   }
               });
           }
       });
        btnSelect.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {

                selectImage();
            }
        });
        ivImage = (ImageView)findViewById(R.id.fertimage);
    }

    private void selectImage()
    {
        final CharSequence[] items = {"Take Photo", "Choose from Library", "Cancel"};

        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(DemoCameraGallaryActivity.this);
        builder.setTitle("Add Photo!");

        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {


                if (items[item].equals("Take Photo")) {
                    userChoosenTask = "Take Photo";

                    cameraIntent();

                } else if (items[item].equals("Choose from Library")) {
                    userChoosenTask = "Choose from Library";

                    galleryIntent();

                } else if (items[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    private void galleryIntent()
    {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);//
        startActivityForResult(Intent.createChooser(intent, "Select File"), SELECT_FILE);
    }

    private void cameraIntent()
    {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_CAMERA);
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_FILE)
                onSelectFromGalleryResult(data);
            else if (requestCode == REQUEST_CAMERA)
                onCaptureImageResult(data);
        }
        }
    private void onCaptureImageResult(Intent data)
    {
        Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        thumbnail.compress(Bitmap.CompressFormat.JPEG, 90, bytes);

        File destination = new File(Environment.getExternalStorageDirectory(),
                System.currentTimeMillis() + ".jpg");
        Log.e("FIle name from camera", destination.toString());
        FileOutputStream fo;
        try {
            destination.createNewFile();
            fo = new FileOutputStream(destination);
            fo.write(bytes.toByteArray());
            fo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ivImage.setImageBitmap(thumbnail);
    }



    private Bitmap onSelectFromGalleryResult(Intent data)
    {
        Bitmap bm = null;
        if (data != null) {
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

        bm.compress(Bitmap.CompressFormat.PNG, 90, bytes);
        byte[] ba = bytes.toByteArray();
        ba1 = Base64.encodeToString(ba,Base64.DEFAULT);
        ba= Base64.decode(ba1, Base64.DEFAULT);
        Bitmap decodeImage = BitmapFactory.decodeByteArray(ba, 0,ba.length);

      // bm = BitmapFactory.decodeFile("http://desireinfotech.biz/efarmer_apis/upload");

       // byte[] encodeByte = Base64.decode(, Base64.DEFAULT);

        ivImage.setImageBitmap(decodeImage);

       /* File destination = new File(Environment.getExternalStorageDirectory(),
                "img1" + ".jpg");
        String nm = destination.toString() + "" + "aaaaa";
       Log.e("FIle name from gallary", nm);*/

        ivImage.setImageBitmap(bm);
       // return decodeImage;
        return bm;
    }
}

