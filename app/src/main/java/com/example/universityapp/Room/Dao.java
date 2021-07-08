package com.example.universityapp.Room;


import androidx.room.Insert;
import androidx.room.Query;

import com.example.universityapp.ApiService.UniversityModel;

import java.util.List;

@androidx.room.Dao
public interface Dao {

    @Insert
    void insetData(List<UniversityModel> list);

    @Query("select * from usertable")
    List<UniversityModel> getAllData();
}
