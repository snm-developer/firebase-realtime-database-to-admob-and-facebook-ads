package com.snm.ads.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.snm.ads.AD.BannerADType;
import com.snm.ads.R;

public class Banner extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);

        BannerADType.BannerADConfigType(Banner.this);

    }

}