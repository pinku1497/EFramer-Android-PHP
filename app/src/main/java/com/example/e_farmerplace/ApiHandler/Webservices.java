package com.example.e_farmerplace.ApiHandler;

import android.widget.ImageView;

import com.example.e_farmerplace.Model.FrRegistrationModel;
import com.example.e_farmerplace.Model.ImageModel;
import com.example.e_farmerplace.Model.LoginModel;
import com.example.e_farmerplace.Model.PaymentModel;
import com.example.e_farmerplace.Model.SrLoginModel;
import com.example.e_farmerplace.Model.SrProductModel;
import com.example.e_farmerplace.Model.SrRegistrationModel;
import com.example.e_farmerplace.Model.ViewPackageModel;
import com.example.e_farmerplace.Model.ViewProductModel;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;
import retrofit.mime.TypedFile;

public interface Webservices
{
        @GET("/farmerlogin.php")
        public void per(@Query("email") String email,
                        @Query("password") String password,
                        Callback<LoginModel> callback);

    @GET("/farmerreg.php")
    public void registraion(@Query("fname") String fname,
                            @Query("femail") String femail,
                            @Query("fpassword") String fpassword,
                            @Query("fcpassword") String fcpassword,
                    Callback<FrRegistrationModel> callback);

    @GET("/sellerLogin.php")
    public void srlogin(@Query("sremail") String sremail,
                    @Query("srpassword") String srpassword,
                    Callback<SrLoginModel> callback);
    @GET("/sellerreg.php")
    public void srregistraion(@Query("srname") String srname,
                            @Query("sremail") String sremail,
                            @Query("srpass") String srpass,
                            @Query("srcpass") String srcpass,
                            Callback<SrRegistrationModel> callback);

    @GET("/sellerproduct.php")
    public void product(@Query("fertname") String fertname,
                        @Query("image") String image,
                        @Query("rate") String rate,
                        @Query("description") String description,
                        Callback<SrProductModel>callback);

    @GET("/fetchproduct.php")
    public void fetch_product(Callback<ViewProductModel> callback);

    @GET("/fetchpackage.php")
    public void fetch_package(Callback<ViewPackageModel> callback);

    @GET("/payment.php")
    public void pay(@Query("name") String name,
                              @Query("mob") String mob,
                              Callback<PaymentModel> callback);
    @GET("/image.php")
    public void img(@Query("image") ImageView image,
                    Callback<ImageModel> callback);
}
