package com.example.e_farmerplace.Seller.ui.slideshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProductSoldViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ProductSoldViewModel()
    {
        mText = new MutableLiveData<>();
        mText.setValue("Product Sold");
    }

    public LiveData<String> getText()
    {
        return mText;
    }
}