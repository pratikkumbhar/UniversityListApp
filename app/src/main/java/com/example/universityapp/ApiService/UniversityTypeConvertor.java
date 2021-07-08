package com.example.universityapp.ApiService;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class UniversityTypeConvertor {
    @TypeConverter
    public List<String> fromString(String value) {
        Type listtype = new TypeToken<List<String>>() {
        }.getType();
        return new Gson().fromJson(value, listtype);
    }

    @TypeConverter
   public  String totheString(List<String> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }
}
