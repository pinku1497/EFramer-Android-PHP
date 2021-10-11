package com.example.e_farmerplace.Utility;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class AppPreference
{
    private static String USER_NAME = "UserName";
    private static String Paymentid="Payment";
    public static SharedPreferences sharedPreferences;
    public static SharedPreferences.Editor editor;

    public AppPreference(Context context)
    {
        sharedPreferences = context.getSharedPreferences("E-Farmerplace", Activity.MODE_PRIVATE);


        editor = sharedPreferences.edit();

    }
    public String getUserName()
    {
        return sharedPreferences.getString(USER_NAME, "");
    }

    public void setUserName(String value)
    {
        editor.putString(USER_NAME, value);
        editor.commit();
    }

    public String getPaymentID()
    {
        return sharedPreferences.getString(Paymentid, "");
    }

    public void setPaymentID(String value)
    {
        editor.putString(Paymentid, value);
        editor.commit();
    }

}
