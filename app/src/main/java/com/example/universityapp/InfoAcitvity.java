package com.example.universityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.universityapp.databinding.ActivityInfoAcitvityBinding;

public class InfoAcitvity extends AppCompatActivity {
ActivityInfoAcitvityBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        binding = ActivityInfoAcitvityBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getSupportActionBar().hide();


        String domains = getIntent().getStringExtra("domains");
        String name = getIntent().getStringExtra("name");
        String alpha_two_code = getIntent().getStringExtra("alpha_two_code");
        String web_pages = getIntent().getStringExtra("web_pages");

        String state_province = getIntent().getStringExtra("state-province");
        String country = getIntent().getStringExtra("country");

        binding.infoUniversityTitle.setText(name);
        binding.infoCountry.setText(country);
        binding.infoDomains.setText(domains);
        binding.infoState.setText(state_province);
        binding.infoWebsite.setText(web_pages);
        binding.alphaCode.setText(alpha_two_code);
        binding.closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.slide_out, R.anim.slide_in);
            }
        });
    }

}