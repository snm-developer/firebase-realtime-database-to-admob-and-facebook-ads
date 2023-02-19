package com.snm.ads.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.snm.ads.AD.AdmobInterstitial;
import com.snm.ads.AD.FacebookInterstitial;
import com.snm.ads.R;

public class Interstitial extends AppCompatActivity {

    Button interstitialADShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interstitial);

        interstitialADShow = findViewById(R.id.interstitialADShow);

        AdmobInterstitial admobInterstitial = new AdmobInterstitial(this);
        admobInterstitial.AdmobInterstitialAD();

        FacebookInterstitial facebookInterstitial = new FacebookInterstitial(this);
        facebookInterstitial.FacebookInterstitialAD();

        interstitialADShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if ( admobInterstitial.mInterstitialAd != null ) {

                    admobInterstitial.mInterstitialAd.show(Interstitial.this);

                }

                if(facebookInterstitial.fbinterstitialAd == null || !facebookInterstitial.fbinterstitialAd.isAdLoaded()) {
                    return;
                }

                if(facebookInterstitial.fbinterstitialAd.isAdInvalidated()) {
                    return;
                }

                facebookInterstitial.fbinterstitialAd.show();

            }
        });

    }
}