package com.example.universityapp;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.universityapp.ApiService.UniversityModel;

import java.util.List;

public class RecyclerAdaptor extends RecyclerView.Adapter<RecyclerAdaptor.MyviewModel> {
    List<UniversityModel> listl;
    Context context;


    public RecyclerAdaptor(List<UniversityModel> listl, Context context) {
        this.listl = listl;
        this.context = context;
    }

    @NonNull
    @Override
    public MyviewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.recycler_item,parent,false);

        return new MyviewModel(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdaptor.MyviewModel holder, int position) {
        holder.title.setText(listl.get(position).getName().toString());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,InfoAcitvity.class);
                intent.putExtra("domains",listl.get(position).getDomains().toString());
                intent.putExtra("web_pages",listl.get(position).getWebPages().toString());
                intent.putExtra("name",listl.get(position).getName().toString());
                intent.putExtra("state-province",listl.get(position).getStateProvince());
                intent.putExtra("alpha_two_code","IN");


                intent.putExtra("country",listl.get(position).getCountry().toString());

                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return listl.size();
    }

    public class MyviewModel extends RecyclerView.ViewHolder{
        TextView title;
        public MyviewModel(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.recycler_item_textview);

        }
    }

}
