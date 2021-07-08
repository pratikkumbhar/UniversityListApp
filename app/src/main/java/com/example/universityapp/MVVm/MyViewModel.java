package com.example.universityapp.MVVm;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.universityapp.ApiService.ApiInterface;
import com.example.universityapp.ApiService.RetroBuilder;
import com.example.universityapp.ApiService.UniversityModel;
import com.example.universityapp.Room.MyDatabase;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyViewModel extends ViewModel {

    public MutableLiveData<List<UniversityModel>> getLIst;
    public MutableLiveData<List<UniversityModel>> getOffllinelist;

    public MyViewModel()
    {

        getLIst = new MutableLiveData<>();
    }
    public MutableLiveData<List<UniversityModel>> getUniversityList()
    {

        return getLIst;
    } public MutableLiveData<List<UniversityModel>> getOffliveLIst()
    {

        return getOffllinelist;
    }





    public void MakeApiCall()
    {
        ApiInterface apiInterface = RetroBuilder.getClient().create(ApiInterface.class);
        Call<List<UniversityModel>> call = apiInterface.getData();
        call.enqueue(new Callback<List<UniversityModel>>() {
            @Override
            public void onResponse(Call<List<UniversityModel>> call, Response<List<UniversityModel>> response) {
                if (response.isSuccessful())
                {
                    getLIst.postValue(response.body());

                }
            }

            @Override
            public void onFailure(Call<List<UniversityModel>> call, Throwable t) {
                Log.i("123",t.getMessage());
            }
        });
    }




}

