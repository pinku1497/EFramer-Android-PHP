package com.example.e_farmerplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.e_farmerplace.Adapter.BuyProductAdapter;
import com.example.e_farmerplace.DTO.BuyProduct_DTO;

import java.util.ArrayList;

public class BuyProduct_Activity extends AppCompatActivity {
    ListView list;
    ArrayList<BuyProduct_DTO> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_product_);
        list=(ListView)findViewById(R.id.prlist);
        Button btn=(Button)findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(BuyProduct_Activity.this,AddtocartActivity.class);
                startActivity(i);
            }
        });
        arrayList=new ArrayList<BuyProduct_DTO>();

        BuyProduct_DTO ob=new BuyProduct_DTO();
        ob.name="Urea";
        ob.rate1="900rs";
        ob.image=R.drawable.uria;

        BuyProduct_DTO ob1=new BuyProduct_DTO();
        ob1.name="Sulphete";
        ob1.rate1="1000rs";
        ob1.image=R.drawable.ammoniumsulphate;

        BuyProduct_DTO ob2=new BuyProduct_DTO();
        ob2.rate1="500rs";
        ob2.name="DAP";
        ob2.image=R.drawable.dia;

        arrayList.add(ob);
        arrayList.add(ob1);
        arrayList.add(ob2);


        BuyProductAdapter buyProductAdapter=new BuyProductAdapter(BuyProduct_Activity.this,arrayList);

        list.setAdapter(buyProductAdapter);
    }
}
