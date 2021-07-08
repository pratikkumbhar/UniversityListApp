package com.example.universityapp;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.universityapp.ApiService.UniversityModel;
import com.example.universityapp.MVVm.MyViewModel;
import com.example.universityapp.Room.MyDatabase;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class MainActivity extends AppCompatActivity {

RecyclerView recyclerView;
List<UniversityModel> models = new ArrayList<>();
 MyViewModel viewModel;
 RecyclerAdaptor adaptor;

 ProgressDialog progressDialog;

MyDatabase database;
ConstraintLayout coordinatorLayout;
boolean isInserted = false;
    final String PREFS_NAME = "MyPrefsFile";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        firsttimerun();
        coordinatorLayout = findViewById(R.id.mainlayout);
        database = MyDatabase.getINSTANCE(this);
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Loading Universities");
        progressDialog.setCancelable(false);
        progressDialog.show();
        recyclerView = findViewById(R.id.recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        viewModel = ViewModelProviders.of(this).get(MyViewModel.class);

        viewModel.MakeApiCall();


        if (isNetworkConnected()) {
            viewModel.getUniversityList().observe(this, new Observer<List<UniversityModel>>() {
                @Override
                public void onChanged(List<UniversityModel> universityModels) {

                    setDatatorecyclerView(universityModels);

                    if(!isInserted)
                    {
                     database.userDao().insetData(universityModels);
                     isInserted = true;
                    }

                }
            });
        }
        else {
            List<UniversityModel> allData = database.userDao().getAllData();
            Snackbar snackbar = Snackbar.make(coordinatorLayout,"Offline Mode",Snackbar.LENGTH_LONG);
            View v = snackbar.getView();
            v.setBackgroundColor(Color.parseColor("#F64B4B"));
            snackbar.show();

            setDataOffline(allData);

        }






    }
    public void firsttimerun()
    {
        

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);

        if (settings.getBoolean("my_first_time", true)) {

            Toast.makeText(this, "Turn On Internet Atleast on Time To GetData", Toast.LENGTH_LONG).show();

            
            settings.edit().putBoolean("my_first_time", false).apply();
        }
    }

    private void setDataOffline(List<UniversityModel> universityModels) {
        adaptor = new RecyclerAdaptor(universityModels,MainActivity.this);
        recyclerView.setAdapter(adaptor);
        progressDialog.dismiss();
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }

    public void setDatatorecyclerView(List<UniversityModel> universityModels)
    {
        adaptor = new RecyclerAdaptor(universityModels,MainActivity.this);
        recyclerView.setAdapter(adaptor);
        progressDialog.dismiss();
    }


}
