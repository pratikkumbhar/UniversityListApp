package com.example.universityapp.ApiService;

import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroBuilder {
    private static final String BASEURL = "http://universities.hipolabs.com/";
    private static Retrofit retrofit = null;

    public static Retrofit getClient()
    {
        if (retrofit==null)
        {
            retrofit = new Retrofit.Builder().baseUrl(BASEURL).addConverterFactory(GsonConverterFactory.create()).build();
            Log.i("123","builed");
        }
        return retrofit;
    }

}
