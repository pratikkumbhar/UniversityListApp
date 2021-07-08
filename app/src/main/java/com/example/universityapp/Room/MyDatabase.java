package com.example.universityapp.Room;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.universityapp.ApiService.UniversityModel;
import com.example.universityapp.ApiService.UniversityTypeConvertor;

@Database(entities = UniversityModel.class, version = 1)
@TypeConverters(UniversityTypeConvertor.class)
 public abstract class MyDatabase extends RoomDatabase {

    public abstract Dao userDao();

    private static volatile MyDatabase INSTANCE;

    public static MyDatabase getINSTANCE(final Context context){
        if (INSTANCE==null) {
            synchronized (MyDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, MyDatabase.class, "mydatabase").allowMainThreadQueries().build();
                }
            }
        }
        return INSTANCE;

    }

}
