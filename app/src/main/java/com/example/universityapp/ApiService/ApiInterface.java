package com.example.universityapp.ApiService;



import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("search?country=India")
    Call<List<UniversityModel>> getData();


}
