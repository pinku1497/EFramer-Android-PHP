package com.example.e_farmerplace;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.e_farmerplace.Adapter.FruiteSearchAdapter;
import com.example.e_farmerplace.Adapter.SearchAdapter;
import com.example.e_farmerplace.DTO.Fruite_DTO;
import com.example.e_farmerplace.DTO.Search_DTO;

import java.util.ArrayList;

public class SearchProductFruite extends AppCompatActivity
{
    ListView listView;
    ArrayList<Fruite_DTO> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_product_fruite);
        listView=(ListView)findViewById(R.id.serchlist);
        arrayList=new ArrayList<>();

        Fruite_DTO ob=new Fruite_DTO();
        ob.name="Tometo";
        ob.desc="Tomatoes are heavy feeders and usually do need fertilizer unless your soil is very rich.";
        ob.image=R.drawable.apple;

        Fruite_DTO ob1=new Fruite_DTO();
        ob1.name="Cabage";
        ob1.desc="It is better to use urea instead of Ammonium Sulphate where the soil is relatively acidic. If the soil is boron deficient, 5 –10 kg/ha borax should be applied before land preparation. " ;
        ob1.image=R.drawable.mango;

        Fruite_DTO ob2=new Fruite_DTO();
        ob2.name="LadiesFinger";
        ob2.desc="Fertilizers are applied by opening up a deep narrow furrow on one side of each sowing ridge.\n" +
                "Generally, nitrogen fertilizers like urea, calcium ammonium nitrate (CAN) and ammonium sulphate\n" +
                "should be used for this crop.";
        ob2.image=R.drawable.strawberry;

        Fruite_DTO ob3=new Fruite_DTO();
        ob3.name="Poteto";
        ob3.desc="Organic gardeners use a variety of fertilizers during the growing season after they plant seed potatoes. Using a mixture of cottonseed meal, bone meal and greensand increases the soil's acidity and provides nitrogen, potassium and phosphorous. A small amount of kelp meal combined in the mixture supplies trace minerals";
        ob3.image=R.drawable.image111;

        arrayList.add(ob);
        arrayList.add(ob1);
        arrayList.add(ob2);
        arrayList.add(ob3);

        FruiteSearchAdapter fruiteSearchAdapter=new FruiteSearchAdapter(getApplicationContext(),arrayList);
        listView.setAdapter(fruiteSearchAdapter);

    }
}
