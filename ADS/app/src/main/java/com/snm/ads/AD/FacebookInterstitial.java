package com.snm.ads.AD;

import android.content.Context;

import androidx.annotation.NonNull;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FacebookInterstitial {

    Context context;
    private String FacebookInterstitialID;
    public  InterstitialAd fbinterstitialAd;

    public FacebookInterstitial (Context context){

        this.context = context;

    }

    public void FacebookInterstitialAD (){

        FirebaseDatabase db = FirebaseDatabase.getInstance();
        db.getReference().child("Ads").child("ADType").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String ADType = snapshot.getValue(String.class);

                if ( ADType.contains("Facebook") ){

                    db.getReference().child("Ads").child("Facebook").child("facebookInterstitialAdID").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            FacebookInterstitialID = snapshot.getValue(String.class);

                            loadFacebookInterstitialAd();

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });

    }

    private void loadFacebookInterstitialAd() {

        fbinterstitialAd = new InterstitialAd(context, FacebookInterstitialID);

        InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {

            }

            @Override
            public void onInterstitialDismissed(Ad ad) {

                loadFacebookInterstitialAd();

            }

            @Override
            public void onError(Ad ad, AdError adError) {

            }

            @Override
            public void onAdLoaded(Ad ad) {

            }

            @Override
            public void onAdClicked(Ad ad) {

            }

            @Override
            public void onLoggingImpression(Ad ad) {

            }
        };

        fbinterstitialAd.loadAd( fbinterstitialAd.buildLoadAdConfig().withAdListener(interstitialAdListener ).build());

    }

}
