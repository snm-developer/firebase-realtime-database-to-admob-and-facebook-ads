package com.snm.ads.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.snm.ads.AD.AdmobBanner;
import com.snm.ads.AD.AdmobInterstitial;
import com.snm.ads.AD.FacebookBanner;
import com.snm.ads.R;

public class MainActivity extends AppCompatActivity {

    Button butBannerAd, butInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        butBannerAd = findViewById(R.id.butBannerAd);
        butInterstitialAd = findViewById(R.id.butInterstitialAd);

        butBannerAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, Banner.class);
                startActivity(intent);


            }
        });

        butInterstitialAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, Interstitial.class);
                startActivity(intent);

            }
        });

    }

}