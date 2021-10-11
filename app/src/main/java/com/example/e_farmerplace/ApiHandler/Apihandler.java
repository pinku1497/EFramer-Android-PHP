package com.example.e_farmerplace.ApiHandler;

import com.google.gson.Gson;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

public class Apihandler
{
    public static final String BASE_URL ="http://desireinfotech.biz/efarmer_apis/";
    private static Webservices apiService;

    public static Webservices getApiService()
    {
        if (apiService == null)
        {
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .setEndpoint(BASE_URL)
                    .setConverter(new GsonConverter(new Gson()))
                    .build();
            apiService = restAdapter.create(Webservices.class);
            return apiService;
        }
        else
        {
            return apiService;
        }
    }

}
